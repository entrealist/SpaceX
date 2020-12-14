package ritwik.samples.spacex.data.ui

/**
 * Data Class encapsulating the details of a Core.
 *
 * @param id [String] denoting the Core ID.
 * @param block [Int] denoting the Block Number on which this Core belongs to.
 * @param reuseCount [Int] denoting the count of Re-Use done by this Core.
 * @param rtlsLanding Instance of [CoreLanding] encapsulating details of RTLS Landing.
 * @param asdsLanding Instance of [CoreLanding] encapsulating details of ASDS Landing.
 * @param lastUpdate [List] of [String] encapsulating the IDs of [Launch].
 * @param serial [String] denoting the Core Serial.
 * @param status [String] denoting the Core Status.
 */
data class Core(
    val id: String,
    val block: Int,
    val reuseCount: Int,
    val rtlsLanding: CoreLanding,
    val asdsLanding: CoreLanding,
    val lastUpdate: String,
    val launches: List<String>,
    val serial: String,
    val status: String
) {

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Provides the name of the [Core] as the value of [serial].
     *
     * @return Value of [serial].
     */
    fun getCoreName(): String = serial

    /**
     * Provides the value of [block] in [String] format.
     *
     * @return If the value of [block] is 0, TBD is returned, else the value of [block].
     */
    fun getBlockText(): String = if (block == 0) {
        "TBD"
    } else {
        block.toString()
    }

}

/**
 * Data Class encapsulating the details of the Landing of the [Core].
 *
 * @param attempts [Int] denoting the count of Landing attempts.
 * @param success [Int] denoting the count of Successful Landing.
 * @author Ritwik Jamuar
 */
data class CoreLanding(
    val attempts: Int,
    val success: Int
) {

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Provides the number of successful Landings out of total Attempts.
     *
     * @return [String] denoting the number.
     */
    fun getLandingRatio(): String = "$success / $attempts"

    /**
     * Provides the String value of no. of attempts.
     *
     * @return [String] value of [attempts].
     */
    fun getAttemptText(): String = "$attempts"

    /**
     * Provides the String value of no. of successful landings.
     *
     * @return [String] value of [success].
     */
    fun getSuccessText(): String = "$success"

}
