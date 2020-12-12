package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import android.view.View

import ritwik.samples.spacex.R

import ritwik.samples.spacex.data.ui.LaunchType

import ritwik.samples.spacex.databinding.FragmentLaunchBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import ritwik.samples.spacex.ui.adapter.CompletedLaunchAdapter
import ritwik.samples.spacex.ui.adapter.UpcomingLaunchAdapter

import ritwik.samples.spacex.utility.constant.LAUNCH_TYPE
import ritwik.samples.spacex.utility.constant.POPULATE_LAUNCHES

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
            launchType = when (getInt(LAUNCH_TYPE)) {
                0 -> LaunchType.UPCOMING
                1 -> LaunchType.COMPLETED
                else -> LaunchType.UPCOMING
            }
        }
    }

    override fun initializeViews() {
        setUpView()
        requestData()
    }

    override fun showLoading() = binding?.placeholderShimmerContainer?.let { shimmer ->
        shimmer.visibility = View.VISIBLE
        shimmer.startShimmerAnimation()
    } ?: Unit

    override fun hideLoading() = binding?.placeholderShimmerContainer?.let { shimmer ->
        shimmer.stopShimmerAnimation()
        shimmer.visibility = View.GONE
    } ?: Unit

    override fun onUIDataChanged(uiData: MainModel) = Unit

    override fun onAction(uiData: MainModel) = when (uiData.action) {

        POPULATE_LAUNCHES -> binding?.let { dataBinding ->
            with(dataBinding) {
                when (launchType) {

                    LaunchType.UPCOMING -> {
                        isLaunchesEmpty = !uiData.isUpcomingLaunchesPopulated()
                        (listLaunches.adapter as? UpcomingLaunchAdapter)?.replaceList(
                            uiData.upcomingLaunches
                        ) ?: Unit
                    }

                    LaunchType.COMPLETED -> {
                        isLaunchesEmpty = !uiData.isCompletedLaunchesPopulated()
                        (listLaunches.adapter as? CompletedLaunchAdapter)?.replaceList(
                            uiData.completedLaunches
                        ) ?: Unit
                    }

                }
            }
        } ?: Unit

        else -> Unit

    }

    override fun cleanUp() = binding?.let { dataBinding ->
        dataBinding.listLaunches.adapter = null
    } ?: Unit

    /*------------------------------------- Private Methods --------------------------------------*/

    /**
     * Sets-up the views under [binding].
     */
    private fun setUpView() = binding?.let { dataBinding ->
        viewModel?.let { vm ->
            with(dataBinding) {
                isLaunchTypeUpcoming = launchType == LaunchType.UPCOMING
                isLaunchesEmpty = false
                listLaunches.adapter = when (launchType) {
                    LaunchType.UPCOMING -> UpcomingLaunchAdapter(vm.upcomingLaunchListener)
                    LaunchType.COMPLETED -> CompletedLaunchAdapter(vm.completedLaunchListener)
                }
            }
        }
    } ?: Unit

    /**
     * Requests the data through [viewModel].
     */
    private fun requestData() = viewModel?.fetchLaunches(launchType) ?: Unit

}
