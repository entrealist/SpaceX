package ritwik.samples.spacex.data.ui

/**
 * Data Class encapsulating the details of a launch.
 *
 * @param missionNumber [Int] denoting the Mission Number.
 * @param missionName [String] denoting the Mission Name.
 * @param missionDateTime [String] denoting the Mission Date Time.
 * @param blockNumber [Int] denoting the Block Number.
 * @param youtubeVideoLink [String] denoting the Youtube Video Link.
 * @author Ritwik Jamuar
 */
data class Launch(
    val missionNumber: Int,
    val missionName: String,
    val missionDateTime: String,
    val blockNumber: Int,
    val youtubeVideoLink: String
) {

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Provides the value of [missionNumber] in Text Format.
     *
     * @return [String] representation of [missionNumber].
     */
    fun getMissionNumberText(): String = "#$missionNumber"

    /**
     * Provides the value of [blockNumber] in Text Format.
     *
     * @return [String] representation of [blockNumber].
     */
    fun getBlockNumberText(): String = "$blockNumber"

}
