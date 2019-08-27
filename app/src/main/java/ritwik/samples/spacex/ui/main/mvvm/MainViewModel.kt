package ritwik.samples.spacex.ui.main.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

import ritwik.samples.spacex.pojo.Launch

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

	/**On-Click Method for performing actions when a [Launch] Event from [List] of [Launch]es is
	 * selected:
	 * @param launch Instance of [Launch].*/
	fun onLaunchClicked ( launch : Launch ) {
		// TODO : Perform some action when a Launch is clicked in the UI.
	}
}