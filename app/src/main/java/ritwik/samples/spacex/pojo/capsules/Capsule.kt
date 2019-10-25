package ritwik.samples.spacex.pojo.capsules

import com.squareup.moshi.Json

data class Capsule (
	@field: Json ( name = "capsule_serial" ) val capsuleSerial : String,
	@field: Json ( name = "capsule_id" ) val capsuleID : String,
	@field: Json ( name = "status" ) val status : String,
	@field: Json ( name = "original_launch" ) val launchTimeUTC : String,
	@field: Json ( name = "original_launch_unix" ) val launchTimeUnix : Long?,
	@field: Json ( name = "missions" ) val missions : List < Mission >,
	@field: Json ( name = "landings" ) val landings : Long,
	@field: Json ( name = "type" ) val type : String,
	@field: Json ( name = "details" ) val details : String,
	@field: Json ( name = "reuse_count" ) val reuseCount : Long
)

data class Mission (
	@field: Json ( name = "name" ) val name : String,
	@field: Json ( name = "flight" ) val flight : Long
)