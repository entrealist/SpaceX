package ritwik.samples.spacex.data.network

import com.squareup.moshi.Json

data class HistoricEventResponse(
    @field: Json(name = "id") val id: String?,
    @field: Json(name = "title") val title: String?,
    @field: Json(name = "details") val details: String?,
    @field: Json(name = "event_date_utc") val utcEventDate: String?,
    @field: Json(name = "event_date_unix") val unixEventDate: Long?,
    @field: Json(name = "links") val links: HistoricEventLinksResponse?
)

data class HistoricEventLinksResponse(
    @field: Json(name = "article") val article: String?
)
