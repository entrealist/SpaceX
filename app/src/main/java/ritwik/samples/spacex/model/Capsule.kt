package ritwik.samples.spacex.model

import ritwik.samples.spacex.convertUTCDateTime

data class Capsule(
    val serial: String,
    val id: String,
    val status: String,
    val launchTime: String?,
    val launchTimeUnix: Long?,
    val missions: List<CapsuleMission>?,
    val landings: Long,
    val type: String,
    val details: String,
    val reuseCount: Long
) {

    /**Provides the status of the Capsule in Capitalized manner.
     * @return [String] denoting the Status of the [Capsule].*/
    fun getCapsuleStatus(): String = status.capitalize()

    /**Provides the name of the Capsule, which is the combination of Serial Number and Type of Capsule.
     * @return [String] denoting the name of the [Capsule].*/
    fun getCapsuleName(): String = "$serial : $type"

    /**Provides the Count of [CapsuleMission].
     * @return [Int] denoting the Size of [CapsuleMission].*/
    fun getMissionCount(): String = "${missions?.size ?: 0}"

    /**Provides the Capsule's active time.
     * @return [String] denoting the [Capsule]'s Active Time.*/
    fun getActiveSince(): String {
        return if (launchTime == null) {
            "NA"
        } else {
            convertUTCDateTime(launchTime)
        }
    }

}

data class CapsuleMission(
    val name: String,
    val flight: Long
)