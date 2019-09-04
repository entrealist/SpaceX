package ritwik.samples.spacex.pojo.launches

import com.squareup.moshi.Json

data class Rocket (
	@field: Json ( name = "rocket_id" )		val rocketID :		String?,
	@field: Json ( name = "rocket_name" )	val rocketName :	String?,
	@field: Json ( name = "rocket_type" )	val rocketType :	String?,
	@field: Json ( name = "first_stage" )	val firstStage :	RocketFirstStage?,
	@field: Json ( name = "second_stage" )	val secondStage :	RocketSecondStage?,
	@field: Json ( name = "fairings" )		val fairings :		Fairings?
)