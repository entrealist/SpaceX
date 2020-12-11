package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import ritwik.samples.spacex.R

import ritwik.samples.spacex.data.ui.LaunchType

import ritwik.samples.spacex.databinding.FragmentLaunchBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import ritwik.samples.spacex.utility.constant.LAUNCH_TYPE

import sample.ritwik.common.ui.fragment.BaseFragment

/**
 * [BaseFragment] to show the list of Launches of given type.
 *
 * @author Ritwik Jamuar
 */
class LaunchFragment : BaseFragment<FragmentLaunchBinding, MainModel, MainViewModel>() {

    /*------------------------------------- Member Variables -------------------------------------*/

    /**
     * Reference of [LaunchType] to identify the type of Launch.
     */
    private lateinit var launchType: LaunchType

    /*---------------------------------- BaseFragment Callbacks ----------------------------------*/

    override fun layoutRes(): Int = R.layout.fragment_launch

    override fun extractArguments(arguments: Bundle) = with(arguments) {
        if (containsKey(LAUNCH_TYPE)) {
            launchType = when(getInt(LAUNCH_TYPE)) {
                0 -> LaunchType.UPCOMING
                1 -> LaunchType.COMPLETED
                else -> LaunchType.UPCOMING
            }
        }
    }

    override fun initializeViews() = Unit

    override fun showLoading() = Unit

    override fun hideLoading() = Unit

    override fun onUIDataChanged(uiData: MainModel) = Unit

    override fun onAction(uiData: MainModel) = Unit

    override fun cleanUp() = Unit

}
