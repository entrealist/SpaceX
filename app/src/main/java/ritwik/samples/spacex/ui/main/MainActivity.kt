package ritwik.samples.spacex.ui.main

import android.view.Menu

import androidx.appcompat.widget.Toolbar

import androidx.core.view.GravityCompat

import androidx.databinding.ViewDataBinding

import androidx.drawerlayout.widget.DrawerLayout

import androidx.fragment.app.FragmentManager

import androidx.navigation.NavController
import androidx.navigation.Navigation

import androidx.navigation.ui.NavigationUI

import com.google.android.material.navigation.NavigationView

import com.squareup.picasso.Picasso

import ritwik.samples.spacex.R

import ritwik.samples.spacex.application.App

import ritwik.samples.spacex.common.BaseActivity

import ritwik.samples.spacex.model.Capsule

import ritwik.samples.spacex.ui.main.di.DaggerMainComponent
import ritwik.samples.spacex.ui.main.di.MainComponent
import ritwik.samples.spacex.ui.main.di.MainModule

import ritwik.samples.spacex.ui.main.fragments.*

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

import javax.inject.Inject


class MainActivity
	: BaseActivity (),
	MainFragmentListener,
	CapsulesFragment.Listener {
	// ViewModel.
	@Inject lateinit var viewModel : MainViewModel

	// Views.
	private var toolbar : Toolbar? = null
	private var drawerLayout : DrawerLayout? = null
	private var navigationView : NavigationView? = null
	private var navigationController : NavController? = null

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

			R.id.menu_item_core -> {
				navigationController?.navigate(R.id.action_launchesFragment_to_coreFragment)
			}
		}
		true
	}

	/*---------------------------------- BaseActivity Callbacks ----------------------------------*/

	override fun inject () {
		val component : MainComponent = DaggerMainComponent
			.builder ()
			.mainModule ( MainModule ( this ) )
			.build ()
		component.injectActivity ( this )
	}

	override fun layoutRes(): Int = R.layout.activity_main

	override fun isDataBinding(): Boolean = false

	override fun bindView(binding: ViewDataBinding) {}

	override fun initialize() {
		initializeViews ()
	}

	override fun cleanUp() {
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

		NavigationUI.setupActionBarWithNavController ( this, navigationController!!, drawerLayout!! )
		NavigationUI.setupWithNavController ( navigationView!!, navigationController!! )

		// Set the NavigationItemSelectedListener to NavigationView in order to listen the
		// selection made by the user in the Navigation Drawer.
		navigationView?.setNavigationItemSelectedListener ( navigationItemSelectedListener )
	}

	/*---------------------------- MainFragmentListener Callbacks ---------------------------*/

	override fun getFMFromActivity () : FragmentManager = supportFragmentManager

	override fun getVM () : MainViewModel = viewModel

	override fun getPicasso(): Picasso = App.getInstance(this).getAppComponent().getPicasso()

	/*-------------------------------- CapsulesFragment Callbacks --------------------------------*/

	override fun navigateToCapsuleDetail(capsule: Capsule) {
		// TODO: Navigate to CapsuleDetailsFragment.
	}

}