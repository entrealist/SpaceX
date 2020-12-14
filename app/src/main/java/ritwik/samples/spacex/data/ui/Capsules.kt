package ritwik.samples.spacex.data.ui

import java.util.Locale

/**
 * Data Class encapsulating the detail of a Capsule.
 *
 * @param id [String] denoting the Capsule ID.
 * @param serial [String] denoting the Capsule Serial.
 * @param type [String] denoting the Capsule Type.
 * @param status [String] denoting the status of the Capsule.
 * @param lastUpdate [String] containing the update information of this Capsule.
 * @param reuseCount [Int] denoting the count of Re-Use of this Capsule.
 * @param landings Instance of [CapsuleLanding] encapsulating the details of Landings of this Capsule.
 * @param launches [List] of [String] containing the IDs of the [Launch]es.
 * @author Ritwik Jamuar
 */
data class Capsule(
    val id: String,
    val serial: String,
    val type: String,
    val status: String,
    val lastUpdate: String,
    val reuseCount: Int,
    val landings: CapsuleLanding,
    val launches: List<String>
) {

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Provides the name of the [Capsule].
     *
     * @return [String] denoting the value of concatenation of [serial] and [type].
     */
    fun getCapsuleName(): String = "$serial - $type"

    /**
     * Provides the count of Reuse of this [Capsule].
     *
     * @return [String] denoting the value of [reuseCount].
     */
    fun getReUseCount(): String = "$reuseCount"

    /**
     * Provides the status of this [Capsule].
     *
     * @return Capitalized Value of [status],
     */
    fun getFormattedStatus(): String = status.capitalize(Locale.ENGLISH)

}

/**
 * Data Class to encapsulate the Landing Counts of the [Capsule].
 *
 * @param water [Int] denoting the count of Water Landings.
 * @param land [Int] denoting the count of Land Landings.
 * @author Ritwik Jamuar
 */
data class CapsuleLanding(val water: Int, val land: Int) {

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Provides the count of Water Landing in [String] format.
     *
     * @return [String] denoting the value of [water].
     */
    fun getWaterLanding(): String = "$water"

    /**
     * Provides the count of Land Landing in [String] format.
     *
     * @return [String] denoting the value of [land].
     */
    fun getLandLanding(): String = "$land"

}
