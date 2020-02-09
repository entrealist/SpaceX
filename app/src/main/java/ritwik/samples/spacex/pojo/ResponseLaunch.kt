package ritwik.samples.spacex.pojo

import com.squareup.moshi.Json

import ritwik.samples.spacex.model.*

data class ResponseLaunch(
    @field: Json(name = "flight_number") val flightNumber: Int?,
    @field: Json(name = "mission_name") val missionName: String?,
    @field: Json(name = "mission_id") val missionID: List<String>?,
    @field: Json(name = "launch_year") val launchYear: String?,
    @field: Json(name = "launch_date_unix") val launchDateUnix: Long?,
    @field: Json(name = "launch_date_utc") val launchDateUTC: String?,
    @field: Json(name = "launch_date_local") val launchDateLocal: String?,
    @field: Json(name = "is_tentative") val isTentative: Boolean?,
    @field: Json(name = "tentative_max_precision") val tentativeMaximumPrecision: String?,
    @field: Json(name = "tbd") val tbd: Boolean?,
    @field: Json(name = "launch_window") val launchWindow: String?,
    @field: Json(name = "rocket") val rocket: ResponseLaunchRocket?,
    @field: Json(name = "ships") val ships: List<String>?,
    @field: Json(name = "telemetry") val telemetry: ResponseLaunchTelemetry?,
    @field: Json(name = "launch_site") val launchSite: ResponseLaunchSites?,
    @field: Json(name = "launch_success") val launchSuccess: Boolean?,
    @field: Json(name = "launch_failure_details") val launchFailureDetails: ResponseLaunchFailure?,
    @field: Json(name = "links") val links: ResponseLaunchLinks?,
    @field: Json(name = "details") val details: String?,
    @field: Json(name = "upcoming") val upcoming: Boolean?,
    @field: Json(name = "static_fire_date_utc") val staticFireDateUTC: String?,
    @field: Json(name = "static_fire_date_unix") val staticFireDateUnix: Long?,
    @field: Json(name = "timeline") val timeline: ResponseLaunchTimeline?,
    @field: Json(name = "crew") val crew: List<String>?,
    @field: Json(name = "last_wiki_update") val lastDateWikipediaUpdate: String?,
    @field: Json(name = "is_date_from_wiki") val isDateFromWikipedia: Boolean?
) {
    override fun toString(): String {
        return flightNumber.toString()
    }

    fun convertToModelData(): Launch = Launch(
        flightNumber = this.flightNumber,
        missionName = this.missionName,
        missionID = this.missionID,
        launchYear = this.launchYear,
        launchDateUnix = this.launchDateUnix,
        launchDateUTC = this.launchDateUTC,
        launchDateLocal = this.launchDateLocal,
        isTentative = this.isTentative,
        tentativeMaximumPrecision = this.tentativeMaximumPrecision,
        tbd = this.tbd,
        launchWindow = this.launchWindow,
        rocket = this.rocket?.convertToModelData(),
        ships = this.ships,
        telemetry = this.telemetry?.convertToModelData(),
        launchSite = this.launchSite?.convertToModelData(),
        launchSuccess = this.launchSuccess,
        launchFailureDetails = this.launchFailureDetails?.convertToModelData(),
        links = this.links?.convertToModelData(),
        details = this.details,
        upcoming = this.upcoming,
        staticFireDateUTC = this.staticFireDateUTC,
        staticFireDateUnix = this.staticFireDateUnix,
        timeline = this.timeline?.convertToModelData(),
        crew = this.crew,
        lastDateWikipediaUpdate = this.lastDateWikipediaUpdate,
        isDateFromWikipedia = this.isDateFromWikipedia
    )
}

data class ResponseLaunchRocket(
    @field: Json(name = "rocket_id") val rocketID: String?,
    @field: Json(name = "rocket_name") val rocketName: String?,
    @field: Json(name = "rocket_type") val rocketType: String?,
    @field: Json(name = "first_stage") val firstStage: ResponseLaunchRocketFirstStage?,
    @field: Json(name = "second_stage") val secondStage: ResponseLaunchRocketSecondStage?,
    @field: Json(name = "fairings") val fairings: ResponseLaunchFairings?
) {
    fun convertToModelData(): LaunchRocket = LaunchRocket(
        rocketID = this.rocketID,
        rocketName = this.rocketName,
        rocketType = this.rocketType,
        firstStage = this.firstStage?.convertToModelData(),
        secondStage = this.secondStage?.convertToModelData(),
        fairings = this.fairings?.convertToModelData()
    )
}

data class ResponseLaunchRocketFirstStage(
    @field: Json(name = "cores") val cores: List<ResponseLaunchCores>?
) {
    fun convertToModelData(): LaunchRocketFirstStage {
        val modelCores = ArrayList<LaunchCores>()
        this.cores?.let { responseCores ->
            for (responseCore in responseCores) {
                modelCores.add(responseCore.convertToModelData())
            }
        }

        return LaunchRocketFirstStage(
            cores = modelCores
        )
    }
}

data class ResponseLaunchRocketSecondStage(
    @field: Json(name = "block") val block: Int?,
    @field: Json(name = "payloads") val payloads: List<ResponseLaunchPayload>?
) {
    fun convertToModelData(): LaunchRocketSecondStage {
        val modelPayloads = ArrayList<LaunchPayload>()
        this.payloads?.let { responsePayloads ->
            for (responsePayload in responsePayloads) {
                modelPayloads.add(responsePayload.convertToModelData())
            }
        }

        return LaunchRocketSecondStage(
            block = this.block,
            payloads = modelPayloads
        )
    }
}

data class ResponseLaunchTelemetry(
    @field: Json(name = "flight_club") val flightClub: String?
) {
    fun convertToModelData(): LaunchTelemetry = LaunchTelemetry(
        this.flightClub
    )
}

data class ResponseLaunchSites(
    @field: Json(name = "site_id") val siteID: String?,
    @field: Json(name = "site_name") val siteName: String?,
    @field: Json(name = "site_name_long") val siteNameLong: String?
) {
    fun convertToModelData(): LaunchSites = LaunchSites(
        siteID = this.siteID,
        siteName = this.siteName,
        siteNameLong = this.siteNameLong
    )
}

data class ResponseLaunchFailure(
    @field: Json(name = "time") val time: Long?,
    @field: Json(name = "altitude") val altitude: Long?,
    @field: Json(name = "reason") val reason: String?
) {
    fun convertToModelData(): LaunchFailure = LaunchFailure(
        time = this.time,
        altitude = this.altitude,
        reason = this.reason
    )
}

data class ResponseLaunchLinks(
    @field: Json(name = "mission_patch") val missionPatch: String?,
    @field: Json(name = "mission_patch_small") val missionPatchSmall: String?,
    @field: Json(name = "reddit_campaign") val redditCampaign: String?,
    @field: Json(name = "reddit_launch") val redditLaunch: String?,
    @field: Json(name = "reddit_recovery") val redditRecovery: String?,
    @field: Json(name = "reddit_media") val redditMedia: String?,
    @field: Json(name = "presskit") val pressKit: String?,
    @field: Json(name = "article_link") val articleLink: String?,
    @field: Json(name = "wikipedia") val wikipedia: String?,
    @field: Json(name = "video_link") val videoLink: String?,
    @field: Json(name = "youtube_id") val youtubeID: String?,
    @field: Json(name = "flickr_images") val flickerImages: List<String>?
) {
    fun convertToModelData(): LaunchLinks = LaunchLinks(
        missionPatch = this.missionPatch,
        missionPatchSmall = this.missionPatchSmall,
        redditCampaign = this.redditCampaign,
        redditLaunch = this.redditLaunch,
        redditRecovery = this.redditRecovery,
        redditMedia = this.redditMedia,
        pressKit = this.pressKit,
        articleLink = this.articleLink,
        wikipedia = this.wikipedia,
        videoLink = this.videoLink,
        youtubeID = this.youtubeID,
        flickerImages = this.flickerImages
    )
}

data class ResponseLaunchTimeline(
    @field: Json(name = "webcast_liftoff") val webCastLiftOff: Long?,
    @field: Json(name = "go_for_prop_loading") val goForPropulsionLanding: Long?,
    @field: Json(name = "rp1_loading") val rocketPropellant1Loading: Long?,
    @field: Json(name = "stage1_lox_loading") val stage1LiquidOxygenLoading: Long?,
    @field: Json(name = "stage2_lox_loading") val stage2LiquidOxygenLoading: Long?,
    @field: Json(name = "engine_chill") val engineChill: Long?,
    @field: Json(name = "prelaunch_checks") val preLaunchChecks: Long?,
    @field: Json(name = "propellant_pressurization") val propellantPressurization: Long?,
    @field: Json(name = "go_for_launch") val goForLaunch: Long?,
    @field: Json(name = "ignition") val ignition: Long?,
    @field: Json(name = "liftoff") val liftOff: Long?,
    @field: Json(name = "meco") val mainEngineCutoff: Long?,
    @field: Json(name = "stage_sep") val stageSeparation: Long?,
    @field: Json(name = "second_stage_ignition") val secondStageIgnition: Long?,
    @field: Json(name = "first_stage_boostback_burn") val firstStageBoostBackBurn: Long?,
    @field: Json(name = "first_stage_entry_burn") val firstStageEntryBurn: Long?,
    @field: Json(name = "first_stage_landing") val firstStageLanding: Long?,
    @field: Json(name = "second_stage_restart") val secondStageRestart: Long?,
    @field: Json(name = "seco-1") val secondStageEngineCutoff: Long?,
    @field: Json(name = "seco-2") val secondStageEngineCutoff2: Long?,
    @field: Json(name = "payload_deploy") val payloadDeploy: Long?,
    @field: Json(name = "dragon_separation") val dragonSeparation: Long?,
    @field: Json(name = "dragon_solar_deploy") val dragonSolarDeploy: Long?,
    @field: Json(name = "dragon_bay_door_deploy") val dragonBayDoorDeploy: Long?
) {
    fun convertToModelData(): LaunchTimeline = LaunchTimeline(
        webCastLiftOff = this.webCastLiftOff,
        goForPropulsionLanding = this.goForPropulsionLanding,
        rocketPropellant1Loading = this.rocketPropellant1Loading,
        stage1LiquidOxygenLoading = this.stage1LiquidOxygenLoading,
        stage2LiquidOxygenLoading = this.stage2LiquidOxygenLoading,
        engineChill = this.engineChill,
        preLaunchChecks = this.preLaunchChecks,
        propellantPressurization = this.propellantPressurization,
        goForLaunch = this.goForLaunch,
        ignition = this.ignition,
        liftOff = this.webCastLiftOff,
        mainEngineCutoff = this.mainEngineCutoff,
        stageSeparation = this.stageSeparation,
        secondStageIgnition = this.secondStageIgnition,
        firstStageBoostBackBurn = this.firstStageBoostBackBurn,
        firstStageEntryBurn = this.firstStageEntryBurn,
        firstStageLanding = this.firstStageLanding,
        secondStageRestart = this.secondStageRestart,
        secondStageEngineCutoff = this.secondStageEngineCutoff,
        secondStageEngineCutoff2 = this.secondStageEngineCutoff2,
        payloadDeploy = this.payloadDeploy,
        dragonSeparation = this.dragonSeparation,
        dragonSolarDeploy = this.dragonSolarDeploy,
        dragonBayDoorDeploy = this.dragonBayDoorDeploy
    )
}

data class ResponseLaunchPayload(
    @field: Json(name = "payload_id") val payloadID: String?,
    @field: Json(name = "norad_id") val noradID: List<Int>?,
    @field: Json(name = "cap_serial") val capSerial: String?,
    @field: Json(name = "reused") val reused: Boolean?,
    @field: Json(name = "customers") val customers: List<String>?,
    @field: Json(name = "nationality") val nationality: String?,
    @field: Json(name = "manufacturer") val manufacturer: String?,
    @field: Json(name = "payload_type") val payloadType: String?,
    @field: Json(name = "payload_mass_kg") val payloadMassKG: Double?,
    @field: Json(name = "payload_mass_lbs") val payloadMassLBs: Double?,
    @field: Json(name = "orbit") val orbit: String?,
    @field: Json(name = "orbit_params") val orbitParameters: ResponseLaunchOrbitParameters?,
    @field: Json(name = "mass_returned_kg") val massReturnedKG: Double?,
    @field: Json(name = "mass_returned_lbs") val massReturnedLBs: Double?,
    @field: Json(name = "flight_time_sec") val flightTimeInSeconds: Long?,
    @field: Json(name = "cargo_manifest") val cargoManifest: String?
) {
    fun convertToModelData(): LaunchPayload = LaunchPayload(
        payloadID = this.payloadID,
        noradID = this.noradID,
        capSerial = this.capSerial,
        reused = this.reused,
        customers = this.customers,
        nationality = this.nationality,
        manufacturer = this.manufacturer,
        payloadType = this.payloadType,
        payloadMassKG = this.payloadMassKG,
        payloadMassLBs = this.payloadMassLBs,
        orbit = this.orbit,
        orbitParameters = this.orbitParameters?.convertToModelData(),
        massReturnedKG = this.massReturnedKG,
        massReturnedLBs = this.massReturnedLBs,
        flightTimeInSeconds = this.flightTimeInSeconds,
        cargoManifest = this.cargoManifest
    )
}

data class ResponseLaunchOrbitParameters(
    @field: Json(name = "reference_system") val referenceSystem: String?,
    @field: Json(name = "regime") val regime: String?,
    @field: Json(name = "longitude") val longitude: Double?,
    @field: Json(name = "semi_major_axis_km") val semiMajorAxisKM: Double?,
    @field: Json(name = "eccentricity") val eccentricity: Double?,
    @field: Json(name = "periapsis_km") val periapsisKM: Double?,
    @field: Json(name = "apoapsis_km") val apoapsisKM: Double?,
    @field: Json(name = "inclination_deg") val inclinationDegree: Double?,
    @field: Json(name = "period_min") val minimumPeriod: Double?,
    @field: Json(name = "lifespan_years") val lifespanYears: Double?,
    @field: Json(name = "epoch") val epoch: String?,
    @field: Json(name = "mean_motion") val meanMotion: Double?,
    @field: Json(name = "raan") val raan: Double?,
    @field: Json(name = "arg_of_pericenter") val argumentOfPericenter: Double?,
    @field: Json(name = "mean_anomaly") val meanAnomaly: Double?
) {
    fun convertToModelData(): LaunchOrbitParameters = LaunchOrbitParameters(
        referenceSystem = this.referenceSystem,
        regime = this.regime,
        longitude = this.longitude,
        semiMajorAxisKM = this.semiMajorAxisKM,
        eccentricity = this.eccentricity,
        periapsisKM = this.periapsisKM,
        apoapsisKM = this.apoapsisKM,
        inclinationDegree = this.inclinationDegree,
        minimumPeriod = this.minimumPeriod,
        lifespanYears = this.lifespanYears,
        epoch = this.epoch,
        meanMotion = this.meanMotion,
        raan = this.raan,
        argumentOfPericenter = this.argumentOfPericenter,
        meanAnomaly = this.meanAnomaly
    )
}

data class ResponseLaunchFairings(
    @field: Json(name = "reused") val reused: Boolean?,
    @field: Json(name = "recovery_attempt") val recoveryAttempt: Boolean?,
    @field: Json(name = "recovered") val recovered: Boolean?,
    @field: Json(name = "ship") val ship: String?
) {
    fun convertToModelData(): LaunchFairings = LaunchFairings(
        reused = this.reused,
        recoveryAttempt = this.recoveryAttempt,
        recovered = this.recovered,
        ship = this.ship
    )
}

data class ResponseLaunchCores(
    @field: Json(name = "core_serial") val coreSerial: String?,
    @field: Json(name = "flight") val flight: Int?,
    @field: Json(name = "block") val block: Int?,
    @field: Json(name = "gridfins") val gridFine: Boolean?,
    @field: Json(name = "legs") val legs: Boolean?,
    @field: Json(name = "reused") val reused: Boolean?,
    @field: Json(name = "land_success") val landSuccess: Boolean?,
    @field: Json(name = "landing_intent") val landingIntent: Boolean?,
    @field: Json(name = "landing_type") val landingType: String?,
    @field: Json(name = "landing_vehicle") val landingVehicle: String?
) {
    fun convertToModelData(): LaunchCores = LaunchCores(
        coreSerial = this.coreSerial,
        flight = this.flight,
        block = this.block,
        gridFine = this.gridFine,
        legs = this.legs,
        reused = this.reused,
        landSuccess = this.landSuccess,
        landingIntent = this.landingIntent,
        landingType = this.landingType,
        landingVehicle = this.landingVehicle
    )
}