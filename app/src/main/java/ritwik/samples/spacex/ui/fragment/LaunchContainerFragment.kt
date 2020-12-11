package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.FragmentLaunchContainerBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import sample.ritwik.common.ui.fragment.BaseFragment

/**
 * [BaseFragment] to show different kinds of Launches.
 *
 * @author Ritwik Jamuar
 */
class LaunchContainerFragment :
    BaseFragment<FragmentLaunchContainerBinding, MainModel, MainViewModel>() {

    override fun layoutRes(): Int = R.layout.fragment_launch_container

    override fun extractArguments(arguments: Bundle) = Unit

    override fun initializeViews() = Unit

    override fun showLoading() = Unit

    override fun hideLoading() = Unit

    override fun onUIDataChanged(uiData: MainModel) = Unit

    override fun onAction(uiData: MainModel) = Unit

    override fun cleanUp() = Unit

}
