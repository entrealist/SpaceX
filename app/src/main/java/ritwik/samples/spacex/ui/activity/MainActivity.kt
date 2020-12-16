package ritwik.samples.spacex.ui.activity

import android.view.View

import androidx.lifecycle.ViewModelProvider

import androidx.navigation.NavController
import androidx.navigation.Navigation

import androidx.navigation.ui.setupWithNavController

import com.google.android.material.bottomnavigation.BottomNavigationView

import com.squareup.picasso.Picasso

import dagger.android.AndroidInjection

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.ActivityMainBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import sample.ritwik.common.data.ui.ErrorData

import sample.ritwik.common.mvvm.viewModel.VMFactory

import sample.ritwik.common.ui.activity.BaseActivity

import sample.ritwik.common.utility.helper.NetworkUtils

import javax.inject.Inject

/**
 * [BaseActivity] to show the Main Contents of this application.
 *
 * @author Ritwik Jamuar
 */
class MainActivity : BaseActivity<MainModel, MainViewModel, ActivityMainBinding>() {

    /*---------------------------------------- Components ----------------------------------------*/

    /**
     * Reference of [VMFactory] of this [BaseActivity]
     * injected from [sample.ritwik.common.di.module.ViewModelModule].
     */
    @Inject
    lateinit var vmFactory: VMFactory

    /**
     * Reference of [NetworkUtils], injected from [sample.ritwik.common.di.module.CommonModule].
     */
    @Inject
    lateinit var networkUtility: NetworkUtils

    /**
     * Reference of [Picasso] injected from [sample.ritwik.common.di.module.PicassoModule].
     */
    @Inject
    lateinit var picassoLibrary: Picasso

    /**
     * Reference of [NavController] to control the navigation between different fragments.
     */
    private lateinit var navigationController: NavController

    /*-------------------------------------- View Listeners --------------------------------------*/

    /**
     * [NavController.OnDestinationChangedListener] to intercept change in the
     * destination of [navigationController].
     */
    private val destinationChangedListener =
        NavController.OnDestinationChangedListener { _, destination, _ ->
            binding.bottomNavigationView.menu.findItem(
                when (destination.id) {
                    R.id.fragment_launch_container -> R.id.menu_item_launches
                    R.id.fragment_vehicle_container -> R.id.menu_item_vehicles
                    R.id.fragment_cores -> R.id.menu_item_cores
                    R.id.fragment_about -> R.id.menu_item_about
                    else -> R.id.fragment_launch_container
                }
            ).isChecked = true
        }

    /**
     * [BottomNavigationView.OnNavigationItemSelectedListener] to intercept selection of Menu Item.
     */
    private val bottomNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->

            // Perform Action based on Menu Item.
            navigationController.navigate(
                when (menuItem.itemId) {
                    R.id.menu_item_launches -> R.id.fragment_launch_container
                    R.id.menu_item_vehicles -> R.id.fragment_vehicle_container
                    R.id.menu_item_cores -> R.id.fragment_cores
                    R.id.menu_item_about -> R.id.fragment_about
                    else -> 0
                }
            )

            // Returning 'true' so that we don't have to perform manual selection of item in the
            // BottomNavigationView.
            true

        }

    /*---------------------------------- BaseActivity Callbacks ----------------------------------*/

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)

    override val networkUtils: NetworkUtils
        get() = networkUtility

    override val picasso: Picasso
        get() = picassoLibrary

    override fun layoutRes(): Int = R.layout.activity_main

    override fun inject() = AndroidInjection.inject(this)

    override fun showLoading() = Unit

    override fun hideLoading() = Unit

    override fun showError(errorData: ErrorData) = Unit

    override fun toolbarView(): View? = null

    override fun extractArguments() = Unit

    override fun initialize() {
        setUpViews()
    }

    override fun attachObservers() = Unit

    override fun onUIDataChanged(uiData: MainModel) = Unit

    override fun onAction(uiData: MainModel) = Unit

    override fun cleanUp() = Unit

    /*------------------------------------- Private Methods --------------------------------------*/

    /**
     * Sets-up all the child views under [binding].
     */
    private fun setUpViews() {
        setUpNavigationView()
        setUpBottomNavigationView()
    }

    /**
     * Sets-up the [navigationController].
     */
    private fun setUpNavigationView() {
        navigationController = Navigation.findNavController(
            this@MainActivity,
            R.id.navigation_host_fragment
        ).apply {
            addOnDestinationChangedListener(destinationChangedListener)
        }
    }

    /**
     * Sets-up the [BottomNavigationView] under [binding].
     */
    private fun setUpBottomNavigationView() = with(binding.bottomNavigationView) {
        setupWithNavController(navigationController)
        setOnNavigationItemSelectedListener(bottomNavigationItemSelectedListener)
    }

}
