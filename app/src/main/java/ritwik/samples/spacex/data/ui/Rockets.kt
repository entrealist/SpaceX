package ritwik.samples.spacex.data.ui

/**
 * Data Class encapsulating the details of a Rocket.
 *
 * @param id [String] denoting the Rocket ID.
 * @param name [String] denoting the Rocket Name.
 * @param type [String] denoting the Rocket Type.
 * @param active [Boolean] to tell whether this Rocket is active or not.
 * @param description [String] denoting the Rocket Description.
 * @param dimension Instance of [RocketDimension] encapsulating the dimension details of the Rocket.
 * @param weight Instance of [RocketWeight] encapsulating the weight details of the Rocket.
 * @param engine Instance of [RocketEngine] encapsulating the details of Engine or the Rocket.
 * @param payloads [List] of [RocketPayload] encapsulating the payloads belonging to this Rocket.
 * @param stages [Int] denoting the Count of Stages involved for this Rocket.
 * @param boosters [Int] denoting the Count of Rocket Boosters used.
 * @param costPerLaunch [Long] denoting the Cost-per-Launch incurred for this Rocket.
 * @param successRatePercentage [Int] as the Percentage Value of Success Rate of this Rocket.
 * @param firstFlightDate [String] denoting the Date at which this Rocket took it's first flight.
 * @param country [String] denoting the Country of Origin of this Rocket.
 * @param company [String] denoting the Company to which this Rocket belongs to.
 * @param images [List] of [String] encapsulating the URLs pointing to Images of this Rocket.
 */
data class Rocket(
    val id: String,
    val name: String,
    val type: String,
    val active: Boolean,
    val description: String,
    val dimension: RocketDimensions,
    val weight: RocketWeight,
    val engine: RocketEngine,
    val payloads: List<RocketPayload>,
    val stages: Int,
    val boosters: Int,
    val costPerLaunch: Long,
    val successRatePercentage: Int,
    val firstFlightDate: String,
    val country: String,
    val company: String,
    val images: List<String>
)

/**
 * Data Class encapsulating the dimensions of the [Rocket].
 *
 * @param height Instance of [RocketDimension] encapsulating the height of the [Rocket].
 * @param diameter Instance of [RocketDimension] encapsulating the diameter of the [Rocket].
 * @author Ritwik Jamuar
 */
data class RocketDimensions(val height: RocketDimension, val diameter: RocketDimension)

/**
 * Data Class encapsulating the dimension of the [Rocket].
 *
 * @author Ritwik Jamuar
 */
data class RocketDimension(override val scientific: Float, override val imperial: Float) : Length()

/**
 * Data Class encapsulating the weight of the [Rocket].
 *
 * @author Ritwik Jamuar
 */
data class RocketWeight(override val scientific: Float, override val imperial: Float) : Weight()

/**
 * Data Class encapsulating the details of Engine of the [Rocket].
 *
 * @param number [Int] denoting the Engine Number.
 * @param version [String] denoting the Version Name of Engine.
 * @param type [String] denoting the Type of Engine.
 * @param layout [String] denoting the Engine Layout.
 * @param maximumEngineLoss [Float] denoting the Maximum Loss incurred by the Engine.
 * @param propellants [List] of [String] denoting the Propellants used by the Engine.
 * @param thrustToWeightRatio [Int] denoting the Thrust-to-Weight Ration with Weight being 1 part.
 *   Ex- thrustToWeightRatio = 42 ===> thrust : weight = 42 : 1.
 * @param thrust Instance of [RocketEngineThrusts] encapsulating the Thrust Values of this Engine.
 * @param specificImpulse Instance of [RocketEngineSpecificImpulse] encapsulating the
 *   values of Specific Impulse.
 * @author Ritwik Jamuar
 */
data class RocketEngine(
    val number: Int,
    val version: String,
    val type: String,
    val layout: String,
    val maximumEngineLoss: Float,
    val propellants: List<String>,
    val thrustToWeightRatio: Float?,
    val thrust: RocketEngineThrusts,
    val specificImpulse: RocketEngineSpecificImpulse
)

/**
 * Data Class encapsulating the Specific Impulse of the [Rocket].
 *
 * @param seaLevel [Float] as the Specific Impulse Value at Sea Level.
 * @param vacuum [Float] as the Specific Impulse Value at Vacuum.
 */
data class RocketEngineSpecificImpulse(val seaLevel: Float, val vacuum: Float)

/**
 * Data Class encapsulating the Thrust values of a [Rocket].
 *
 * @param seaLevel Instance of [RocketEngineThrust] as the Thrust of Rocket in Sea Level.
 * @param vacuum Instance of [RocketEngineThrust] as the Thrust of Rocket in Sea Level.
 * @author Ritwik Jamuar
 */
data class RocketEngineThrusts(val seaLevel: RocketEngineThrust, val vacuum: RocketEngineThrust)

/**
 * Data Class encapsulating the the Thrust of [Rocket].
 *
 * @author Ritwik Jamuar
 */
data class RocketEngineThrust(override val scientific: Float, override val imperial: Float) :
    Force()

/**
 * Data Class encapsulating the individual payload of the [Rocket].
 *
 * @param id [String] denoting the ID of the Payload.
 * @param name [String] denoting the Name of the Payload.
 * @param weight Instance of [RocketPayloadWeight]
 *   encapsulating the details of weight of the payload/
 * @author Ritwik Jamuar
 */
data class RocketPayload(val id: String, val name: String, val weight: RocketPayloadWeight)

/**
 * Data Class encapsulating the [Weight] of [RocketPayload].
 *
 * @author Ritwik Jamuar
 */
data class RocketPayloadWeight(override val scientific: Float, override val imperial: Float) :
    Weight()

/**
 * Abstract Class denoting the Length.
 *
 * @author Ritwik Jamuar
 */
abstract class Length {

    /*------------------------------------- Member Variables -------------------------------------*/

    /**
     * [Float] as the length in Scientific Unit (Meter : m).
     */
    abstract val scientific: Float

    /**
     * [Float] as the length in Scientific Unit (Feet : ft).
     */
    abstract val imperial: Float

    /*------------------------------------- Object Callbacks -------------------------------------*/

    override fun toString(): String = "$scientific m / $imperial ft"

}

/**
 * Abstract Class denoting the Weight.
 *
 * @author Ritwik Jamuar
 */
abstract class Weight {

    /*------------------------------------- Member Variables -------------------------------------*/

    /**
     * [Float] as the weight in Scientific Unit (Kilogram : kg).
     */
    abstract val scientific: Float

    /**
     * [Float] as the weight in Imperial Unit (Pound : lb).
     */
    abstract val imperial: Float

    /*------------------------------------- Object Callbacks -------------------------------------*/

    override fun toString(): String = "$scientific kg / $imperial lb"

}

/**
 * Abstract Class denoting the content of a Force.
 *
 * @author Ritwik Jamuar
 */
abstract class Force {

    /*------------------------------------- Member Variables -------------------------------------*/

    /**
     * [Float] as the Force in Scientific Unit (Kilo-Newton : kN).
     */
    abstract val scientific: Float

    /**
     * [Float] as the Force in Imperial Unit (Pound-Force : lbF).
     */
    abstract val imperial: Float

    /*------------------------------------- Object Callbacks -------------------------------------*/

    override fun toString(): String = "$scientific kN / $imperial lbF"

}
