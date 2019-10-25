package ritwik.samples.spacex.ui.main

import android.view.Menu

import androidx.appcompat.widget.Toolbar

import androidx.core.view.GravityCompat

import androidx.drawerlayout.widget.DrawerLayout

import androidx.fragment.app.FragmentManager

import androidx.lifecycle.Observer

import androidx.navigation.NavController
import androidx.navigation.Navigation

import androidx.navigation.ui.NavigationUI

import com.google.android.material.navigation.NavigationView

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseActivity

import ritwik.samples.spacex.ui.main.di.DaggerMainComponent
import ritwik.samples.spacex.ui.main.di.MainComponent
import ritwik.samples.spacex.ui.main.di.MainModule

import ritwik.samples.spacex.ui.main.fragments.*

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

import javax.inject.Inject

class MainActivity
	: BaseActivity (),
	LaunchesFragment.Listener,
	LaunchesListFragment.Listener,
	VehicleFragment.Listener,
	RocketListFragment.Listener,
	CapsuleListFragment.Listener {
	// ViewModel.
	@Inject lateinit var viewModel : MainViewModel

	// Views.
	private var toolbar : Toolbar? = null
	private var drawerLayout : DrawerLayout? = null
	private var navigationView : NavigationView? = null
	private var navigationController : NavController? = null

	/*----------------------------------------- Observers ----------------------------------------*/

	/**[Observer] for observing change in Internet Connectivity.*/
	private val noInternetObserver = Observer < Boolean > {
		// TODO : Show some UI that states no Internet Connectivity.
	}

	/**[Observer] for observing the error value.*/
	private val errorObserver = Observer < String > {
		// TODO : Show some UI that shows error from RESTful API.
	}

	/*------------------------------ NavigationItemSelectedListener ------------------------------*/

	/**[NavigationView.OnNavigationItemSelectedListener] for listening the user selection of
	 * option in Navigation Drawer.*/
	private val navigationItemSelectedListener = NavigationView.OnNavigationItemSelectedListener {
		it.isChecked = true
		drawerLayout?.closeDrawers ()
		// TODO : Need to find a better implementation of Fragment Navigation.
		when ( it.itemId ) {
			R.id.menu_item_launches -> {
				navigationController?.popBackStack ( R.id.launchesFragment, true )
			}

			R.id.menu_item_vehicle -> {
				navigationController?.navigate ( R.id.action_launchesFragment_to_vehicleFragment )
			}
		}
		true
	}

	/*-------------------------- Navigation Destination Changed Listener -------------------------*/

	/**[NavController.OnDestinationChangedListener] to detect the change in [Navigation]'s
	 * destination.*/
	private val navigationDestinationChangeListener =
		NavController.OnDestinationChangedListener {
			_, destination, _ ->
			when ( destination.label ) {
				resources.getString ( R.string.view_label_launches ) -> toggleDrawerLock (true )
				else -> toggleDrawerLock (false )
			}
		}

	/*---------------------------------- BaseActivity Callbacks ----------------------------------*/

	override fun inject () {
		val component : MainComponent = DaggerMainComponent
			.builder ()
			.mainModule ( MainModule ( this ) )
			.build ()
		component.injectActivity ( this )
	}

	override fun initialize () {
		initializeViews ()
		attachObservers ()
	}

	override fun getLayoutRes () : Int = R.layout.activity_main

	override fun cleanUp () {
		// TODO : Add code for de-reference.
	}

	/*----------------------------------- Activity Callbacks -------------------------------------*/

	override fun onCreateOptionsMenu ( menu : Menu? ) : Boolean {
		menuInflater.inflate ( R.menu.main_menu, menu )
		return super.onCreateOptionsMenu ( menu )
	}

	override fun onSupportNavigateUp () : Boolean {
		return NavigationUI.navigateUp ( navigationController!!, drawerLayout )
	}

	override fun onBackPressed () {
		if ( drawerLayout!!.isDrawerOpen ( GravityCompat.START ) ) {
			drawerLayout?.closeDrawer ( GravityCompat.START )
		} else {
			super.onBackPressed ()
		}
	}

	/*------------------------------------- Private Methods --------------------------------------*/

	/**Method to initialize and configure the views of MainActivity.*/
	private fun initializeViews () {
		initializeToolbar ()
		initializeNavigationDrawer ()
	}

	/**Method to initialize and configure the Toolbar in MainActivity.*/
	private fun initializeToolbar () {
		// Instantiate Toolbar.
		toolbar = findViewById ( R.id.activity_main_toolbar )

		// Set the Toolbar to ActionBar.
		setSupportActionBar ( toolbar )

		// Configure the ActionBar.
		actionBar?.setDisplayHomeAsUpEnabled ( true )
	}

	/**Method to initialize and configure the DrawerLayout and NavigationView in MainActivity.*/
	private fun initializeNavigationDrawer () {
		// Initialize the Drawer Layout.
		drawerLayout = findViewById ( R.id.activity_main_drawer_layout )

		// Initialize the Navigation View.
		navigationView = findViewById ( R.id.activity_main_navigation_view )

		navigationController = Navigation.findNavController ( this, R.id.activity_main_fragment )
		navigationController?.addOnDestinationChangedListener ( navigationDestinationChangeListener )

		NavigationUI.setupActionBarWithNavController ( this, navigationController!!, drawerLayout!! )
		NavigationUI.setupWithNavController ( navigationView!!, navigationController!! )

		// Set the NavigationItemSelectedListener to NavigationView in order to listen the
		// selection made by the user in the Navigation Drawer.
		navigationView?.setNavigationItemSelectedListener ( navigationItemSelectedListener )
	}

	/**Attaches [Observer]s to this [android.app.Activity].*/
	private fun attachObservers () {
		viewModel.noInternetLiveData.observe ( this, noInternetObserver )
		viewModel.errorLiveData.observe ( this, errorObserver )
	}

	/**Toggles the Lock Mode of [DrawerLayout] used in this [android.app.Activity].
	 * @param enabled [Boolean] to decide the lock of [DrawerLayout].*/
	private fun toggleDrawerLock ( enabled : Boolean ) {
		// Decide the Lock Mode.
		val lockMode = if ( enabled ) {
			DrawerLayout.LOCK_MODE_UNLOCKED
		} else {
			DrawerLayout.LOCK_MODE_LOCKED_CLOSED
		}

		// Set the Lock Mode.
		drawerLayout?.setDrawerLockMode ( lockMode )
	}

	/*------------------------------- MainFragmentListener Callbacks -----------------------------*/

	override fun getFMFromActivity () : FragmentManager = supportFragmentManager

	override fun getVM () : MainViewModel = viewModel

}