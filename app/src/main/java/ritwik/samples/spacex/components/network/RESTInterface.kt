package ritwik.samples.spacex.components.network

import retrofit2.http.GET

import ritwik.samples.spacex.data.network.LaunchResponse
import ritwik.samples.spacex.data.network.RocketResponse

import ritwik.samples.spacex.utility.constant.API_CALL_PAST_LAUNCHES
import ritwik.samples.spacex.utility.constant.API_CALL_ROCKETS
import ritwik.samples.spacex.utility.constant.API_CALL_UPCOMING_LAUNCHES

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

}
