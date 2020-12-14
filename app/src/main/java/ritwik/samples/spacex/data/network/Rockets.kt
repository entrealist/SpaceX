package ritwik.samples.spacex.data.network

import com.squareup.moshi.Json

data class RocketResponse(
    @field: Json(name = "height") val height: RocketLengthResponse?,
    @field: Json(name = "diameter") val diameter: RocketLengthResponse?,
    @field: Json(name = "mass") val mass: RocketWeightResponse?,
    @field: Json(name = "first_stage") val firstStage: RocketFirstStageResponse?,
    @field: Json(name = "second_stage") val secondStage: RocketSecondStageResponse?,
    @field: Json(name = "engines") val engine: RocketEngineResponse?,
    @field: Json(name = "landing_legs") val landingLegs: RocketLandingLegsResponse?,
    @field: Json(name = "payload_weights") val payloads: List<RocketPayloadResponse>?,
    @field: Json(name = "flickr_images") val images: List<String>?,
    @field: Json(name = "name") val name: String?,
    @field: Json(name = "type") val type: String?,
    @field: Json(name = "active") val active: Boolean?,
    @field: Json(name = "stages") val stagesCount: Int?,
    @field: Json(name = "boosters") val boostersCount: Int?,
    @field: Json(name = "cost_per_launch") val costPerLaunch: Long?,
    @field: Json(name = "success_rate_pct") val successRatePercentage: Int?,
    @field: Json(name = "first_flight") val firstFlightDate: String?,
    @field: Json(name = "country") val country: String?,
    @field: Json(name = "company") val company: String?,
    @field: Json(name = "wikipedia") val wikipedia: String?,
    @field: Json(name = "description") val description: String?,
    @field: Json(name = "id") val id: String?
)

data class RocketLengthResponse(
    @field: Json(name = "meters") val meters: Float?,
    @field: Json(name = "feet") val feet: Float?
)

data class RocketWeightResponse(
    @field: Json(name = "kg") val kilogram: Float?,
    @field: Json(name = "lb") val pound: Float?
)

data class RocketThrustResponse(
    @field: Json(name = "kN") val kiloNewton: Float?,
    @field: Json(name = "lbf") val poundForce: Float?
)

data class RocketFirstStageResponse(
    @field: Json(name = "thrust_sea_level") val seaLevelThrust: RocketThrustResponse?,
    @field: Json(name = "thrust_vacuum") val vacuumThrust: RocketThrustResponse?,
    @field: Json(name = "reusable") val reusable: Boolean?,
    @field: Json(name = "engines") val enginesCount: Int?,
    @field: Json(name = "fuel_amount_tons") val fuelAmountInTons: Float?,
    @field: Json(name = "burn_time_sec") val burnTimeSeconds: Int?
)

data class RocketSecondStageResponse(
    @field: Json(name = "thrust") val thrust: RocketThrustResponse?,
    @field: Json(name = "payloads") val payloads: RocketSecondStagePayloadsResponse?,
    @field: Json(name = "reusable") val reusable: Boolean?,
    @field: Json(name = "engines") val engineCount: Int?,
    @field: Json(name = "fuel_amount_tons") val fuelAmountInTons: Float?,
    @field: Json(name = "burn_time_sec") val burnTimeSeconds: Int?
)

data class RocketSecondStagePayloadsResponse(
    @field: Json(name = "composite_fairing") val compositeFairing: RocketCompositeFairing?,
    @field: Json(name = "option_1") val option1: String?
)

data class RocketCompositeFairing(
    @field: Json(name = "height") val height: RocketLengthResponse?,
    @field: Json(name = "diameter") val diameter: RocketLengthResponse?
)

data class RocketEngineResponse(
    @field: Json(name = "isp") val isp: RocketEngineISPResponse?,
    @field: Json(name = "thrust_sea_level") val seaLevelThrust: RocketThrustResponse?,
    @field: Json(name = "thrust_vacuum") val vacuumThrust: RocketThrustResponse?,
    @field: Json(name = "number") val engineNumber: Int?,
    @field: Json(name = "type") val engineType: String?,
    @field: Json(name = "version") val engineVersionName: String?,
    @field: Json(name = "layout") val engineLayout: String?,
    @field: Json(name = "engine_loss_max") val maximumEngineLoss: Int?,
    @field: Json(name = "propellant_1") val propellant1: String?,
    @field: Json(name = "propellant_2") val propellant2: String?,
    @field: Json(name = "thrust_to_weight") val thrustToWeightRatio: Float?
)

data class RocketEngineISPResponse(
    @field: Json(name = "sea_level") val seaLevel: Float?,
    @field: Json(name = "vacuum") val vacuum: Float?
)

data class RocketLandingLegsResponse(
    @field: Json(name = "number") val number: Int?,
    @field: Json(name = "material") val material: String?
)

data class RocketPayloadResponse(
    @field: Json(name = "id") val id: String?,
    @field: Json(name = "name") val name: String?,
    @field: Json(name = "kg") val massInKilogram: Float?,
    @field: Json(name = "lb") val massInPound: Float?
)
