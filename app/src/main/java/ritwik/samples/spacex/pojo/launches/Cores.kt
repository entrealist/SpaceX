package ritwik.samples.spacex.pojo.launches

import com.squareup.moshi.Json

data class Cores (
	@field: Json ( name = "core_serial" )		val coreSerial :		String?,
	@field: Json ( name = "flight" )			val flight :			Int?,
	@field: Json ( name = "block" )				val block :				Int?,
	@field: Json ( name = "gridfins" )			val gridFine :			Boolean?,
	@field: Json ( name = "legs" )				val legs :				Boolean?,
	@field: Json ( name = "reused" )			val reused :			Boolean?,
	@field: Json ( name = "land_success" )		val landSuccess :		Boolean?,
	@field: Json ( name = "landing_intent" )	val landingIntent :		Boolean?,
	@field: Json ( name = "landing_type" )		val landingType :		String?,
	@field: Json ( name = "landing_vehicle" )	val landingVehicle :	String?
)