package ritwik.samples.spacex.pojo

import com.squareup.moshi.Json

import ritwik.samples.spacex.model.Company
import ritwik.samples.spacex.model.HeadQuarter
import ritwik.samples.spacex.model.Links

data class ResponseCompany(
	@field: Json(name = "name") val name : String?,
	@field: Json(name = "founder") val founder : String?,
	@field: Json(name = "founded") val founded : Int?,
	@field: Json(name = "employees") val employees : Int?,
	@field: Json(name = "vehicles") val vehicles : Int?,
	@field: Json(name = "launch_sites") val launchSites : Int?,
	@field: Json(name = "test_sites") val testSites : Int?,
	@field: Json(name = "ceo") val ceo : String?,
	@field: Json(name = "cto") val cto : String?,
	@field: Json(name = "coo") val coo : String?,
	@field: Json(name = "cto_propulsion") val ctoPropulsion : String?,
	@field: Json(name = "valuation") val valuation : Long?,
	@field: Json(name = "summary") val summary : String?,
	@field: Json(name = "links") val links : ResponseLinks?,
	@field: Json(name = "headquarters") val headquarters : ResponseHeadQuarter?
) {
	fun convertToModelData() : Company = Company(
		name = this.name ?: "NA",
		founder = this.founder ?: "NA",
		foundedAt = if (this.founded == null) {
			"NA"
		} else {
			this.founded.toString()
		},
		employeesCount = if (this.employees == null) {
			0
		} else {
			this.employees.toShort()
		},
		vehiclesCount = if (this.vehicles == null) {
			0
		} else {
			this.vehicles.toShort()
		},
		launchSitesCount = if (this.launchSites == null) {
			0
		} else {
			this.launchSites.toShort()
		},
		testSitesCount = if (this.testSites == null) {
			0
		} else {
			this.testSites.toShort()
		},
		ceo = this.ceo ?: "NA",
		cto = this.cto ?: "NA",
		propulsionCTO = this.ctoPropulsion ?: "NA",
		coo = this.coo ?: "NA",
		valuation = this.valuation ?: 0,
		summary = this.summary ?: "NA",
		links = if (this.links == null) {
			Links(null, null, null, null)
		} else {
			this.links.convertToModelData()
		},
		headQuarter = if (this.headquarters == null) {
			HeadQuarter("NA", "NA", "NA")
		} else {
			this.headquarters.convertToModelData()
		}
	)
}

data class ResponseHeadQuarter(
	@field: Json(name = "address") val address : String?,
	@field: Json(name = "city") val city : String?,
	@field: Json(name = "state") val state : String?
) {
	fun convertToModelData() : HeadQuarter = HeadQuarter(
		address = this.address ?: "NA",
		city = this.city ?: "NA",
		state = this.state ?: "NA"
	)
}

data class ResponseLinks(
	@field: Json(name = "website") val website : String?,
	@field: Json(name = "flickr") val flickr : String?,
	@field: Json(name = "twitter") val twitter : String?,
	@field: Json(name = "elon_twitter") val twitterElon : String?
) {
	fun convertToModelData() : Links = Links(
		website = this.website,
		flickr = this.flickr,
		twitter = this.twitter,
		twitterElon = this.twitterElon
	)
}