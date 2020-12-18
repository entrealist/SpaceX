package ritwik.samples.spacex.data.network

import com.squareup.moshi.Json

data class LaunchResponse(
    @field: Json(name = "fairings") val fairings: LaunchFairingResponse?,
    @field: Json(name = "links") val links: LaunchLinksResponse?,
    @field: Json(name = "static_fire_date_utc") val utcStaticFireDate: String?,
    @field: Json(name = "static_fire_date_unix") val unixStaticFireDate: Long?,
    @field: Json(name = "tbd") val tbd: Boolean?,
    @field: Json(name = "net") val net: Boolean?,
    @field: Json(name = "window") val window: Int?,
    @field: Json(name = "rocket") val rocket: String?,
    @field: Json(name = "success") val success: Boolean?,
    @field: Json(name = "details") val details: String?,
    @field: Json(name = "crew") val crew: List<String>?,
    @field: Json(name = "ships") val ships: List<String>?,
    @field: Json(name = "capsules") val capsules: List<String>?,
    @field: Json(name = "payloads") val payloads: List<String>?,
    @field: Json(name = "launchpad") val launchPad: String?,
    @field: Json(name = "auto_update") val autoUpdate: Boolean?,
    @field: Json(name = "failures") val failures: List<LaunchFailureResponse>?,
    @field: Json(name = "flight_number") val flightNumber: Int?,
    @field: Json(name = "name") val name: String?,
    @field: Json(name = "date_utc") val utcDate: String?,
    @field: Json(name = "date_unix") val unixDate: Long?,
    @field: Json(name = "date_local") val localDate: String?,
    @field: Json(name = "date_precision") val datePrecision: String?,
    @field: Json(name = "upcoming") val upcoming: Boolean?,
    @field: Json(name = "cores") val cores: List<LaunchCoreResponse>,
    @field: Json(name = "id") val id: String?
)

data class LaunchCoreResponse(
    @field: Json(name = "core") val core: String?,
    @field: Json(name = "flight") val flight: Int?,
    @field: Json(name = "gridfins") val gridFins: Boolean?,
    @field: Json(name = "legs") val legs: Boolean?,
    @field: Json(name = "reused") val reused: Boolean?,
    @field: Json(name = "land_success") val landSuccess: Boolean?,
    @field: Json(name = "landing_intent") val landingIntent: Boolean?,
    @field: Json(name = "landing_type") val landingType: String?,
    @field: Json(name = "landing_vehicle") val landingVehicle: String?
)

data class LaunchFairingResponse(
    @field: Json(name = "reused") val reused: Boolean?,
    @field: Json(name = "recovery_attempt") val recoveryAttempt: Boolean?,
    @field: Json(name = "recovered") val recovered: Boolean?,
    @field: Json(name = "ship") val ship: List<String>?
)

data class LaunchLinksResponse(
    @field: Json(name = "patch") val patch: LaunchLinkPatchResponse?,
    @field: Json(name = "reddit") val reddit: LaunchLinkRedditResponse?,
    @field: Json(name = "flickr") val flickr: LaunchLinkFlickrResponse?,
    @field: Json(name = "presskit") val pressKit: String?,
    @field: Json(name = "webcast") val webCast: String?,
    @field: Json(name = "youtube_id") val youtubeID: String?,
    @field: Json(name = "article") val article: String?,
    @field: Json(name = "wikipedia") val wikipedia: String?
)

data class LaunchLinkPatchResponse(
    @field: Json(name = "small") val small: String?,
    @field: Json(name = "large") val large: String?
)

data class LaunchLinkRedditResponse(
    @field: Json(name = "campaign") val campaign: String?,
    @field: Json(name = "launch") val launch: String?,
    @field: Json(name = "media") val media: String?,
    @field: Json(name = "recovery") val recovery: String?
)

data class LaunchLinkFlickrResponse(
    @field: Json(name = "small") val small: List<String>?,
    @field: Json(name = "original") val original: List<String>?
)

data class LaunchFailureResponse(
    @field: Json(name = "time") val time: Int?,
    @field: Json(name = "altitude") val altitude: Int?,
    @field: Json(name = "reason") val reason: String?
)
