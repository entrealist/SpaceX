package ritwik.samples.spacex.components.network

import retrofit2.http.GET

import ritwik.samples.spacex.data.network.CapsuleResponse
import ritwik.samples.spacex.data.network.CoreResponse
import ritwik.samples.spacex.data.network.LaunchResponse
import ritwik.samples.spacex.data.network.RocketResponse

import ritwik.samples.spacex.utility.constant.*

/**
 * Retrofit's Interface to map out different REST End-Points.
 *
 * @author Ritwik Jamuar
 */
interface RESTInterface {

    /**
     * Fetches the Upcoming Launches.
     *
     * @return [List] of [LaunchResponse] denoting the Launches.
     */
    @GET(API_CALL_UPCOMING_LAUNCHES)
    suspend fun getUpcomingLaunches(): List<LaunchResponse>

    /**
     * Fetches the Past Launches.
     *
     * @return [List] of [LaunchResponse] denoting the Launches.
     */
    @GET(API_CALL_PAST_LAUNCHES)
    suspend fun getPastLaunches(): List<LaunchResponse>

    /**
     * Fetches all the Rockets.
     *
     * @return [List] of [RocketResponse] denoting the Rockets.
     */
    @GET(API_CALL_ROCKETS)
    suspend fun getAllRockets(): List<RocketResponse>

    /**
     * Fetches all the Capsules.
     *
     * @return [List] of [CapsuleResponse] denoting the Capsules.
     */
    @GET(API_CALL_CAPSULES)
    suspend fun getAllCapsules(): List<CapsuleResponse>

    /**
     * Fetches all the Cores.
     *
     * @return [List] of [CoreResponse] denoting the Cores.
     */
    @GET(API_CALL_CORES)
    suspend fun getAllCores(): List<CoreResponse>

}
