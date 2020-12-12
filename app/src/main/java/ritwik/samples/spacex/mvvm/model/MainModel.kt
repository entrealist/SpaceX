package ritwik.samples.spacex.mvvm.model

import ritwik.samples.spacex.data.network.LaunchResponse

import ritwik.samples.spacex.data.ui.Launch

import sample.ritwik.common.mvvm.model.BaseModel

import java.text.SimpleDateFormat

import java.util.*

import javax.inject.Inject

import kotlin.collections.ArrayList

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

    /**
     * Extracts the [List] of [Launch] from the given [responseLaunches].
     *
     * @param responseLaunches [List] of [LaunchResponse] denoting the Launch List from REST API.
     * @return Converted [List] of [Launch] using [responseLaunches].
     */
    fun extractLaunchesFromResponse(responseLaunches: List<LaunchResponse>) =
        ArrayList<Launch>().apply {
            for (responseLaunch in responseLaunches) {
                with(responseLaunch) {
                    add(
                        Launch(
                            flightNumber ?: 0,
                            missionName ?: "",
                            convertUTCDateTime(utcLaunchDateTime ?: ""),
                            rocket?.secondStage?.block ?: 0,
                            launchLinks?.videoLink ?: ""
                        )
                    )
                }
            }
        }

    /**
     * Converts an UTC Date Time to Formatted Date Time for display in the UI.
     *
     * Refer below Link for more detail on SimpleDateFormat:
     *
     *
     * https://www.journaldev.com/17899/java-simpledateformat-java-date-format
     *
     * @param utcDate [String] containing UTC Date and Time.
     * @return [String] containing formatted Date and Time.
     */
    private fun convertUTCDateTime(utcDate: String): String {

        // Halt the further execution and return empty string if 'utcDate' is empty.
        if (utcDate.isEmpty()) return ""

        // Define an Input Format of Date and Time.
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)

        // Define an Output Format of Date and Time.
        val outputFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.ENGLISH)

        // Parse the UTC Date and Time to get Date.
        val date = inputFormat.parse(utcDate)

        // Format the Date to our own Format of Date and Time.
        return date?.let {
            outputFormat.format(it)
        } ?: ""

    }

}
