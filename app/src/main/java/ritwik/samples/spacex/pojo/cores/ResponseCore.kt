package ritwik.samples.spacex.pojo.cores

import com.squareup.moshi.Json

data class ResponseCore(
    @field: Json(name = "core_serial") val serial: String,
    @field: Json(name = "block") val block: Int?,
    @field: Json(name = "status") val status: String,
    @field: Json(name = "original_launch") val launchTimeUTC: String,
    @field: Json(name = "original_launch_unix") val launchTimeUNIX: Long?,
    @field: Json(name = "missions") val missions: List<ResponseMission>,
    @field: Json(name = "reuse_count") val reuseCount: Int,
    @field: Json(name = "rtls_attempts") val attemptsRTLS: Int,
    @field: Json(name = "rtls_landings") val landingsRTLS: Int,
    @field: Json(name = "asds_attempts") val attemptsASDS: Int,
    @field: Json(name = "asds_landings") val landingsASDS: Int,
    @field: Json(name = "water_landing") val waterLanding: Boolean,
    @field: Json(name = "details") val details: String?
)

data class ResponseMission(
    @field: Json(name = "name") val name: String,
    @field: Json(name = "flight") val flight: Int
)