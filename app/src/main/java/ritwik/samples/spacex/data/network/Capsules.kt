package ritwik.samples.spacex.data.network

import com.squareup.moshi.Json

data class CapsuleResponse(
    @field: Json(name = "reuse_count") val reuseCount: Int?,
    @field: Json(name = "water_landings") val waterLandingCount: Int?,
    @field: Json(name = "land_landings") val landLandingCount: Int?,
    @field: Json(name = "last_update") val lastUpdate: String?,
    @field: Json(name = "launches") val launches: List<String>?,
    @field: Json(name = "serial") val serial: String?,
    @field: Json(name = "status") val status: String?,
    @field: Json(name = "type") val type: String?,
    @field: Json(name = "id") val id: String?
)
