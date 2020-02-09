package ritwik.samples.spacex.model

data class Launch (
	val flightNumber :				Int?,
	val missionName :				String?,
	val missionID :					List <String >?,
	val launchYear :				String?,
	val launchDateUnix :			Long?,
	val launchDateUTC :				String?,
	val launchDateLocal :			String?,
	val isTentative :				Boolean?,
	val tentativeMaximumPrecision : String?,
	val tbd :						Boolean?,
	val launchWindow :				String?,
	val rocket :					LaunchRocket?,
	val ships :						List < String >?,
	val telemetry :					LaunchTelemetry?,
	val launchSite : 				LaunchSites?,
	val launchSuccess :				Boolean?,
	val launchFailureDetails :		LaunchFailure?,
	val links :						LaunchLinks?,
	val details :					String?,
	val upcoming :					Boolean?,
	val staticFireDateUTC :			String?,
	val staticFireDateUnix :		Long?,
	val timeline :					LaunchTimeline?,
	val crew :						List < String >?,
	val lastDateWikipediaUpdate :	String?,
	val isDateFromWikipedia :		Boolean?
) {
	override fun toString() : String {
		return flightNumber.toString ()
	}
}

data class LaunchRocket (
	val rocketID :		String?,
	val rocketName :	String?,
	val rocketType :	String?,
	val firstStage :	LaunchRocketFirstStage?,
	val secondStage :	LaunchRocketSecondStage?,
	val fairings :		LaunchFairings?
)

data class LaunchRocketFirstStage (
	val cores : List <LaunchCores>?
)

data class LaunchRocketSecondStage (
	val block :		Int?,
	val payloads :	List <LaunchPayload>?
)

data class LaunchTelemetry (
	val flightClub : String?
)

data class LaunchSites (
	val siteID :		String?,
	val siteName :		String?,
	val siteNameLong :	String?
)

data class LaunchFailure (
	val time :		Long?,
	val altitude :	Long?,
	val reason :	String?
)

data class LaunchLinks (
	val missionPatch : 		String?,
	val missionPatchSmall : String?,
	val redditCampaign :	String?,
	val redditLaunch :		String?,
	val redditRecovery :	String?,
	val redditMedia :		String?,
	val pressKit :			String?,
	val articleLink :		String?,
	val wikipedia :			String?,
	val videoLink :			String?,
	val youtubeID :			String?,
	val flickerImages :		List < String >?
)

data class LaunchTimeline (
	val webCastLiftOff :			Long?,
	val goForPropulsionLanding :	Long?,
	val rocketPropellant1Loading :	Long?,
	val stage1LiquidOxygenLoading : Long?,
	val stage2LiquidOxygenLoading : Long?,
	val engineChill :				Long?,
	val preLaunchChecks :			Long?,
	val propellantPressurization :	Long?,
	val goForLaunch :				Long?,
	val ignition :					Long?,
	val liftOff :					Long?,
	val mainEngineCutoff :			Long?,
	val stageSeparation :			Long?,
	val secondStageIgnition :		Long?,
	val firstStageBoostBackBurn : 	Long?,
	val firstStageEntryBurn :		Long?,
	val firstStageLanding :			Long?,
	val secondStageRestart :		Long?,
	val secondStageEngineCutoff :	Long?,
	val secondStageEngineCutoff2 :	Long?,
	val payloadDeploy :				Long?,
	val dragonSeparation :			Long?,
	val dragonSolarDeploy :			Long?,
	val dragonBayDoorDeploy : 		Long?
)

data class LaunchPayload (
	val payloadID :				String?,
	val noradID :				List < Int >?,
	val capSerial :				String?,
	val reused :				Boolean?,
	val customers :				List < String >?,
	val nationality :			String?,
	val manufacturer :			String?,
	val payloadType :			String?,
	val payloadMassKG :			Double?,
	val payloadMassLBs :		Double?,
	val orbit :					String?,
	val orbitParameters :		LaunchOrbitParameters?,
	val massReturnedKG :		Double?,
	val massReturnedLBs :		Double?,
	val flightTimeInSeconds :	Long?,
	val cargoManifest :			String?
)

data class LaunchOrbitParameters (
	val referenceSystem :		String?,
	val regime :				String?,
	val longitude :				Double?,
	val semiMajorAxisKM :		Double?,
	val eccentricity :			Double?,
	val periapsisKM :			Double?,
	val apoapsisKM :			Double?,
	val inclinationDegree :		Double?,
	val minimumPeriod :			Double?,
	val lifespanYears :			Double?,
	val epoch :					String?,
	val meanMotion :			Double?,
	val raan :					Double?,
	val argumentOfPericenter :	Double?,
	val meanAnomaly :			Double?
)

data class LaunchFairings (
	val reused :			Boolean?,
	val recoveryAttempt :	Boolean?,
	val recovered :			Boolean?,
	val ship :				String?
)

data class LaunchCores (
	val coreSerial :		String?,
	val flight :			Int?,
	val block :				Int?,
	val gridFine :			Boolean?,
	val legs :				Boolean?,
	val reused :			Boolean?,
	val landSuccess :		Boolean?,
	val landingIntent :		Boolean?,
	val landingType :		String?,
	val landingVehicle :	String?
)