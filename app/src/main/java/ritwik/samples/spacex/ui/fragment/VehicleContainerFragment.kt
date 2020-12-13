package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

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
        viewBinding.fragmentVehiclesViewPager.adapter = null
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

            // Set the TabLayoutMediator to set the Tab Text according to the
            // position of the Fragment currently rendered by the ViewPager.
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = when(position) {
                    0 -> getString(R.string.vehicle_type_rocket)
                    1 -> getString(R.string.vehicle_type_capsule)
                    else -> ""
                }
            }.attach()

        }
    } ?: Unit

}
