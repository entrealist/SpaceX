package ritwik.samples.spacex.application.database

import retrofit2.Response

import retrofit2.http.GET

import ritwik.samples.spacex.pojo.Launch

/**[retrofit2.Retrofit] Interface that serves as End Point
 * for communicating with the RESTful Services.
 * @author Ritwik Jamuar.*/
interface RESTServices {

	/**Gets the List of Upcoming Launches of SpaceX.
	 * @return [Response] of type: [List] of [Launch].*/
	@GET ( ENDPOINT_LAUNCHES + ENDPOINT_SLASH + ENDPOINT_LAUNCHES_TYPE_UPCOMING )
	suspend fun getUpcomingLaunchesAsync () : Response < List < Launch > >

	/**Gets the List of Past Launches of SpaceX.
	 * @return [Response] of type: [List] of [Launch].*/
	@GET ( ENDPOINT_LAUNCHES + ENDPOINT_SLASH + ENDPOINT_LAUNCHES_TYPE_PAST )
	suspend fun getPastLaunchesAsync () : Response < List < Launch > >

}