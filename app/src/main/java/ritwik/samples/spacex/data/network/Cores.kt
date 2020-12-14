package ritwik.samples.spacex.data.network

import com.squareup.moshi.Json

data class CoreResponse(
    @field: Json(name = "block") val block: Int?,
    @field: Json(name = "reuse_count") val reuseCount: Int?,
    @field: Json(name = "rtls_attempts") val rtlsAttempts: Int?,
    @field: Json(name = "rtls_landings") val rtlsLandings: Int?,
    @field: Json(name = "asds_attempts") val asdsAttempts: Int?,
    @field: Json(name = "asds_landings") val asdsLandings: Int?,
    @field: Json(name = "last_update") val lastUpdate: String?,
    @field: Json(name = "launches") val launches: List<String>?,
    @field: Json(name = "serial") val serial: String?,
    @field: Json(name = "status") val status: String?,
    @field: Json(name = "id") val id: String?
)
