package ritwik.samples.spacex.pojo

import com.squareup.moshi.Json
import ritwik.samples.spacex.model.*

data class ResponseRocket(
    @field: Json(name = "active") val active: Boolean?,
    @field: Json(name = "id") val id: Int?,
    @field: Json(name = "stages") val stages: Int?,
    @field: Json(name = "boosters") val boosters: Int?,
    @field: Json(name = "cost_per_launch") val costPerLaunch: Long?,
    @field: Json(name = "success_rate_pct") val successRateProject: Int?,
    @field: Json(name = "first_flight") val firstFlight: String?,
    @field: Json(name = "country") val country: String?,
    @field: Json(name = "company") val company: String?,
    @field: Json(name = "height") val height: ResponseRocketHeight?,
    @field: Json(name = "diameter") val diameter: ResponseRocketDiameter?,
    @field: Json(name = "mass") val mass: ResponseRocketMass?,
    @field: Json(name = "payload_weights") val payLoadWeights: List<ResponseRocketPayloadWeight>?,
    @field: Json(name = "first_stage") val firstStage: ResponseRocketFirstStage?,
    @field: Json(name = "second_stage") val secondStage: ResponseRocketSecondStage?,
    @field: Json(name = "engines") val engine: ResponseRocketEngine?,
    @field: Json(name = "landing_legs") val landingLegs: ResponseRocketLandingLegs?,
    @field: Json(name = "flickr_images") val flickrImages: List<String>?,
    @field: Json(name = "wikipedia") val wikipedia: String?,
    @field: Json(name = "description") val description: String?,
    @field: Json(name = "rocket_id") val rocketID: String?,
    @field: Json(name = "rocket_name") val rocketName: String?,
    @field: Json(name = "rocket_type") val rocketType: String?
) {
    fun convertToModelData(): Rocket {
        val modelPayLoadWeights = ArrayList<RocketPayloadWeight>()
        this.payLoadWeights?.let { weights ->
            for (weight in weights) {
                modelPayLoadWeights.add(weight.convertToModelData())
            }
        }

        return Rocket(
            active = this.active,
            id = this.id,
            stages = this.stages,
            boosters = this.boosters,
            costPerLaunch = this.costPerLaunch,
            successRateProject = this.successRateProject,
            firstFlight = this.firstFlight,
            country = this.country,
            company = this.company,
            height = this.height?.convertToModelData(),
            diameter = this.diameter?.convertToModelData(),
            mass = this.mass?.convertToModelData(),
            payLoadWeights = modelPayLoadWeights,
            firstStage = this.firstStage?.convertToModelData(),
            secondStage = this.secondStage?.convertToModelData(),
            engine = this.engine?.convertToModelData(),
            landingLegs = this.landingLegs?.convertToModelData(),
            flickrImages = this.flickrImages,
            wikipedia = this.wikipedia,
            description = this.description,
            rocketID = this.rocketID,
            rocketName = this.rocketName,
            rocketType = this.rocketType
        )
    }
}

data class ResponseRocketHeight(
    @field: Json(name = "meters") val scientific: Double?,
    @field: Json(name = "feet") val imperial: Double?
) {
    fun convertToModelData(): RocketHeight =
        RocketHeight(
            scientific = this.scientific,
            imperial = this.imperial
        )
}

data class ResponseRocketDiameter(
    @field: Json(name = "meters") val scientific: Double?,
    @field: Json(name = "feet") val imperial: Double?
) {
    fun convertToModelData(): RocketDiameter =
        RocketDiameter(
            scientific = this.scientific,
            imperial = this.imperial
        )
}

data class ResponseRocketMass(
    @field: Json(name = "kg") val scientific: Double?,
    @field: Json(name = "lb") val imperial: Double?
) {
    fun convertToModelData(): RocketMass =
        RocketMass(
            scientific = this.scientific,
            imperial = this.imperial
        )
}

data class ResponseRocketPayloadWeight(
    @field: Json(name = "id") val id: String?,
    @field: Json(name = "name") val name: String?,
    @field: Json(name = "kg") val scientificMass: Double?,
    @field: Json(name = "lb") val imperialMass: Double?
) {
    fun convertToModelData(): RocketPayloadWeight =
        RocketPayloadWeight(
            id = this.id,
            name = this.name,
            scientificMass = this.scientificMass,
            imperialMass = this.imperialMass
        )
}

data class ResponseRocketFirstStage(
    @field: Json(name = "reusable") val reusable: Boolean?,
    @field: Json(name = "engines") val engines: Int?,
    @field: Json(name = "fuel_amount_tons") val fuelAmountInTons: Double?,
    @field: Json(name = "burn_time_sec") val burnTimeInSeconds: Long?,
    @field: Json(name = "thrust_sea_level") val thrustSeaLevel: ResponseRocketThrustSeaLevel,
    @field: Json(name = "thrust_vacuum") val thrustVacuum: ResponseRocketThrustVacuum
) {
    fun convertToModelData(): RocketFirstStage =
        RocketFirstStage(
            reusable = this.reusable,
            engines = this.engines,
            fuelAmountInTons = this.fuelAmountInTons,
            burnTimeInSeconds = this.burnTimeInSeconds,
            thrustSeaLevel = this.thrustSeaLevel.convertToModelData(),
            thrustVacuum = this.thrustVacuum.convertToModelData()
        )
}

data class ResponseRocketThrustSeaLevel(
    @field: Json(name = "kN") val scientific: Double?,
    @field: Json(name = "lbf") val imperial: Double?
) {
    fun convertToModelData(): RocketThrustSeaLevel =
        RocketThrustSeaLevel(
            scientific = this.scientific,
            imperial = this.imperial
        )
}

data class ResponseRocketThrustVacuum(
    @field: Json(name = "kN") val scientific: Double?,
    @field: Json(name = "lbf") val imperial: Double?
) {
    fun convertToModelData(): RocketThrustVacuum =
        RocketThrustVacuum(
            scientific = this.scientific,
            imperial = this.imperial
        )
}

data class ResponseRocketSecondStage(
    @field: Json(name = "reusable") val reusable: Boolean?,
    @field: Json(name = "engines") val engines: Int?,
    @field: Json(name = "fuel_amount_tons") val fuelAmountInTons: Double?,
    @field: Json(name = "burn_time_sec") val burnTimeInSeconds: Long?,
    @field: Json(name = "thrust") val thrust: ResponseRocketThrust,
    @field: Json(name = "payloads") val payloads: ResponseRocketPayloads
) {
    fun convertToModelData(): RocketSecondStage =
        RocketSecondStage(
            reusable = this.reusable,
            engines = this.engines,
            fuelAmountInTons = this.fuelAmountInTons,
            burnTimeInSeconds = this.burnTimeInSeconds,
            thrust = this.thrust.convertToModelData(),
            payloads = this.payloads.convertToModelData()
        )
}

data class ResponseRocketThrust(
    @field: Json(name = "kN") val scientific: Double?,
    @field: Json(name = "lbf") val imperial: Double?
) {
    fun convertToModelData(): RocketThrust =
        RocketThrust(
            scientific = this.scientific,
            imperial = this.imperial
        )
}

data class ResponseRocketPayloads(
    @field: Json(name = "option_1") val option1: String?,
    @field: Json(name = "composite_fairing") val compositeFairing: ResponseRocketCompositeFairing?
) {
    fun convertToModelData(): RocketPayloads =
        RocketPayloads(
            option1 = this.option1,
            compositeFairing = this.compositeFairing?.convertToModelData()
        )
}

data class ResponseRocketCompositeFairing(
    @field: Json(name = "height") val height: ResponseRocketHeight?,
    @field: Json(name = "diameter") val diameter: ResponseRocketDiameter?
) {
    fun convertToModelData(): RocketCompositeFairing =
        RocketCompositeFairing(
            height = this.height?.convertToModelData(),
            diameter = this.diameter?.convertToModelData()
        )
}

data class ResponseRocketEngine(
    @field: Json(name = "number") val number: Int?,
    @field: Json(name = "type") val type: String?,
    @field: Json(name = "version") val version: String?,
    @field: Json(name = "layout") val layout: String?,
    @field: Json(name = "engine_loss_max") val maximumEngineLoss: Long?,
    @field: Json(name = "propellant_1") val firstPropellant: String?,
    @field: Json(name = "propellant_2") val secondPropellant: String?,
    @field: Json(name = "thrust_sea_level") val thrustSeaLevel: ResponseRocketThrustSeaLevel,
    @field: Json(name = "thrust_vacuum") val thrustVacuum: ResponseRocketThrustVacuum?,
    @field: Json(name = "thrust_to_weight") val thrustToWeight: Double?
) {
    fun convertToModelData(): RocketEngine =
        RocketEngine(
            number = this.number,
            type = this.type,
            version = this.version,
            layout = this.layout,
            maximumEngineLoss = this.maximumEngineLoss,
            firstPropellant = this.firstPropellant,
            secondPropellant = this.secondPropellant,
            thrustSeaLevel = this.thrustSeaLevel.convertToModelData(),
            thrustVacuum = this.thrustVacuum?.convertToModelData(),
            thrustToWeight = thrustToWeight
        )
}

data class ResponseRocketLandingLegs(
    @field: Json(name = "number") val number: Int?,
    @field: Json(name = "material") val material: String?
) {
    fun convertToModelData(): RocketLandingLegs =
        RocketLandingLegs(
            number = this.number,
            material = this.material
        )
}