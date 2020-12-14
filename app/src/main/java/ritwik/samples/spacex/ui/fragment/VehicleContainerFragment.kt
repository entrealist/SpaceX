package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import androidx.viewpager2.widget.ViewPager2

import com.google.android.material.tabs.TabLayout

import com.google.android.material.tabs.TabLayoutMediator

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.FragmentVehicleContainerBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import ritwik.samples.spacex.ui.adapter.VehiclesAdapter

import sample.ritwik.common.ui.fragment.BaseFragment

/**
 * [BaseFragment] to show different kinds of SpaceX Vehicles.
 *
 * @author Ritwik Jamuar
 */
class VehicleContainerFragment :
    BaseFragment<FragmentVehicleContainerBinding, MainModel, MainViewModel>() {

    /*---------------------------------------- Components ----------------------------------------*/

    /**
     * Reference of [TabLayoutMediator] to mediate between
     * [com.google.android.material.tabs.TabLayout] and [androidx.viewpager2.widget.ViewPager2].
     */
    private var tabLayoutMediator: TabLayoutMediator? = null

    /*---------------------------------- BaseFragment Callbacks ----------------------------------*/

    override fun layoutRes(): Int = R.layout.fragment_vehicle_container

    override fun extractArguments(arguments: Bundle) = Unit

    override fun initializeViews() {
        setUpViewPager()
        setUpTabLayout()
    }

    override fun showLoading() = Unit

    override fun hideLoading() = Unit

    override fun onUIDataChanged(uiData: MainModel) = Unit

    override fun onAction(uiData: MainModel) = Unit

    override fun cleanUp() = binding?.let { viewBinding ->
        cleanUpViewPager(viewBinding.fragmentVehiclesViewPager)
        cleanUpTabLayoutMediator()
    } ?: Unit

    /*------------------------------------- Private Methods --------------------------------------*/

    /**
     * Sets-up the [androidx.viewpager2.widget.ViewPager2] enclosed under [binding].
     */
    private fun setUpViewPager() = binding?.fragmentVehiclesViewPager?.let { viewPager ->
        viewPager.adapter = VehiclesAdapter(this)
    } ?: Unit

    /**
     * Sets-up the [com.google.android.material.tabs.TabLayout] enclosed under [binding].
     */
    private fun setUpTabLayout() = binding?.fragmentVehiclesTabLayout?.let { tabLayout ->
        binding?.fragmentVehiclesViewPager?.let { viewPager ->
            setUpTabLayoutMediator(tabLayout, viewPager)
        }
    } ?: Unit

    /**
     * Sets-up the [TabLayoutMediator] using [TabLayout] and [ViewPager2].
     *
     * @param tabLayout Instance of [TabLayout].
     * @param viewPager Instance of [ViewPager2].
     */
    private fun setUpTabLayoutMediator(tabLayout: TabLayout, viewPager: ViewPager2) {

        // Set the TabLayoutMediator to set the Tab Text according to the
        // position of the Fragment currently rendered by the ViewPager.
        tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> getString(R.string.vehicle_type_rocket)
                1 -> getString(R.string.vehicle_type_capsule)
                else -> ""
            }
        }

        // Attach the TabLayoutMediator in the view.
        tabLayoutMediator?.attach()

    }

    /**
     * Cleans-up the [ViewPager2] from the current view.
     */
    private fun cleanUpViewPager(viewPager: ViewPager2) {
        viewPager.adapter = null
    }

    /**
     * Cleans-up the [TabLayoutMediator] from the current view.
     */
    private fun cleanUpTabLayoutMediator() {
        tabLayoutMediator?.detach() // Detach the TabLayoutMediator from view first.
        tabLayoutMediator = null // Re-reference the current instance of TabLayoutMediator for Garbage Collection.
    }

}
