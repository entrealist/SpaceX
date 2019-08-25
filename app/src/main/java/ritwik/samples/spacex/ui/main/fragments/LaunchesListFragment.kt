package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import androidx.lifecycle.Observer

import ritwik.samples.spacex.R

import ritwik.samples.spacex.application.database.LAUNCH_TYPE_PAST
import ritwik.samples.spacex.application.database.LAUNCH_TYPE_UPCOMING

import ritwik.samples.spacex.pojo.Launch

import ritwik.samples.spacex.printLog

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

/**[Fragment] to show the list of upcomingLaunches of SpaceX.
 * @author Ritwik Jamuar.*/
class LaunchesListFragment : Fragment () {
	private var launchType : Int = -1

	// Listener.
	private var listener : Listener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {
		const val TAG : String = "LaunchesListFragment"
		@JvmStatic
		fun newInstance ( type : Int ) =
			LaunchesListFragment ()
				.apply {
					launchType = type
					arguments = Bundle ()
				}
	}

	/*------------------------------------ Fragment Callbacks ------------------------------------*/

	override fun onCreateView (
		inflater : LayoutInflater,
		container : ViewGroup?,
		savedInstanceState : Bundle?
	) : View? {
		val view : View = inflater
			.inflate (
				R.layout.fragment_launches_list,
				container,
				false
			)
		initializeViews ( view )
		return view
	}

	override fun onResume () {
		super.onResume ()
		attachObservers ()
		listener!!.getVM ().getLaunches ( launchType )
	}

	override fun onAttach ( context : Context ) {
		super.onAttach ( context )
		if ( context is Listener ) {
			listener = context
		} else {
			throw RuntimeException ( "$context must implement Listener" )
		}
	}

	override fun onDetach () {
		super.onDetach ()
		listener = null
	}

	/*-------------------------------------- Private Methods -------------------------------------*/

	private fun initializeViews ( view : View ) {
		// TODO : Initialize the Views Here.
	}

	/**Attaches [Observer]s to this Fragment to receive any changes from Upcoming Launches or
	 * Past Launches.*/
	private fun attachObservers () {
		when ( launchType ) {
			LAUNCH_TYPE_UPCOMING -> {
				listener?.getVM ()?.repository?.upcomingLaunchesLiveData?.observe ( this, upcomingLaunchesObserver )
			}

			LAUNCH_TYPE_PAST -> {
				listener?.getVM ()?.repository?.pastLaunchesLiveData?.observe ( this, pastLaunchesObserver )
			}
		}
	}

	/*----------------------------------------- Observers ----------------------------------------*/

	private val upcomingLaunchesObserver = Observer < List < Launch > > {
		// Notify changes in the Upcoming Launches Fragment.
		printLog ( TAG, "Upcoming Launches Changed" )
		printLog ( TAG, it?.toString () )
	}

	private val pastLaunchesObserver = Observer < List < Launch > > {
		// Notify changes in the Past Launches Fragment.
		printLog ( TAG, "Past Launches Changed" )
		printLog ( TAG, it?.toString () )
	}

	/*---------------------------------------- Interfaces ----------------------------------------*/

	/**Interface for providing callback to [ritwik.samples.spacex.ui.main.MainActivity].*/
	interface Listener {

		/**Fetches the [MainViewModel] from [ritwik.samples.spacex.ui.main.MainActivity].
		 * @return Instance of [MainViewModel].*/
		fun getVM () : MainViewModel

	}
}