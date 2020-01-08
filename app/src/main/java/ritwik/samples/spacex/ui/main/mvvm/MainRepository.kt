package ritwik.samples.spacex.ui.main.mvvm

import androidx.lifecycle.MutableLiveData

import kotlinx.coroutines.*

import retrofit2.Response

import ritwik.samples.spacex.application.database.LAUNCH_TYPE_PAST
import ritwik.samples.spacex.application.database.LAUNCH_TYPE_UPCOMING
import ritwik.samples.spacex.application.database.RESTServices

import ritwik.samples.spacex.pojo.capsules.Capsule
import ritwik.samples.spacex.pojo.launches.Launch
import ritwik.samples.spacex.pojo.rockets.Rocket

/**Repository of [MainViewModel].
 * @author Ritwik Jamuar.*/
class MainRepository (
	private val restServices : RESTServices?
) {
	// LiveData's
	var upcomingLaunchesLiveData = MutableLiveData < List <Launch> > ()
	var pastLaunchesLiveData = MutableLiveData < List <Launch> > ()
	var allRocketsLiveData = MutableLiveData < List < Rocket > > ()
	var allCapsulesLiveData = MutableLiveData<List<Capsule>>()

	// Jobs
	val completableJob : Job = Job ()

	// Lists.
	private var launches : List <Launch>? = null
	private var rockets :	List < Rocket >? = null
	private var capsules: List<Capsule>? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {
		/**Static [String] for the future use of Logging.*/
		@Suppress ( "unused" )
		const val TAG : String = "MainRepository"

		/**Creates the Instance of [MainRepository].
		 * @param restServices Instance of [RESTServices].
		 * @return Instance of [MainRepository]*/
		fun create ( restServices : RESTServices? ) : MainRepository {
			val repository = MainRepository ( restServices )
			repository.upcomingLaunchesLiveData.value = ArrayList (0 )
			repository.pastLaunchesLiveData.value = ArrayList ( 0 )
			return repository
		}
	}

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Fetches the Launches from [RESTServices] and notify the Observers of
	 * [upcomingLaunchesLiveData] and [pastLaunchesLiveData], depending on the value passed as
	 * [type].
	 * @param type Integer denoting what type of Launch to be fetched. It can be either
	 * [LAUNCH_TYPE_UPCOMING] or [LAUNCH_TYPE_PAST].*/
	fun getLaunches ( type : Int ) {
		CoroutineScope ( Dispatchers.IO + completableJob )
			.launch {
				// Get the response on the basis of type.
				val response : Response < List <Launch> >? = when ( type ) {
					LAUNCH_TYPE_UPCOMING -> {
						restServices?.getUpcomingLaunchesAsync ()
					}

					LAUNCH_TYPE_PAST -> {
						restServices?.getPastLaunchesAsync ()
					}

					else -> {
						null
					}
				}

				// Notify the observers based on type provided
				withContext ( Dispatchers.Main ) {
					// Convert the
					launches = response?.body ()

					when ( type ) {
						LAUNCH_TYPE_UPCOMING -> {
							upcomingLaunchesLiveData.value = launches
						}

						LAUNCH_TYPE_PAST -> {
							pastLaunchesLiveData.value = launches
						}
					}
				}
			}
	}

	/**Fetches the [List] of [Rocket] from [RESTServices] and notify the
	 * [androidx.lifecycle.Observer] of [allRocketsLiveData].*/
	fun getAllRockets () {
		CoroutineScope ( Dispatchers.IO + completableJob )
			.launch {
				// Get the response on the basis of type.
				val response : Response < List < Rocket > >? = restServices?.getAllRockets ()

				// Convert the Retrofit Response to list of Rockets.
				rockets = response?.body ()

				// Notify the update of Response in Main Thread.
				withContext ( Dispatchers.Main ) {
					// Notify Live Data about change in the List of Rockets.
					allRocketsLiveData.value = rockets
				}
			}
	}

	/**Fetches the [List] of [Capsule] from [RESTServices] and notify the
	 * [androidx.lifecycle.Observer] of [allCapsulesLiveData].*/
	fun getAllCapsules() {
		CoroutineScope(Dispatchers.IO + completableJob)
			.launch {
				// Get the response.
				val response: Response<List<Capsule>>? = restServices?.getAllCapsules()

				// Convert the Retrofit Response to list of Capsules.
				capsules = response?.body()

				// Notify the update of Response in Main Thread.
				withContext(Dispatchers.Main) {
					// Notify Live Data about change in the List of Capsules.
					allCapsulesLiveData.value = capsules
				}
			}
	}

}