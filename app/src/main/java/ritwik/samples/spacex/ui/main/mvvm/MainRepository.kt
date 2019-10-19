package ritwik.samples.spacex.ui.main.mvvm

import androidx.lifecycle.MutableLiveData

import kotlinx.coroutines.*

import retrofit2.Response

import ritwik.samples.spacex.application.database.LAUNCH_TYPE_PAST
import ritwik.samples.spacex.application.database.LAUNCH_TYPE_UPCOMING
import ritwik.samples.spacex.application.database.RESTServices

import ritwik.samples.spacex.pojo.launches.Launch
import ritwik.samples.spacex.pojo.rockets.Rocket

/**Repository of [MainViewModel].
 * @author Ritwik Jamuar.*/
class MainRepository (
	private val restServices : RESTServices?
) {
	// LiveData's
	private lateinit var upcomingLaunches : MutableLiveData < List < Launch > >
	private lateinit var pastLaunches : MutableLiveData < List < Launch > >
	private lateinit var allRockets : MutableLiveData < List < Rocket > >
	private lateinit var noInternet : MutableLiveData < Boolean >
	private lateinit var error : MutableLiveData < String >

	// Jobs
	private val completableJob : Job = Job ()

	// Constants.
	@Suppress ( "unused" )
	/**Static [String] for the future use of Logging.*/
	private val tag = MainRepository::class.java.simpleName

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {

		/**Creates the Instance of [MainRepository].
		 * @param restServices Instance of [RESTServices].
		 * @return Instance of [MainRepository]*/
		fun create ( restServices : RESTServices? ) : MainRepository = MainRepository ( restServices )

	}

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Fetches the Launches from [RESTServices] and notify the Observers of
	 * [upcomingLaunches] and [pastLaunches], depending on the value passed as
	 * [type].
	 * @param type Integer denoting what type of Launch to be fetched. It can be either
	 * [LAUNCH_TYPE_UPCOMING] or [LAUNCH_TYPE_PAST].*/
	fun getLaunches (
		type : Int,
		launches : MutableLiveData < List < Launch > >,
		noInternet : MutableLiveData < Boolean >,
		error : MutableLiveData < String >
	) {

		this.noInternet = noInternet
		this.error = error

		CoroutineScope ( Dispatchers.IO + completableJob )
			.launch {
				// Get the response on the basis of type.
				val response : Response < List < Launch > >? = when ( type ) {
					LAUNCH_TYPE_UPCOMING -> {
						upcomingLaunches = launches
						restServices?.getUpcomingLaunchesAsync ()
					}

					LAUNCH_TYPE_PAST -> {
						pastLaunches = launches
						restServices?.getPastLaunchesAsync ()
					}

					else -> {
						null
					}
				}

				// Notify the observers based on type provided
				withContext ( Dispatchers.Main ) {
					response?.let {
						// Convert the Response into List of Launches.
						val launchesList = response.body ()

						launchesList?.let {
							when ( type ) {

								LAUNCH_TYPE_UPCOMING -> {
									upcomingLaunches.value = launchesList
								}

								LAUNCH_TYPE_PAST -> {
									pastLaunches.value = launchesList
								}
							}
						}
					}
				}
			}
	}

	/**Fetches the [List] of [Rocket] from [RESTServices] and notify the
	 * [androidx.lifecycle.Observer] of [allRockets].*/
	fun getAllRockets (
		rocketsLiveData : MutableLiveData < List < Rocket > >,
		noInternet : MutableLiveData < Boolean >,
		error : MutableLiveData < String >
	) {

		this.allRockets = rocketsLiveData
		this.noInternet = noInternet
		this.error = error

		CoroutineScope ( Dispatchers.IO + completableJob )
			.launch {
				// Get the response on the basis of type.
				val response : Response < List < Rocket > >? = restServices?.getAllRockets ()

				// Convert the Retrofit Response to list of Rockets.
				val rockets = response?.body ()

				// Notify the update of Response in Main Thread.
				withContext ( Dispatchers.Main ) {
					rockets?.let {
						// Notify Live Data about change in the List of Rockets.
						allRockets.value = rockets
					}
				}
			}
	}

	/**
	 * Performs Cleanup of the resources associated with this repository.
	 */
	fun cleanUp () {
		completableJob.cancel ()
	}

}