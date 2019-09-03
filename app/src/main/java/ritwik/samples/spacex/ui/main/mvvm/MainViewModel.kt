package ritwik.samples.spacex.ui.main.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

import ritwik.samples.spacex.pojo.launches.Launch

import ritwik.samples.spacex.ui.main.MainActivity

import java.text.SimpleDateFormat

import java.util.Locale

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
	fun onLaunchClicked ( launch : Launch) {
		// TODO : Perform some action when a Launch is clicked in the UI.
	}

	/**Converts an UTC Date Time to Formatted Date Time for display in the UI.
	 * @param utcDate [String] containing UTC Date and Time.
	 * @return [String] containing formatted Date and Time.
	 * Refer below Link for more detail on SimpleDateFormat:
	 * https://www.journaldev.com/17899/java-simpledateformat-java-date-format */
	fun convertUTCDateTime ( utcDate : String? ) : String {
		// Define an Input Format of Date and Time.
		val inputFormat = SimpleDateFormat ( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH )

		// Define an Output Format of Date and Time.
		val outputFormat = SimpleDateFormat ( "dd MMM yyyy, hh:mm a", Locale.ENGLISH )

		// Parse the UTC Date and Time to get Date.
		val date = inputFormat.parse ( utcDate )

		// Format the Date to our own Format of Date and Time.
		return outputFormat.format ( date )
	}
}