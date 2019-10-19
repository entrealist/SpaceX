package ritwik.samples.spacex.ui.main.mvvm

import android.widget.ImageView

import androidx.databinding.BindingAdapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import ritwik.samples.spacex.R

import ritwik.samples.spacex.application.App

import ritwik.samples.spacex.application.database.LAUNCH_TYPE_PAST
import ritwik.samples.spacex.application.database.LAUNCH_TYPE_UPCOMING

import ritwik.samples.spacex.pojo.launches.Launch
import ritwik.samples.spacex.pojo.rockets.Rocket

import ritwik.samples.spacex.utilities.API_DATE_FORMAT
import ritwik.samples.spacex.utilities.DESIRED_DATE_FORMAT
import ritwik.samples.spacex.utilities.dateFormatter

const val BINDING_IMAGE_URL = "imageURL"

/**ViewModel of [ritwik.samples.spacex.ui.main.MainActivity].
 * @author Ritwik Jamuar.*/
class MainViewModel (
	val repository : MainRepository
) : ViewModel () {

	// LiveData.
	val upcomingLaunchesLiveData = MutableLiveData < List < Launch > > ()
	val pastLaunchesLiveData = MutableLiveData < List < Launch > > ()
	val allRocketsLiveData = MutableLiveData < List < Rocket > > ()
	val noInternetLiveData = MutableLiveData < Boolean > ()
	val errorLiveData = MutableLiveData < String > ()

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {

		/**Creates/Gets an instance of [MainViewModel].
		 * @param repository Repository of [ritwik.samples.spacex.ui.main.MainActivity].
		 * @return Instance of [MainViewModel] : ViewModel of [ritwik.samples.spacex.ui.main.MainActivity].*/
		fun create ( repository : MainRepository ) : MainViewModel = MainViewModel ( repository )

		@BindingAdapter( BINDING_IMAGE_URL )
		@JvmStatic
		fun setImageURL ( imageView : ImageView, url : String? ) {
			url?.let {
				App
					.instance
					.getAppComponent ()
					.getPicasso ()
					.load ( url )
					.placeholder ( R.drawable.ic_launcher_background )
					.error ( R.drawable.ic_launcher_background )
					.into ( imageView )
			}
		}

	}

	/*------------------------------------ ViewModel Callbacks -----------------------------------*/

	override fun onCleared () {
		super.onCleared ()
		repository.cleanUp ()
	}

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Gets the Launches of given type.
	 * Notifies the Observer that either [upcomingLaunchesLiveData] or [pastLaunchesLiveData] is
	 * changed.
	 * @param type Specify the type of Launches to fetch. It can be either [LAUNCH_TYPE_UPCOMING]
	 * or [LAUNCH_TYPE_PAST]*/
	fun getLaunches ( type : Int ) {
		when ( type ) {
			LAUNCH_TYPE_UPCOMING -> repository.getLaunches ( type, upcomingLaunchesLiveData, noInternetLiveData, errorLiveData )
			LAUNCH_TYPE_PAST -> repository.getLaunches ( type, pastLaunchesLiveData, noInternetLiveData, errorLiveData )
		}
	}

	/**Gets all the Rockets used by SpaceX.
	 * Notifies the [androidx.lifecycle.Observer] of [allRocketsLiveData] about
	 * change in the List of [ritwik.samples.spacex.pojo.rockets.Rocket]*/
	fun getRockets () {
		repository.getAllRockets ( allRocketsLiveData, noInternetLiveData, errorLiveData )
	}

	/**On-Click Method for performing actions when a [Launch] Event from [List] of [Launch]es is
	 * selected:
	 * @param launch Instance of [Launch].*/
	fun onLaunchClicked ( launch : Launch ) {
		// TODO : Perform some action when a Launch is clicked in the UI.
	}

	fun onRocketSpecsClicked (rocket : Rocket ) {
		// TODO : Perform some action when a Launch is clicked in the UI.
	}

	/**Converts an UTC Date Time to Formatted Date Time for display in the UI.
	 * @param utcDate [String] containing UTC Date and Time.
	 * @return [String] containing formatted Date and Time.
	 * Refer below Link for more detail on SimpleDateFormat:
	 * https://www.journaldev.com/17899/java-simpledateformat-java-date-format */
	fun convertDateTime ( utcDate : String? ) : String {
		if ( utcDate == null ) return ""
		return dateFormatter ( utcDate, API_DATE_FORMAT, DESIRED_DATE_FORMAT )
	}

}