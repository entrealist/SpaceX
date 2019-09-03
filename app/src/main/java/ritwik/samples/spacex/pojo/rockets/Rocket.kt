package ritwik.samples.spacex.pojo.rockets

import com.squareup.moshi.Json

data class Rocket (
	@field: Json ( name = "active" )			val active :				Boolean?,
	@field: Json ( name = "id" )				val id :					Int?,
	@field: Json ( name = "stages" )			val stages :				Int?,
	@field: Json ( name = "boosters" )			val boosters :				Int?,
	@field: Json ( name = "cost_per_launch" )	val costPerLaunch :			Long?,
	@field: Json ( name = "success_rate_pct" )	val successRateProject :	Int?,
	@field: Json ( name = "first_flight" )		val firstFlight :			String?,
	@field: Json ( name = "country" )			val country :				String?,
	@field: Json ( name = "company" )			val company :				String?,
	@field: Json ( name = "height" )			val height :				Height?,
	@field: Json ( name = "diameter" )			val diameter :				Diameter?,
	@field: Json ( name = "mass" )				val mass :					Mass?,
	@field: Json ( name = "payload_weights" )	val payLoadWeights :		List < PayloadWeight >?,
	@field: Json ( name = "first_stage" )		val firstStage :			FirstStage?,
	@field: Json ( name = "second_stage" )		val secondStage :			SecondStage?,
	@field: Json ( name = "engines" )			val engine :				Engine?,
	@field: Json ( name = "landing_legs" )		val landingLegs :			LandingLegs?,
	@field: Json ( name = "flickr_images" )		val flickrImages :			List < String >?,
	@field: Json ( name = "wikipedia" )			val wikipedia :				String?,
	@field: Json ( name = "description" )		val description :			String?,
	@field: Json ( name = "rocket_id" )			val rocketID :				String?,
	@field: Json ( name = "rocket_name" )		val rocketName :			String?,
	@field: Json ( name = "rocket_type" )		val rocketType :			String?
)

data class Height (
	@field: Json ( name = "meters" )	val scientific :	Double?,
	@field: Json ( name = "feet" )		val imperial :		Double?
)

data class Diameter (
	@field: Json ( name = "meters" )	val scientific :	Double?,
	@field: Json ( name = "feet" )		val imperial :		Double?
)

data class Mass (
	@field: Json ( name = "kg" )	val scientific :	Double?,
	@field: Json ( name = "lb" )	val imperial :		Double?
)

data class PayloadWeight (
	@field: Json ( name = "id" )	val id :				String?,
	@field: Json ( name = "name" )	val name :				String?,
	@field: Json ( name = "kg" )	val scientificMass :	Double?,
	@field: Json ( name = "lb" )	val imperialMass :		Double?
)

data class FirstStage (
	@field: Json ( name = "reusable" )			val reusable :			Boolean?,
	@field: Json ( name = "engines" )			val engines :			Int?,
	@field: Json ( name = "fuel_amount_tons" )	val fuelAmountInTons :	Double?,
	@field: Json ( name = "burn_time_sec" )		val burnTimeInSeconds :	Long?,
	@field: Json ( name = "thrust_sea_level" )	val thrustSeaLevel :	ThrustSeaLevel,
	@field: Json ( name = "thrust_vacuum" )		val thrustVacuum :		ThrustVacuum

)

data class ThrustSeaLevel (
	@field: Json ( name = "kN" )	val scientific :	Double?,
	@field: Json ( name = "lbf" )	val imperial :		Double?
)

data class ThrustVacuum (
	@field: Json ( name = "kN" )	val scientific :	Double?,
	@field: Json ( name = "lbf" )	val imperial :		Double?
)

data class SecondStage (
	@field: Json ( name = "reusable" ) val reusable : Boolean?,
	@field: Json ( name = "engines" ) val engines : Int?,
	@field: Json ( name = "fuel_amount_tons" ) val fuelAmountInTons : Double?,
	@field: Json ( name = "burn_time_sec" ) val burnTimeInSeconds : Long?,
	@field: Json ( name = "thrust" ) val thrust : Thrust,
	@field: Json ( name = "payloads" ) val payloads : Payloads
)

data class Thrust (
	@field: Json ( name = "kN" )	val scientific :	Double?,
	@field: Json ( name = "lbf" )	val imperial :		Double?
)

data class Payloads (
	@field: Json ( name = "option_1" )			val option1 :			String?,
	@field: Json ( name = "composite_fairing" )	val compositeFairing :	CompositeFairing?
)

data class CompositeFairing (
	@field: Json ( name = "height" )	val height :	Height?,
	@field: Json ( name = "diameter" )	val diameter :	Diameter?
)

data class Engine (
	@field: Json ( name = "number" )			val number :			Int?,
	@field: Json ( name = "type" )				val type :				String?,
	@field: Json ( name = "version" )			val version :			String?,
	@field: Json ( name = "layout" )			val layout :			String?,
	@field: Json ( name = "engine_loss_max" )	val maximumEngineLoss :	Long?,
	@field: Json ( name = "propellant_1" )		val firstPropellant :	String?,
	@field: Json ( name = "propellant_2" )		val secondPropellant :	String?,
	@field: Json ( name = "thrust_sea_level" )	val thrustSeaLevel :	ThrustSeaLevel,
	@field: Json ( name = "thrust_vacuum" )		val thrustVacuum :		ThrustVacuum?,
	@field: Json ( name = "thrust_to_weight" )	val thrustToWeight :	Double?
)

data class LandingLegs (
	@field: Json ( name = "number" )	val number :	Int?,
	@field: Json ( name = "material" )	val material :	String?
)