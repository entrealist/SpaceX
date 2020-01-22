package ritwik.samples.spacex.model

import ritwik.samples.spacex.convertUTCDateTime

import java.lang.StringBuilder

/**Model Class that represents the Core used by SpaceX.
 * @author Ritwik Jamuar.*/
data class Core(
    val serial: String,
    val block: Int?,
    val launchDateTime: String,
    val missions: List<String>,
    val attemptsRTLS: Int,
    val landingsRTLS: Int,
    val attemptsASDS: Int,
    val landingsASDS: Int,
    val description: String
) {

    /**Gets the Serial Number of [Core]
     * @return String denoting the Serial Number.*/
    fun getSerialNumber(): String = serial

    /**Gets the Block Number of [Core].
     * @return String denoting the Block Number. If Block Number does not exist, then returns 'TBD'.*/
    fun getBlock(): String = block?.toString() ?: "TBD"

    /**Gets the Missions of the [Core].
     * @return String denoting the name of Mission(s) the [Core] has been involved into.
     *         If no missions exist then returns 'NA'*/
    fun getMissionsText(): String {
        val builder = StringBuilder()
        return if (missions.isEmpty()) {
            "NA"
        } else {
            for (i in missions.indices) {
                builder.append(missions[i]).append(
                    if (i == missions.size - 1) {
                        ""
                    } else {
                        "\n"
                    }
                )
            }
            builder.toString()
        }
    }

    /**Gets the Number of RTLS Landings.
     * @return String representing Landings of RTLS in the form: Successful/Total.*/
    fun getRTLSLandings(): String = "$landingsRTLS/$attemptsRTLS"

    /**Gets the Number of ASDS Landings.
     * @return String representing Landing of ASDS in the form: Successful/Total.*/
    fun getASDSLandings(): String = "$landingsASDS/$attemptsASDS"

    /**Gets the Launch Time.
     * @return String representing Launch Time in UTC Readable Format.*/
    fun getLaunch(): String = convertUTCDateTime(launchDateTime)

}