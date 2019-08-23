package ritwik.samples.spacex.pojo

import com.squareup.moshi.Json

data class Launch (
	@field: Json ( name = "flight_number" )				val flightNumber :				Int,
	@field: Json ( name = "mission_name" )				val missionName :				String,
	@field: Json ( name = "mission_id" )				val missionID :					List < String >,
	@field: Json ( name = "launch_year" )				val launchYear :				String,
	@field: Json ( name = "launch_date_unix" )			val launchDateUnix :			Long,
	@field: Json ( name = "launch_date_utc" )			val launchDateUTC :				String,
	@field: Json ( name = "launch_date_local" )			val launchDateLocal :			String,
	@field: Json ( name = "is_tentative" )				val isTentative :				Boolean,
	@field: Json ( name = "tentative_max_precision" )	val tentativeMaximumPrecision : String,
	@field: Json ( name = "tbd" )						val tbd :						Boolean,
	@field: Json ( name = "launch_window" )				val launchWindow :				String,
	@field: Json ( name = "rocket" )					val rocket :					Rocket,
	@field: Json ( name = "ships" )						val ships :						List < String >,
	@field: Json ( name = "telemetry" )					val telemetry :					Telemetry,
	@field: Json ( name = "launch_site" )				val launchSite :				LaunchSites,
	@field: Json ( name = "launch_success" )			val launchSuccess :				Boolean?,
	@field: Json ( name = "launch_failure_details" )	val launchFailureDetails :		LaunchFailure?,
	@field: Json ( name = "links" )						val links :						Links,
	@field: Json ( name = "details" )					val details :					String,
	@field: Json ( name = "upcoming" )					val upcoming :					Boolean,
	@field: Json ( name = "static_fire_date_utc" )		val staticFireDateUTC :			String?,
	@field: Json ( name = "static_fire_date_unix" )		val staticFireDateUnix :		Long?,
	@field: Json ( name = "timeline" )					val timeline :					Timeline,
	@field: Json ( name = "crew" )						val crew :						String,
	@field: Json ( name = "last_wiki_update" )			val lastDateWikipediaUpdate :	String?,
	@field: Json ( name = "is_date_from_wiki" )			val isDateFromWikipedia :		Boolean?
)