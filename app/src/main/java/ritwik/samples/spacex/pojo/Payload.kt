package ritwik.samples.spacex.pojo

import com.squareup.moshi.Json

data class Payload (
	@field: Json ( name = "payload_id" )		val payloadID :				String,
	@field: Json ( name = "norad_id" )			val noradID :				List < Int >,
	@field: Json ( name = "cap_serial" )		val capSerial :				String,
	@field: Json ( name = "reused" )			val reused :				Boolean,
	@field: Json ( name = "customers" )			val customers :				List < String >,
	@field: Json ( name = "nationality" )		val nationality :			String,
	@field: Json ( name = "manufacturer" )		val manufacturer :			String,
	@field: Json ( name = "payload_type" )		val payloadType :			String,
	@field: Json ( name = "payload_mass_kg" )	val payloadMassKG :			Long,
	@field: Json ( name = "payload_mass_lbs" )	val payloadMassLBs :		Long,
	@field: Json ( name = "orbit" )				val orbit :					String,
	@field: Json ( name = "orbit_params" )		val orbitParameters :		OrbitParameters,
	@field: Json ( name = "mass_returned_kg" )	val massReturnedKG :		Long,
	@field: Json ( name = "mass_returned_lbs" ) val massReturnedLBs :		Long,
	@field: Json ( name = "flight_time_sec" )	val flightTimeInSeconds :	Long,
	@field: Json ( name = "cargo_manifest" )	val cargoManifest :			String
)