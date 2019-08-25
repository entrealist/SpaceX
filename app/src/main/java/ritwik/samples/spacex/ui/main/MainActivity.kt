package ritwik.samples.spacex.ui.main

import android.os.Bundle

import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity

import androidx.appcompat.widget.Toolbar

import androidx.core.view.GravityCompat

import androidx.drawerlayout.widget.DrawerLayout

import androidx.fragment.app.FragmentManager

import com.google.android.material.navigation.NavigationView

import ritwik.samples.spacex.R

import ritwik.samples.spacex.ui.main.di.DaggerMainComponent
import ritwik.samples.spacex.ui.main.di.MainComponent
import ritwik.samples.spacex.ui.main.di.MainModule

import ritwik.samples.spacex.ui.main.fragments.LaunchesFragment
import ritwik.samples.spacex.ui.main.fragments.LaunchesListFragment

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

import javax.inject.Inject

class MainActivity
	: AppCompatActivity (),
	LaunchesFragment.Listener,
	LaunchesListFragment.Listener {
	// ViewModel.
	@Inject lateinit var viewModel : MainViewModel

	// Views.
	private var toolbar : Toolbar? = null
	private var drawerLayout : DrawerLayout? = null
	private var navigationView : NavigationView? = null

	/**[NavigationView.OnNavigationItemSelectedListener] for listening the user selection of
	 * option in Navigation Drawer.*/
	private val navigationItemSelectedListener = NavigationView.OnNavigationItemSelectedListener {
		when ( it.itemId ) {
			R.id.menu_item_launches -> {

			}

			R.id.menu_item_vehicle -> {

			}

			R.id.menu_item_core -> {

			}

			R.id.menu_item_company -> {

			}

			R.id.menu_item_history -> {

			}

			R.id.menu_item_about -> {

			}
		}
		true
	}

	/*----------------------------------- Activity Callbacks -------------------------------------*/

	override fun onCreate ( savedInstanceState : Bundle? ) {
		super.onCreate ( savedInstanceState )
		setContentView ( R.layout.activity_main )
		inject ()
		initializeViews ()
	}

	override fun onCreateOptionsMenu ( menu : Menu? ) : Boolean {
		menuInflater.inflate ( R.menu.main_menu, menu )
		return super.onCreateOptionsMenu ( menu )
	}

	override fun onOptionsItemSelected ( item : MenuItem? ) : Boolean {
		when ( item?.itemId ) {
			android.R.id.home -> {
				drawerLayout?.closeDrawer ( GravityCompat.START )
			}
		}
		return true
	}

	/*------------------------------------- Private Methods --------------------------------------*/

	private fun inject () {
		val component : MainComponent = DaggerMainComponent
			.builder ()
			.mainModule ( MainModule ( this ) )
			.build ()
		component.injectActivity ( this )
	}

	/**Method to initialize and configure the views of MainActivity.*/
	private fun initializeViews () {
		initializeNavigationDrawer ()
		initializeToolbar ()
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

		// Set the NavigationItemSelectedListener to NavigationView in order to listen the
		// selection made by the user in the Navigation Drawer.
		navigationView?.setNavigationItemSelectedListener ( navigationItemSelectedListener )
	}

	/*---------------------------- LaunchesFragment.Listener Callbacks ---------------------------*/

	override fun getFMFromActivity () : FragmentManager {
		return supportFragmentManager
	}

	override fun getVM () : MainViewModel {
		return viewModel
	}
}