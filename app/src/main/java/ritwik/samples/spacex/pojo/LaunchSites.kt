package ritwik.samples.spacex.pojo

import com.squareup.moshi.Json

data class LaunchSites (
	@field: Json ( name = "site_id" )			val siteID :		String,
	@field: Json ( name = "site_name" )			val siteName :		String,
	@field: Json ( name = "site_name_long" )	val siteNameLong :	String
)