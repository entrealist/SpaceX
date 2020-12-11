package ritwik.samples.spacex.mvvm.model

import ritwik.samples.spacex.data.ui.Launch

import sample.ritwik.common.mvvm.model.BaseModel

import javax.inject.Inject

/**
 * Model Class of [ritwik.samples.spacex.ui.activity.MainActivity].
 *
 * @author Ritwik Jamuar
 */
class MainModel @Inject constructor() : BaseModel() {

    /*------------------------------------- Member Variables -------------------------------------*/

    /**
     * [List] of [Launch] denoting the collection of Upcoming Launches.
     */
    lateinit var upcomingLaunches: List<Launch>

    /**
     * [List] of [Launch] denoting the collection of Completed Launches.
     */
    lateinit var completedLaunches: List<Launch>

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Checks whether [upcomingLaunches] is populated or not,
     * by checking whether it is initialized as well as it is not empty.
     *
     * @return true, if [upcomingLaunches] is initialized and is not empty, else false.
     */
    fun isUpcomingLaunchesPopulated(): Boolean =
        this::upcomingLaunches.isInitialized && upcomingLaunches.isNotEmpty()

    /**
     * Checks whether [completedLaunches] is populated or not,
     * by checking whether it is initialized as well as it is not empty.
     *
     * @return true, if [completedLaunches] is initialized and is not empty, else false.
     */
    fun isCompletedLaunchesPopulated(): Boolean =
        this::completedLaunches.isInitialized && completedLaunches.isNotEmpty()

}
