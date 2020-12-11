package ritwik.samples.spacex.mvvm.viewModel

import ritwik.samples.spacex.data.ui.LaunchType

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.repository.MainRepository

import sample.ritwik.common.mvvm.viewModel.BaseViewModel

import javax.inject.Inject

/**
 * ViewModel of [ritwik.samples.spacex.ui.activity.MainActivity].
 *
 * @param repository Instance of [MainRepository] for [repository].
 * @param model Instance of [MainModel] for [model].
 * @author Ritwik Jamuar
 */
class MainViewModel @Inject constructor(
    override val repository: MainRepository,
    override val model: MainModel
) : BaseViewModel<MainRepository, MainModel>() {

    /*--------------------------------- BaseViewModel Callbacks ----------------------------------*/

    override fun initializeLiveData() = Unit

    override fun initializeVariables() = Unit

    override fun onSessionExpired() = Unit

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Fetches the Launches of given [launchType] from making REST API Calls.
     *
     * @param launchType Instance of [LaunchType] denoting the type of Launch.
     */
    fun fetchLaunches(launchType: LaunchType) {
        // TODO: Perform the REST API Call to fetch the Launches of the given launchType.
    }

    /*------------------------------------ Lambda Expressions ------------------------------------*/

    /**
     * Lambda Expression to notify about selection of an Upcoming Event.
     */
    val upcomingLaunchListener: (Int) -> Unit = { position ->
        // TODO: Use the position in model.upcomingLaunches to handle the click on Upcoming Launch.
    }

    /**
     * Lambda Expression to notify about selection of a Completed Event.
     */
    val completedLaunchListener: (Int) -> Unit = { position ->
        // TODO: Use the position in model.completedLaunches to handle the click on Completed Launch.
    }

}
