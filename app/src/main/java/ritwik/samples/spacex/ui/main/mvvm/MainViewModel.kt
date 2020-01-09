package ritwik.samples.spacex.ui.main.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

import ritwik.samples.spacex.convertUTCDateTime

import ritwik.samples.spacex.pojo.launches.Launch

import ritwik.samples.spacex.ui.main.MainActivity

/**ViewModel of [MainActivity].
 * @author Ritwik Jamuar.*/
class MainViewModel (
	val repository : MainRepository
) : ViewModel () {
	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {
		/**Creates/Gets an instance of [MainViewModel].
		 * @param activity Instance of [MainActivity] : View of the [MainViewModel].
		 * @param factory Instance of [MainViewModelFactory] : Factory Provider of [MainViewModel].
		 * @return Instance of [MainViewModel] : ViewModel of [MainActivity].*/
		fun create ( activity : MainActivity, factory : MainViewModelFactory ) : MainViewModel {
			return ViewModelProviders.of ( activity, factory ).get ( MainViewModel::class.java )
		}
	}

	/*------------------------------------ ViewModel Callbacks -----------------------------------*/

	override fun onCleared () {
		super.onCleared ()
		repository.completableJob.cancel ()
	}

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Gets the Launches of given type.
	 * @param type Specify the type of Launches to fetch. It can be either LAUNCH_TYPE_UPCOMING
	 * or LAUNCH_TYPE_PAST.
	 * Notifies the Observer that either [MainRepository.upcomingLaunchesLiveData] or
	 * [MainRepository.pastLaunchesLiveData] is changed.*/
	fun getLaunches ( type : Int ) {
		repository.getLaunches ( type )
	}

	/**Gets all the Rockets used by SpaceX.
	 * Notifies the [androidx.lifecycle.Observer] of [MainRepository.allRocketsLiveData] about
	 * change in the List of [ritwik.samples.spacex.pojo.rockets.Rocket]*/
	fun getRockets () {
		repository.getAllRockets ()
	}

	/**Gets all the Capsules used by SpaceX.
	 * Notifies the [androidx.lifecycle.Observer] of [MainRepository.allCapsulesLiveData] about
	 * change in the List of [ritwik.samples.spacex.pojo.capsules.Capsule]*/
	fun getCapsules() {
		repository.getAllCapsules()
	}

	/**On-Click Method for performing actions when a [Launch] Event from [List] of [Launch]es is
	 * selected:
	 * @param launch Instance of [Launch].*/
	fun onLaunchClicked ( launch : Launch) {
		// TODO : Perform some action when a Launch is clicked in the UI.
	}

	/**Gets the Date Time.
	 * @param utcDate [String] containing UTC Date and Time.
	 * @return [String] containing formatted Date and Time.*/
	fun getDateTime ( utcDate : String? ) : String = convertUTCDateTime(utcDate)

}