package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import com.google.android.material.tabs.TabLayoutMediator

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.FragmentLaunchContainerBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import ritwik.samples.spacex.ui.adapter.LaunchesAdapter

import sample.ritwik.common.ui.fragment.BaseFragment

/**
 * [BaseFragment] to show different kinds of Launches.
 *
 * @author Ritwik Jamuar
 */
class LaunchContainerFragment :
    BaseFragment<FragmentLaunchContainerBinding, MainModel, MainViewModel>() {

    /*---------------------------------- BaseFragment Callbacks ----------------------------------*/

    override fun layoutRes(): Int = R.layout.fragment_launch_container

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
        viewBinding.fragmentLaunchesViewPager.adapter = null
    } ?: Unit

    /*------------------------------------- Private Methods --------------------------------------*/

    /**
     * Sets-up the [androidx.viewpager2.widget.ViewPager2] enclosed under [binding].
     */
    private fun setUpViewPager() = binding?.fragmentLaunchesViewPager?.let { viewPager ->
        viewPager.adapter = LaunchesAdapter(this)
    } ?: Unit

    /**
     * Sets-up the [com.google.android.material.tabs.TabLayout] enclosed under [binding].
     */
    private fun setUpTabLayout() = binding?.fragmentLaunchesTabLayout?.let { tabLayout ->
        binding?.fragmentLaunchesViewPager?.let { viewPager ->

            // Set the TabLayoutMediator to set the Tab Text according to the
            // position of the Fragment currently rendered by the ViewPager.
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = when(position) {
                    0 -> getString(R.string.launch_type_upcoming)
                    1 -> getString(R.string.launch_type_completed)
                    else -> ""
                }
            }.attach()

        }
    } ?: Unit

}
