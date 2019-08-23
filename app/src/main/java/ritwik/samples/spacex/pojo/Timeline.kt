package ritwik.samples.spacex.pojo

import com.squareup.moshi.Json

data class Timeline (
	@field: Json ( name = "webcast_liftoff" )				val webCastLiftOff :			Long,
	@field: Json ( name = "go_for_prop_loading" )			val goForPropulsionLanding :	Long,
	@field: Json ( name = "rp1_loading" )					val rocketPropellant1Loading :	Long,
	@field: Json ( name = "stage1_lox_loading" )			val stage1LiquidOxygenLoading : Long,
	@field: Json ( name = "stage2_lox_loading" )			val stage2LiquidOxygenLoading : Long,
	@field: Json ( name = "engine_chill" )					val engineChill :				Long,
	@field: Json ( name = "prelaunch_checks" )				val preLaunchChecks :			Long,
	@field: Json ( name = "propellant_pressurization" ) 	val propellantPressurization :	Long,
	@field: Json ( name = "go_for_launch" )					val goForLaunch :				Long,
	@field: Json ( name = "ignition" )						val ignition :					Long,
	@field: Json ( name = "liftoff" )						val liftOff :					Long,
	@field: Json ( name = "meco" )							val mainEngineCutoff :			Long,
	@field: Json ( name = "stage_sep" )						val stageSeparation :			Long,
	@field: Json ( name = "second_stage_ignition" )			val secondStageIgnition :		Long,
	@field: Json ( name = "first_stage_boostback_burn" )	val firstStageBoostBackBurn : 	Long,
	@field: Json ( name = "first_stage_entry_burn" )		val firstStageEntryBurn :		Long,
	@field: Json ( name = "first_stage_landing" )			val firstStageLanding :			Long,
	@field: Json ( name = "second_stage_restart" )			val secondStageRestart :		Long,
	@field: Json ( name = "seco-1" )						val secondStageEngineCutoff :	Long,
	@field: Json ( name = "seco-2" )						val secondStageEngineCutoff2 :	Long,
	@field: Json ( name = "payload_deploy" )				val payloadDeploy :				Long,
	@field: Json ( name = "dragon_separation" )				val dragonSeparation :			Long,
	@field: Json ( name = "dragon_solar_deploy" )			val dragonSolarDeploy :			Long,
	@field: Json ( name = "dragon_bay_door_deploy" )		val dragonBayDoorDeploy : 		Long
)