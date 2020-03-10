package ritwik.samples.spacex.application.database

import retrofit2.Call
import retrofit2.Response

import retrofit2.http.GET

import ritwik.samples.spacex.pojo.*

/**[retrofit2.Retrofit] Interface that serves as End Point
 * for communicating with the RESTful Services.
 * @author Ritwik Jamuar.*/
interface RESTServices {

    /**Gets the List of Upcoming Launches of SpaceX.
     * @return [Response] of type: [List] of [ResponseLaunch].*/
    @GET(ENDPOINT_LAUNCHES + ENDPOINT_SLASH + ENDPOINT_LAUNCHES_TYPE_UPCOMING)
    fun getUpcomingLaunches(): Call<List<ResponseLaunch>>

    /**Gets the List of Past Launches of SpaceX.
     * @return [Response] of type: [List] of [ResponseLaunch].*/
    @GET(ENDPOINT_LAUNCHES + ENDPOINT_SLASH + ENDPOINT_LAUNCHES_TYPE_PAST)
    fun getPastLaunches(): Call<List<ResponseLaunch>>

    /**Gets the List of all the Rockets owned by SpaceX.
     * @return [Response] of type: [List] of [ResponseRocket].*/
    @GET(ENDPOINT_ROCKETS)
    fun getAllRockets(): Call<List<ResponseRocket>>

    /**Gets the List of all the Capsules owned by SpaceX.
     * @return [Response] of type: [List] of [ResponseCapsule].*/
    @GET(ENDPOINT_CAPSULES)
    fun getAllCapsules(): Call<List<ResponseCapsule>>

    /**Gets the List of all the Cores owned by SpaceX.
     * @return [Response] of type: [List] of [ResponseCore].*/
    @GET(ENDPOINT_CORES)
    fun getAllCores(): Call<List<ResponseCore>>

	/**
	 * Gets the information about the Company.
	 * @return [Response] of type: [ResponseCompany].
	 */
	@GET(ENDPOINT_INFO)
	fun getInfo() : Call<ResponseCompany>

}