package ritwik.samples.spacex.pojo

import com.squareup.moshi.Json

import ritwik.samples.spacex.model.Capsule
import ritwik.samples.spacex.model.CapsuleMission

data class ResponseCapsule(
    @field: Json(name = "capsule_serial") val serial: String,
    @field: Json(name = "capsule_id") val id: String,
    @field: Json(name = "status") val status: String,
    @field: Json(name = "original_launch") val launchTime: String?,
    @field: Json(name = "original_launch_unix") val launchTimeUnix: Long?,
    @field: Json(name = "missions") val missions: List<ResponseCapsuleMission>?,
    @field: Json(name = "landings") val landings: Long,
    @field: Json(name = "type") val type: String,
    @field: Json(name = "details") val details: String?,
    @field: Json(name = "reuse_count") val reuseCount: Long
) {
    fun convertToModelData(): Capsule {
        val capsuleMissions = ArrayList<CapsuleMission>()
        this.missions?.let {
            for (mission in it) {
                capsuleMissions.add(mission.convertToModelData())
            }
        }
        return Capsule(
            serial = this.serial,
            id = this.id,
            status = this.status,
            launchTime = this.launchTime,
            launchTimeUnix = this.launchTimeUnix,
            missions = capsuleMissions,
            landings = this.landings,
            type = this.type,
            details = this.details ?: "NA",
            reuseCount = this.reuseCount
        )
    }
}

data class ResponseCapsuleMission(
    @field: Json(name = "name") val name: String,
    @field: Json(name = "flight") val flight: Long
) {
    fun convertToModelData(): CapsuleMission = CapsuleMission(
        name = this.name,
        flight = this.flight
    )
}