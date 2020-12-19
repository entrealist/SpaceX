package ritwik.samples.spacex.data.ui

/**
 * Data Class encapsulating the details of a launch.
 *
 * @param id [String] denoting the ID of this Launch.
 * @param flightNumber [Int] denoting the Mission Number.
 * @param missionName [String] denoting the Mission Name.
 * @param date Instance of [LaunchDate] denoting this Launch Mission Date Time.
 * @param staticFireDate Instance of [LaunchDate] denoting the Static Fire Date Time
 *   of this Launch Mission.
 * @param fairings Instance of [LaunchFairings] encapsulating Fairing Details
 *   of this Launch Mission.
 * @param links Instance of [LaunchLinks] encapsulating different links available
 *   for this Launch Mission.
 * @param cores [List] of [LaunchCore] denoting the details of Cores involved
 *   in this Launch Mission.
 * @param payloads [List] of [String] denoting the IDs of the [RocketPayload].
 * @param capsules [List] of [String] denoting the IDs of the [Capsule].
 * @param ships [List] of [String] denoting the IDs of the Ships.
 * @param rocket [String] denoting the ID of the [Rocket].
 * @param launchPad [String] denoting the ID of the Launch Pad.
 * @param isSuccessful [Boolean] denoting whether this Launch Mission was successful or not.
 * @param window [Int] denoting the Window Number.
 * @param crewMembers [List] of [String] denoting the IDs of the Crew Members.
 * @param failures [List] of [LaunchFailure] denoting all the causes of Failures
 *   of this Launch Mission.
 * @author Ritwik Jamuar
 */
data class Launch(
    val id: String,
    val flightNumber: Int,
    val missionName: String,
    val date: LaunchDate,
    val staticFireDate: LaunchDate,
    val fairings: LaunchFairings,
    val links: LaunchLinks,
    val cores: List<LaunchCore>,
    val payloads: List<String>,
    val capsules: List<String>,
    val ships: List<String>,
    val rocket: String,
    val launchPad: String,
    val isSuccessful: Boolean,
    val window: Int,
    val crewMembers: List<String>,
    val failures: List<LaunchFailure>
) {

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Provides the value of [flightNumber] in Text Format.
     *
     * @return [String] representation of [flightNumber].
     */
    fun getMissionNumberText(): String = "#$flightNumber"

}

/**
 * Data Class encapsulating the Date details used in [Launch].
 *
 * @param utc [String] denoting the Date-Time in UTC Format.
 * @param unix [Long] denoting the Date-Time in UNIX Format.
 * @author Ritwik Jamuar
 */
data class LaunchDate(val utc: String, val unix: Long)

/**
 * Data Class encapsulating the details of Faring of the [Launch].
 *
 * @param isReused [Boolean] denoting whether the Fairing was reused or not.
 * @param isRecoveryAttempted [Boolean] denoting whether the Recovery for the Fairing was attempted
 *   or not.
 * @param isRecovered [Boolean] denoting whether the Fairing was recovered or not.
 * @param ship [List] of [String] denoting the IDs of the Fairing Ships used.
 * @author Ritwik Jamuar
 */
data class LaunchFairings(
    val isReused: Boolean,
    val isRecoveryAttempted: Boolean,
    val isRecovered: Boolean,
    val ship: List<String>,
)

/**
 * Data Class encapsulating various kinds of Links available for the [Launch].
 *
 * @param patch Instance of [LaunchLinksPatch] encapsulating the Image Patch Links associated
 *   with this [Launch].
 * @param reddit Instance of [LaunchLinksReddit] encapsulating the different kinds of Links
 *   associated with Reddit for this [Launch].
 * @param flickr Instance of [LaunchLinksFlickr] encapsulating the Images Links from Flickr
 *   for this [Launch].
 * @param pressKit [String] denoting the URL of Press Kit release of this [Launch].
 * @param webCast [String] denoting the URL for Video Streaming this [Launch].
 * @param youtubeID [String] denoting the Video ID of Youtube for this [Launch].
 * @param article [String] denoting the URL of Article of this [Launch].
 * @param wikipedia [String] denoting the URL of Wikipedia of this [Launch].
 * @author Ritwik Jamuar
 */
data class LaunchLinks(
    val patch: LaunchLinksPatch,
    val reddit: LaunchLinksReddit,
    val flickr: LaunchLinksFlickr,
    val pressKit: String,
    val webCast: String,
    val youtubeID: String,
    val article: String,
    val wikipedia: String
)

/**
 * Data Class encapsulating the Image Patch Links of the [Launch].
 *
 * @param small [String] denoting the Small-Size Image Patch URL.
 * @param large [String] denoting the Large-Size Image Patch URL.
 * @author Ritwik Jamuar
 */
data class LaunchLinksPatch(val small: String, val large: String)

/**
 * Data Class encapsulating the Reddit Links of the [Launch].
 *
 * @param campaign [String] denoting Reddit Campaign URL.
 * @param launch [String] denoting Reddit Launch URL.
 * @param media [String] denoting Reddit Media URL.
 * @param recovery [String] denoting the Reddit Recovery URL.
 * @author Ritwik Jamuar
 */
data class LaunchLinksReddit(
    val campaign: String,
    val launch: String,
    val media: String,
    val recovery: String
)

/**
 * Data Class encapsulating the Flickr Links of the [Launch].
 *
 * @param small [List] of [String] denoting the Flickr Links of the [Launch] in Small Resolution.
 * @param original [List] of [String] denoting the Flickr Links of the [Launch] in
 *   Original Resolution.
 * @author Ritwik Jamuar
 */
data class LaunchLinksFlickr(val small: List<String>, val original: List<String>)

/**
 * Data Class encapsulating the details of [Core] used in the [Launch].
 *
 * @param id [String] denoting the ID of the [Core].
 * @param isReused [Boolean] denoting whether the [Core] was re-used or not.
 * @param landingType [String] denoting the type of Landing happened for this [Core].
 * @param landPadID [String] denoting the Land Pad ID.
 * @author Ritwik Jamuar
 */
data class LaunchCore(
    val id: String,
    val isReused: Boolean,
    val landingType: String,
    val landPadID: String
)

/**
 * Data Class encapsulating the details of failure of this [Launch].
 *
 * @param time [Int] as Time in seconds, denoting the Failure Time after the Launch.
 * @param altitude [Int] denoting the Altitude at which Failure occurred.
 * @param reason [String] denoting the Reason of the Failure.
 * @author Ritwik Jamuar
 */
data class LaunchFailure(
    val time: Int,
    val altitude: Int,
    val reason: String
)

/**
 * Enumeration to classify different kinds of Launches of SpaceX.
 *
 * @author Ritwik Jamuar
 */
enum class LaunchType {

    /**
     * Denotes the Upcoming Launches.
     */
    UPCOMING,

    /**
     * Denotes the Completed Launches.
     */
    COMPLETED

}
