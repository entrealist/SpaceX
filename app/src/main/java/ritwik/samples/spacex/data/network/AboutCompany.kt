package ritwik.samples.spacex.data.network

import com.squareup.moshi.Json

data class CompanyResponse(
    @field: Json(name = "headquarters") val headQuarters: CompanyHeadQuartersResponse?,
    @field: Json(name = "links") val links: CompanyLinksResponse?,
    @field: Json(name = "name") val name: String?,
    @field: Json(name = "founder") val founder: String?,
    @field: Json(name = "founded") val founded: Int?,
    @field: Json(name = "employees") val employees: Int?,
    @field: Json(name = "vehicles") val vehicles: Int?,
    @field: Json(name = "launch_sites") val launchSites: Int?,
    @field: Json(name = "test_sites") val testSites: Int?,
    @field: Json(name = "ceo") val ceo: String?,
    @field: Json(name = "cto") val cto: String?,
    @field: Json(name = "coo") val coo: String?,
    @field: Json(name = "cto_propulsion") val propulsionCTO: String?,
    @field: Json(name = "valuation") val valuation: Long?,
    @field: Json(name = "summary") val summary: String?,
    @field: Json(name = "id") val id: String?
)

data class CompanyHeadQuartersResponse(
    @field: Json(name = "address") val address: String?,
    @field: Json(name = "city") val city: String?,
    @field: Json(name = "state") val state: String?
)

data class CompanyLinksResponse(
    @field: Json(name = "website") val website: String?,
    @field: Json(name = "flickr") val flickr: String?,
    @field: Json(name = "twitter") val twitterSpaceX: String?,
    @field: Json(name = "elon_twitter") val twitterElon: String?
)
