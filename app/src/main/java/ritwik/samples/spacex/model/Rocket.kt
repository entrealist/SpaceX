package ritwik.samples.spacex.model

data class Rocket (
	val active :				Boolean?,
	val id :					Int?,
	val stages :				Int?,
	val boosters :				Int?,
	val costPerLaunch :			Long?,
	val successRateProject :	Int?,
	val firstFlight :			String?,
	val country :				String?,
	val company :				String?,
	val height :				RocketHeight?,
	val diameter :				RocketDiameter?,
	val mass :					RocketMass?,
	val payLoadWeights :		List <RocketPayloadWeight>?,
	val firstStage :			RocketFirstStage?,
	val secondStage :			RocketSecondStage?,
	val engine :				RocketEngine?,
	val landingLegs :			RocketLandingLegs?,
	val flickrImages :			List < String >?,
	val wikipedia :				String?,
	val description :			String?,
	val rocketID :				String?,
	val rocketName :			String?,
	val rocketType :			String?
)

data class RocketHeight (
	val scientific :	Double?,
	val imperial :		Double?
)

data class RocketDiameter (
	val scientific :	Double?,
	val imperial :		Double?
)

data class RocketMass (
	val scientific :	Double?,
	val imperial :		Double?
)

data class RocketPayloadWeight (
	val id :				String?,
	val name :				String?,
	val scientificMass :	Double?,
	val imperialMass :		Double?
)

data class RocketFirstStage (
	val reusable :			Boolean?,
	val engines :			Int?,
	val fuelAmountInTons :	Double?,
	val burnTimeInSeconds :	Long?,
	val thrustSeaLevel : RocketThrustSeaLevel,
	val thrustVacuum : RocketThrustVacuum
)

data class RocketThrustSeaLevel (
	val scientific :	Double?,
	val imperial :		Double?
)

data class RocketThrustVacuum (
	val scientific :	Double?,
	val imperial :		Double?
)

data class RocketSecondStage (
	val reusable : Boolean?,
	val engines : Int?,
	val fuelAmountInTons : Double?,
	val burnTimeInSeconds : Long?,
	val thrust : RocketThrust,
	val payloads : RocketPayloads
)

data class RocketThrust (
	val scientific :	Double?,
	val imperial :		Double?
)

data class RocketPayloads (
	val option1 :			String?,
	val compositeFairing :	RocketCompositeFairing?
)

data class RocketCompositeFairing (
	val height :	RocketHeight?,
	val diameter :	RocketDiameter?
)

data class RocketEngine (
	val number :			Int?,
	val type :				String?,
	val version :			String?,
	val layout :			String?,
	val maximumEngineLoss :	Long?,
	val firstPropellant :	String?,
	val secondPropellant :	String?,
	val thrustSeaLevel : RocketThrustSeaLevel,
	val thrustVacuum :		RocketThrustVacuum?,
	val thrustToWeight :	Double?
)

data class RocketLandingLegs (
	val number :	Int?,
	val material :	String?
)