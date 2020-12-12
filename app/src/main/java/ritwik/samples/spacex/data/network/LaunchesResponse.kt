package ritwik.samples.spacex.data.network

import com.squareup.moshi.Json

data class LaunchResponse(
    @field: Json(name = "flight_number") val flightNumber: Int?,
    @field: Json(name = "mission_name") val missionName: String?,
    @field: Json(name = "mission_id") val missionID: List<String>?,
    @field: Json(name = "launch_year") val launchYear: String?,
    @field: Json(name = "launch_date_unix") val unixLaunchDateTime: Long?,
    @field: Json(name = "launch_date_utc") val utcLaunchDateTime: String?,
    @field: Json(name = "launch_date_local") val localLaunchDateTime: String?,
    @field: Json(name = "is_tentative") val isTentative: Boolean?,
    @field: Json(name = "tentative_max_precision") val tentativeMaximumPrecision: String?,
    @field: Json(name = "tbd") val tbd: Boolean?,
    @field: Json(name = "launch_window") val launchWindow: Int?,
    @field: Json(name = "rocket") val rocket: LaunchRocket?,
    @field: Json(name = "ships") val ships: List<String>?,
    @field: Json(name = "telemetry") val telemetry: LaunchTelemetry?,
    @field: Json(name = "launch_site") val launchSite: LaunchSite?,
    @field: Json(name = "launch_success") val launchSuccess: Boolean?,
    @field: Json(name = "links") val launchLinks: LaunchLinks?,
    @field: Json(name = "details") val details: String?,
    @field: Json(name = "upcoming") val upcoming: Boolean?,
    @field: Json(name = "static_fire_date_utc") val utcStaticFireDate: String?,
    @field: Json(name = "static_fire_date_unix") val unixStaticFireDate: Long?,
    @field: Json(name = "timeline") val timeline: LaunchTimeline?,
    @field: Json(name = "crew") val crew: String?
)

data class LaunchRocket(
    @field: Json(name = "rocket_id") val id: String?,
    @field: Json(name = "rocket_name") val name: String?,
    @field: Json(name = "rocket_type") val type: String?,
    @field: Json(name = "first_stage") val firstStage: LaunchRocketFirstStage?,
    @field: Json(name = "second_stage") val secondStage: LaunchRocketSecondStage?,
    @field: Json(name = "fairings") val fairings: LaunchRocketFairings?
)

data class LaunchRocketFirstStage(
    @field: Json(name = "cores") val cores: List<LaunchRocketFirstStageCores>?
)

data class LaunchRocketFirstStageCores(
    @field: Json(name = "core_serial") val serial: String?,
    @field: Json(name = "flight") val flight: Int?,
    @field: Json(name = "block") val block: Int?,
    @field: Json(name = "gridfins") val gridFins: Boolean?,
    @field: Json(name = "legs") val legs: Boolean?,
    @field: Json(name = "reused") val reused: Boolean?,
    @field: Json(name = "land_success") val landSuccess: String?,
    @field: Json(name = "landing_intent") val landingIntent: String?,
    @field: Json(name = "landing_type") val landingType: String?,
    @field: Json(name = "landing_vehicle") val landingVehicle: String?
)

data class LaunchRocketSecondStage(
    @field: Json(name = "block") val block: Int?,
    @field: Json(name = "payloads") val payloads: List<LaunchRocketSecondStagePayload>?
)

data class LaunchRocketSecondStagePayload(
    @field: Json(name = "payload_id") val id: String?,
    @field: Json(name = "norad_id") val noradID: List<String>?,
    @field: Json(name = "cap_serial") val capSerial: String?,
    @field: Json(name = "reused") val reused: Boolean?,
    @field: Json(name = "customers") val customers: List<String>?,
    @field: Json(name = "nationality") val nationality: String?,
    @field: Json(name = "manufacturer") val manufacturer: String?,
    @field: Json(name = "payload_type") val payloadType: String?,
    @field: Json(name = "payload_mass_kg") val payloadMassKG: Double?,
    @field: Json(name = "payload_mass_lbs") val payloadMassLbs: Double?,
    @field: Json(name = "mass_returned_kg") val massReturnedKG: Double?,
    @field: Json(name = "mass_returned_lbs") val massReturnedLbs: Double?,
    @field: Json(name = "flight_time_sec") val flightTimeSeconds: Long?,
    @field: Json(name = "cargo_manifest") val cargoManifest: String?,
    @field: Json(name = "orbit") val orbit: String?,
    @field: Json(name = "orbit_params") val orbitParameters: LaunchRocketSecondStagePayloadOrbitParameters?
)

data class LaunchRocketSecondStagePayloadOrbitParameters(
    @field: Json(name = "reference_system") val referenceSystem: String?,
    @field: Json(name = "regime") val regime: String?,
    @field: Json(name = "longitude") val longitude: String?,
    @field: Json(name = "semi_major_axis_km") val semiMajorAxisKM: Double?,
    @field: Json(name = "eccentricity") val eccentricity: Double?,
    @field: Json(name = "periapsis_km") val periapsisKM: Double?,
    @field: Json(name = "apoapsis_km") val apoapsisKM: Double?,
    @field: Json(name = "inclination_deg") val inclinationDegree: Double?,
    @field: Json(name = "period_min") val periodMin: Double?,
    @field: Json(name = "lifespan_years") val lifespanYears: String?,
    @field: Json(name = "epoch") val epoch: String?,
    @field: Json(name = "mean_motion") val meanMotion: Double?,
    @field: Json(name = "raan") val raan: Double?,
    @field: Json(name = "arg_of_pericenter") val argOfPericenter: Double?,
    @field: Json(name = "mean_anomaly") val meanAnomaly: Double?
)

data class LaunchRocketFairings(
    @field: Json(name = "reused") val reused: Boolean?,
    @field: Json(name = "recovery_attempt") val recoveryAttempt: Boolean?,
    @field: Json(name = "recovered") val recovered: Boolean,
    @field: Json(name = "ship") val ship: String?
)

data class LaunchTelemetry(
    @field: Json(name = "flight_club") val flightClub: String?
)

data class LaunchSite(
    @field: Json(name = "site_id") val siteID: String?,
    @field: Json(name = "site_name") val siteNName: String?,
    @field: Json(name = "site_name_long") val siteLongName: String?
)

data class LaunchLinks(
    @field: Json(name = "mission_patch") val missionPatch: String?,
    @field: Json(name = "mission_patch_small") val missionPatchSmall: String?,
    @field: Json(name = "reddit_campaign") val redditCampaign: String?,
    @field: Json(name = "reddit_launch") val redditLaunch: String?,
    @field: Json(name = "reddit_recovery") val redditRecovery: String?,
    @field: Json(name = "reddit_media") val redditMedia: String?,
    @field: Json(name = "presskit") val pressKit: String?,
    @field: Json(name = "article_link") val articleLink: String?,
    @field: Json(name = "wikipedia") val wikipidea: String?,
    @field: Json(name = "video_link") val videoLink: String?,
    @field: Json(name = "youtube_id") val youtubeID: String?,
    @field: Json(name = "flickr_images") val flickrImages: List<String>?
)

data class LaunchTimeline(
    @field: Json(name = "webcast_liftoff") val webCastLiftOff: Int?,
    @field: Json(name = "go_for_prop_loading") val goForPropLoading: Int?,
    @field: Json(name = "rp1_loading") val rp1Loading: Int?,
    @field: Json(name = "stage1_lox_loading") val stage1LoxLoading: Int?,
    @field: Json(name = "stage2_lox_loading") val stage2LoxLoading: Int?,
    @field: Json(name = "engine_chill") val engineChill: Int?,
    @field: Json(name = "prelaunch_checks") val preLaunchChecks: Int?,
    @field: Json(name = "propellant_pressurization") val propellantPressurization: Int?,
    @field: Json(name = "go_for_launch") val goForLaunch: Int?,
    @field: Json(name = "ignition") val ignition: Int?,
    @field: Json(name = "liftoff") val liftOff: Int?,
    @field: Json(name = "maxq") val maxQ: Int?,
    @field: Json(name = "meco") val meco: Int?,
    @field: Json(name = "stage_sep") val stageSeparation: Int?,
    @field: Json(name = "second_stage_ignition") val secondStageIgnition: Int?,
    @field: Json(name = "fairing_deploy") val fairingDeployment: Int?,
    @field: Json(name = "seco-1") val seco1: Int?,
    @field: Json(name = "payload_deploy") val payloadDeploy: Int?
)
