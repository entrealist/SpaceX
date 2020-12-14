package ritwik.samples.spacex.mvvm.model

import ritwik.samples.spacex.data.network.CapsuleResponse
import ritwik.samples.spacex.data.network.LaunchResponse
import ritwik.samples.spacex.data.network.RocketResponse

import ritwik.samples.spacex.data.ui.*

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

    /**
     * [List] of [Rocket] denoting the collection of Rockets.
     */
    lateinit var rockets: List<Rocket>

    /**
     * [List] of [Capsule] denoting the collection of Capsules.
     */
    lateinit var capsules: List<Capsule>

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
     * Checks whether [rockets] is populated or not,
     * by checking whether it is initialized as well as it is not empty.
     *
     * @return true, if [rockets] is initialized and is not empty, else false.
     */
    fun isRocketsPopulated(): Boolean = this::rockets.isInitialized && rockets.isNotEmpty()

    /**
     * Checks whether [capsules] is populated or not,
     * by checking whether it is initialized as well as it is not empty.
     *
     * @return true, if [capsules] is initialized and is not empty, else false.
     */
    fun isCapsulesPopulated(): Boolean = this::capsules.isInitialized && capsules.isNotEmpty()

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
                            name ?: "",
                            convertUTCDateTime(utcDate ?: ""),
                            0, // TODO : Figure out how to get the Block Number, since it is no longer available.
                            links?.webCast ?: ""
                        )
                    )
                }
            }
        }

    /**
     * Extracts the [List] of [Rocket] from the given [responseRockets].
     *
     * @param responseRockets [List] of [RocketResponse] denoting all the Rockets from REST API.
     * @return Converted [List] of [Rocket] using [responseRockets].
     */
    fun extractRocketsFromResponse(responseRockets: List<RocketResponse>) =
        ArrayList<Rocket>().apply {
            for (responseRocket in responseRockets) {
                with(responseRocket) {
                    add(
                        Rocket(
                            id ?: "",
                            name ?: "",
                            type ?: "",
                            active ?: false,
                            description ?: "",
                            RocketDimensions(
                                RocketDimension(
                                    height?.meters ?: 0F,
                                    height?.feet ?: 0F
                                ),
                                RocketDimension(
                                    diameter?.meters ?: 0F,
                                    diameter?.feet ?: 0F
                                )
                            ),
                            RocketWeight(
                                mass?.kilogram ?: 0F,
                                mass?.pound ?: 0F
                            ),
                            RocketEngine(
                                engine?.engineNumber ?: 0,
                                engine?.engineVersionName ?: "",
                                engine?.engineType ?: "",
                                engine?.engineLayout ?: "",
                                engine?.maximumEngineLoss?.toFloat() ?: 0F,
                                ArrayList<String>().apply {
                                    engine?.let { e ->
                                        if (!e.propellant1.isNullOrEmpty()) {
                                            add(e.propellant1)
                                        }
                                        if (!e.propellant2.isNullOrEmpty()) {
                                            add(e.propellant2)
                                        }
                                    }
                                },
                                engine?.thrustToWeightRatio ?: 0F,
                                RocketEngineThrusts(
                                    RocketEngineThrust(
                                        engine?.seaLevelThrust?.kiloNewton ?: 0F,
                                        engine?.seaLevelThrust?.poundForce ?: 0F
                                    ),
                                    RocketEngineThrust(
                                        engine?.vacuumThrust?.kiloNewton ?: 0F,
                                        engine?.vacuumThrust?.poundForce ?: 0F
                                    )
                                ),
                                RocketEngineSpecificImpulse(
                                    engine?.isp?.seaLevel ?: 0F,
                                    engine?.isp?.vacuum ?: 0F
                                )
                            ),
                            ArrayList<RocketPayload>().apply {
                                payloads?.let { p ->

                                    if (p.isEmpty()) return@let

                                    for (responsePayload in p) {
                                        add(
                                            RocketPayload(
                                                responsePayload.id ?: "",
                                                responsePayload.name ?: "",
                                                RocketPayloadWeight(
                                                    responsePayload.massInKilogram ?: 0F,
                                                    responsePayload.massInPound ?: 0F
                                                )
                                            )
                                        )
                                    }

                                }
                            },
                            stagesCount ?: 0,
                            boostersCount ?: 0,
                            costPerLaunch ?: 0L,
                            successRatePercentage ?: 0,
                            firstFlightDate ?: "",
                            country ?: "",
                            company ?: "",
                            images ?: ArrayList()
                        )
                    )
                }
            }
        }

    /**
     * Extracts the [List] of [Capsule] from the given [responseCapsules].
     *
     * @param responseCapsules [List] of [CapsuleResponse] denoting all the Capsules from REST API.
     * @return Converted [List] of [Capsule] using [responseCapsules].
     */
    fun extractCapsulesFromResponse(responseCapsules: List<CapsuleResponse>) =
        ArrayList<Capsule>().apply {
            for (responseCapsule in responseCapsules) {
                with(responseCapsule) {
                    add(
                        Capsule(
                            id ?: "",
                            serial ?: "",
                            type ?: "",
                            status ?: "",
                            lastUpdate ?: "",
                            reuseCount ?: 0,
                            CapsuleLanding(
                                waterLandingCount ?: 0,
                                landLandingCount ?: 0
                            ),
                            launches ?: ArrayList()
                        )
                    )
                }
            }
        }

    /**
     * Calculate the Remaining Time of an Upcoming [Launch] from first element of [upcomingLaunches].
     *
     * @return If the [upcomingLaunches] is either null or empty,
     *   or the first element from [upcomingLaunches] has empty Date-Time,
     *   then 0 will be returned, else the Value as Milli-Seconds denoting the
     *   remaining time of launch.
     */
    fun calculateTimingForUpcomingLaunch(): Long {

        // Declare a variable denoting the Time Left for Upcoming Launch as 0.
        var upcomingTimeLeft: Long = 0

        // Halt the further execution and return the current value of 'upcomingTimeLeft'
        // since the 'upcomingLaunches' is either null or empty.
        if (upcomingLaunches.isNullOrEmpty()) return upcomingTimeLeft

        // Get the first element from 'upcomingLaunches' and declare the reference as 'latestLaunch'.
        val latestLaunch = upcomingLaunches[0]

        // Halt the further execution and return the current value of 'upcomingTimeLeft'
        // since the Date Time of Mission of 'latestLaunch' is empty.
        if (latestLaunch.missionDateTime.isEmpty()) return upcomingTimeLeft

        // Use SimpleDateFormatter to parse the given Date in String Format to a 'Date' object.
        SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.ENGLISH).apply {
            parse(latestLaunch.missionDateTime)?.let { parsedDate ->
                // Calculate the difference between Parsed Date Time and Current Date Time
                // and assign to 'upcomingTimeLeft'.
                upcomingTimeLeft = parsedDate.time - Date().time
            }
        }

        // Return the modified value.
        return upcomingTimeLeft

    }

    /*------------------------------------- Private Methods --------------------------------------*/

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

        // Set the Time Zone of Input Format as the UTC Time Zone.
        inputFormat.timeZone = TimeZone.getTimeZone(TimeZone.getAvailableIDs()[588])

        // Define an Output Format of Date and Time.
        val outputFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.ENGLISH)

        // Set the Time Zone of the device.
        // This can potentially be the source of bug
        // since the implementation of the method 'getDefault' is Device Manufacturer specific,
        // and we have no control over it.
        outputFormat.timeZone = TimeZone.getDefault()

        // Parse the UTC Date and Time to get Date.
        val date = inputFormat.parse(utcDate)

        // Format the Date to our own Format of Date and Time.
        return date?.let {
            outputFormat.format(it)
        } ?: ""

    }

}
