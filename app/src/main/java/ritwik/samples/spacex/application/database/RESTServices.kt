package ritwik.samples.spacex.application.database

import retrofit2.Response

import retrofit2.http.GET

import ritwik.samples.spacex.pojo.capsules.Capsule
import ritwik.samples.spacex.pojo.launches.Launch
import ritwik.samples.spacex.pojo.rockets.Rocket

/**[retrofit2.Retrofit] Interface that serves as End Point
 * for communicating with the RESTful Services.
 * @author Ritwik Jamuar.*/
interface RESTServices {

	/**Gets the List of Upcoming Launches of SpaceX.
	 * @return [Response] of type: [List] of [Launch].*/
	@GET ( ENDPOINT_LAUNCHES + ENDPOINT_SLASH + ENDPOINT_LAUNCHES_TYPE_UPCOMING )
	suspend fun getUpcomingLaunchesAsync () : Response < List <Launch> >

	/**Gets the List of Past Launches of SpaceX.
	 * @return [Response] of type: [List] of [Launch].*/
	@GET ( ENDPOINT_LAUNCHES + ENDPOINT_SLASH + ENDPOINT_LAUNCHES_TYPE_PAST )
	suspend fun getPastLaunchesAsync () : Response < List <Launch> >

	/**Gets the List of all the Rockets owned by SpaceX.
	 * @return [Response] of type: [List] of [Rocket].*/
	@GET ( ENDPOINT_ROCKETS )
	suspend fun getAllRockets () : Response < List < Rocket > >

	/**
	 * Gets the List of all the Capsules owned by SpaceX.
	 * @return [Response] of type: [List] of [Capsule].*/
	@GET ( ENDPOINT_CAPSULES )
	suspend fun getAllCapsules () : Response < List < Capsule > >

}