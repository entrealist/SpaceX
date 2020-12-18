package ritwik.samples.spacex.mvvm.model

import ritwik.samples.spacex.data.network.*

import ritwik.samples.spacex.data.ui.*

import ritwik.samples.spacex.utility.constant.HISTORIC_EVENT_DATE_TIME_FORMAT
import ritwik.samples.spacex.utility.constant.LAUNCH_DATE_TIME_FORMAT
import ritwik.samples.spacex.utility.constant.UI_DATE_TIME_FORMAT

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

    /**
     * [List] of [Core] denoting the collection of Cores.
     */
    lateinit var cores: List<Core>

    /**
     * Reference of [Company] denoting the details of the Company.
     */
    lateinit var company: Company

    /**
     * [List] of [HistoricEvent] denoting the collection of Historic Event.
     */
    lateinit var historicEvents: List<HistoricEvents>

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
     * Checks whether [cores] is populated or not,
     * by checking whether it is initialized as well as it is not empty.
     *
     * @return true, if [cores] is initialized and is not empty, else false.
     */
    fun isCoresPopulated(): Boolean = this::cores.isInitialized && cores.isNotEmpty()

    /**
     * Checks whether [company] is populated or not,
     * by checking whether it is initialized or not.
     *
     * @return true, if [company] is initialized, else false.
     */
    fun isAboutCompanyPopulated(): Boolean = this::company.isInitialized

    /**
     * Checks whether [historicEvents] is populated or not,
     * by checking whether it is initialized as well as it is not empty.
     *
     * @return true, if [historicEvents] is initialized and is not empty, else false.
     */
    fun isHistoricEventsPopulated(): Boolean =
        this::historicEvents.isInitialized && historicEvents.isNotEmpty()

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
                            convertUTCDateTime(utcDate ?: "", LAUNCH_DATE_TIME_FORMAT, UI_DATE_TIME_FORMAT),
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
     * Extracts the [List] of [Core] from the given [responseCores].
     *
     * @param responseCores [List] of [CoreResponse] denoting all the Cores from REST API.
     * @return Converted [List] of [Core] using [responseCores].
     */
    fun extractCoresFromResponse(responseCores: List<CoreResponse>) = ArrayList<Core>().apply {
        for (responseCore in responseCores) {
            with(responseCore) {
                add(
                    Core(
                        id ?: "",
                        block ?: 0,
                        reuseCount ?: 0,
                        CoreLanding(
                            rtlsAttempts ?: 0,
                            rtlsLandings ?: 0
                        ),
                        CoreLanding(
                            asdsAttempts ?: 0,
                            asdsLandings ?: 0
                        ),
                        lastUpdate ?: "",
                        launches ?: ArrayList(),
                        serial ?: "",
                        status ?: ""
                    )
                )
            }
        }
    }

    /**
     * Extracts the [Company] from given [responseCompany].
     *
     * @param responseCompany Instance of [CompanyResponse] denoting the info about the company
     *   from REST API.
     * @return New Instance of [Company] encapsulating the values under [responseCompany].
     */
    fun extractAboutCompanyFromResponse(responseCompany: CompanyResponse) = with(responseCompany) {
        Company(
            id ?: "5eb75edc42fea42237d7f3ed",
            name ?: "SpaceX",
            founder ?: "Elon Musk",
            founded?.toString() ?: "2002",
            employees ?: 8000,
            vehicles ?: 3,
            launchSites ?: 3,
            testSites ?: 1,
            CompanyHeadExecutives(
                ceo ?: "Elon Musk",
                cto ?: "Elon Musk",
                coo ?: "Gwynne Shotwell",
                propulsionCTO ?: "Tom Mueller"
            ),
            valuation ?: 52000000000,
            summary ?: "",
            CompanyHeadQuarters(
                headQuarters?.address ?: "Rocket Road",
                headQuarters?.city ?: "Hawthorne",
                headQuarters?.state ?: "California"
            ),
            CompanyLinks(
                links?.website ?: "https://www.spacex.com/",
                links?.flickr ?: "https://www.flickr.com/photos/spacex/",
                links?.twitterSpaceX ?: "https://twitter.com/SpaceX",
                links?.twitterElon ?: "https://twitter.com/elonmusk"
            )
        )
    }

    /**
     * Extracts the [List] of [HistoricEvent] from the given [responseHistoricEvents].
     *
     * @param responseHistoricEvents [List] of [HistoricEvent] denoting
     *   all the Historic Events of SpaceX from REST API.
     * @return Converted [List] of [Core] using [responseHistoricEvents].
     */
    fun extractHistoricEventsFromResponse(responseHistoricEvents: List<HistoricEventResponse>) =
        ArrayList<HistoricEvents>().apply {

            // Instantiate a Map of Integer and Array List of HistoricEvent,
            // where Int as Key is the Year,
            // and Array List of HistoricEvent as Value is the List of Events of that Year.
            val historicEventMap = HashMap<Int, ArrayList<HistoricEvent>>()

            // Iterate over the Response.
            for (responseHistoricEvent in responseHistoricEvents) {

                // Halt the further execution and proceed to next iteration if the Event Date is empty.
                if (responseHistoricEvent.utcEventDate.isNullOrEmpty()) continue

                with(responseHistoricEvent) {

                    // Convert the Date-Time from UTC Format to Local Format.
                    convertUTCDateTime(utcEventDate ?: "", HISTORIC_EVENT_DATE_TIME_FORMAT, UI_DATE_TIME_FORMAT).let { dateTime ->

                        // Split the converted UTC Date Time with ','
                        dateTime.split(",").let { dateTimeSplit ->

                            // Split the Date-Time Split with ' '.
                            dateTimeSplit[0].split(" ").let { dateSplit ->

                                // Evaluate the Year from the Date Split.
                                val year = dateSplit[2].toInt()

                                // Instantiate the Historic Event.
                                val event = HistoricEvent(
                                    id ?: "",
                                    title ?: "",
                                    details ?: "",
                                    "${dateSplit[0]} ${dateSplit[1]}",
                                    HistoricEventLinks(
                                        links?.article ?: ""
                                    )
                                )

                                // Add the Historic Event to 'historicEventMap' based on whether
                                // it was added to this Map or not.
                                if (!historicEventMap.containsKey(year)) {
                                    historicEventMap[year] = ArrayList<HistoricEvent>().apply {
                                        add(event)
                                    }
                                } else {
                                    historicEventMap[year]?.add(event)
                                }

                            }
                        }

                    }

                }
            }

            // Iterate over all the Keys of the map 'historicEventMap' and
            // populate the List of HistoricEvents.
            for (key in historicEventMap.keys) {
                add(HistoricEvents(key, historicEventMap[key] ?: ArrayList()))
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
     * @param inputDateTimeFormat [String] denoting the Date-Time format of [utcDate].
     * @param outputDateTimeFormat [String] denoting the Date-Time format
     *   from which [String] as Date-Time is to be returned.
     * @return [String] containing Date and Time according to [outputDateTimeFormat].
     */
    private fun convertUTCDateTime(
        utcDate: String,
        inputDateTimeFormat: String,
        @Suppress("SameParameterValue") outputDateTimeFormat: String
    ): String {

        // Halt the further execution and return empty string if 'utcDate' is empty.
        if (utcDate.isEmpty()) return ""

        // Define an Input Format of Date and Time.
        val inputFormat = SimpleDateFormat(inputDateTimeFormat, Locale.ENGLISH)

        // Set the Time Zone of Input Format as the UTC Time Zone.
        inputFormat.timeZone = TimeZone.getTimeZone(TimeZone.getAvailableIDs()[588])

        // Define an Output Format of Date and Time.
        val outputFormat = SimpleDateFormat(outputDateTimeFormat, Locale.ENGLISH)

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
