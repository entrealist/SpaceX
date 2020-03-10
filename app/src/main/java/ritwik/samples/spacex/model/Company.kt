package ritwik.samples.spacex.model

data class Company(
	private val name : String,
	private val founder : String,
	private val foundedAt : String,
	private val employeesCount : Short,
	private val vehiclesCount : Short,
	private val launchSitesCount : Short,
	private val testSitesCount : Short,
	private val ceo : String,
	private val cto : String,
	private val propulsionCTO : String,
	private val coo : String,
	private val valuation : Long,
	private val summary : String,
	private val links : Links,
	private val headQuarter : HeadQuarter
) {

	fun getFounderAndFoundedAt() : String = "$founder, $foundedAt"

	fun getHeadQuarter() : HeadQuarter = this.headQuarter

	fun getSummary() : String = this.summary

	fun getCEO() : String = this.ceo

	fun getCTO() : String = this.cto

	fun getPropulsionCTO() : String = this.propulsionCTO

	fun getCOO() : String = this.coo

	fun getValuation() : String = "$$valuation"

	fun getTestSites() : String = this.testSitesCount.toString()

	fun getLaunchSites() : String = this.launchSitesCount.toString()

	fun getEmployees() : String = this.employeesCount.toString()

	fun getVehicles() : String = this.vehiclesCount.toString()

	fun getLinks() : Links = this.links

}

data class HeadQuarter(
	private val address : String,
	private val city : String,
	private val state : String
) {

	fun getHeadQuarterAddress() : String {
		val addressBuilder = StringBuilder()
		addressBuilder.append(
			if (address == "NA") {
				""
			} else {
				"${this.address}, "
			}
		).append(
			if (city == "NA") {
				""
			} else {
				"${this.city}, "
			}
		).append(
			if (state == "NA") {
				""
			} else {
				this.state
			}
		)

		if (addressBuilder.isEmpty()) {
			addressBuilder.append("NA")
		}

		return addressBuilder.toString()
	}

}

data class Links(
	private val website : String?,
	private val flickr : String?,
	private val twitter : String?,
	private val twitterElon : String?
) {

	fun getWebsite() : String = this.website ?: ""

	fun getFlickr() : String = this.flickr ?: ""

	fun getTwitter() : String = this.twitter ?: ""

	fun getElonMuskTwitterHandle() : String = this.twitterElon ?: ""

}