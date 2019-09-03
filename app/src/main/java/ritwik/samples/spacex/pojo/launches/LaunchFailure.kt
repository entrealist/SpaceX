package ritwik.samples.spacex.pojo.launches

import com.squareup.moshi.Json

data class LaunchFailure (
	@field: Json ( name = "time" )		val time :		Long?,
	@field: Json ( name = "altitude" )	val altitude :	Long?,
	@field: Json ( name = "reason" )	val reason :	String?
)