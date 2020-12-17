package ritwik.samples.spacex.components.network

import retrofit2.http.GET

import ritwik.samples.spacex.data.network.*

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

    /**
     * Fetches the details of the Company.
     *
     * @return Instance of [CompanyResponse] encapsulating the details of the Company.
     */
    @GET(API_CALL_ABOUT_COMPANY)
    suspend fun getInfoAboutCompany(): CompanyResponse

    /**
     * Fetches all the Historic Events of SpaceX.
     *
     * @return [List] of [HistoricEventResponse] denoting the Historic Events of SpaceX.
     */
    @GET(API_CALL_HISTORY)
    suspend fun getHistoricEvents(): List<HistoricEventResponse>

}
