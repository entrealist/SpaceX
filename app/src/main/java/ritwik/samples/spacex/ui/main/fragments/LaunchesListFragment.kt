package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment

import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import ritwik.samples.spacex.R

import ritwik.samples.spacex.application.database.LAUNCH_TYPE_PAST
import ritwik.samples.spacex.application.database.LAUNCH_TYPE_UPCOMING

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.databinding.FragmentLaunchesListBinding

import ritwik.samples.spacex.pojo.launches.Launch

import ritwik.samples.spacex.printLog

import ritwik.samples.spacex.components.adapters.LaunchListAdapter

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

import java.util.*

import kotlin.Comparator

/**[Fragment] to show the list of upcomingLaunches of SpaceX.
 * @author Ritwik Jamuar.*/
class LaunchesListFragment : BaseFragment () {

	// Views.
	private var launchRecycler : RecyclerView? = null

	// Adapters.
	private var launchRecyclerAdapter : LaunchListAdapter? = null

	// Bindings.
	private lateinit var binding : FragmentLaunchesListBinding

	// Variables.
	private var launchType : Int = -1

	// Listener.
	private var listener : Listener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {

		@JvmStatic
		fun newInstance ( type : Int ) =
			LaunchesListFragment ()
				.apply {
					launchType = type
					arguments = Bundle ()
				}

	}

	/*---------------------------------- BaseFragment Callbacks ----------------------------------*/

	override fun initializeViews ( view : View ) {
		initializeRecyclerView ( view )
		applyBindingData ()
		attachObservers ()
		getLaunches ()
	}

	override fun getLayoutRes () : Int = R.layout.fragment_launches_list

	override fun setListener ( context : Context ) {
		if ( context is Listener ) {
			listener = context
		} else {
			throw RuntimeException ( "$context must implement Listener" )
		}
	}

	override fun cleanUp () {
		listener = null
		launchRecycler = null
		launchRecyclerAdapter = null
	}

	override fun tag () : String = LaunchesListFragment::class.java.simpleName

	override fun isDataBinding () : Boolean = true

	override fun applyBinding (
		inflater : LayoutInflater,
		container : ViewGroup?,
		savedInstanceState : Bundle?
	) : View {
		binding = DataBindingUtil
			.inflate (
				inflater,
				R.layout.fragment_launches_list,
				container,
				false
			)
		binding.lifecycleOwner = viewLifecycleOwner
		return binding.root
	}

	/*-------------------------------------- Private Methods -------------------------------------*/

	/**Set-Up the [RecyclerView].*/
	private fun initializeRecyclerView ( view : View ) {
		// Initialize Views.
		launchRecycler = view.findViewById ( R.id.fragment_launches_list_recycler_view_launches )

		// Initialize Adapters.
		launchRecyclerAdapter = LaunchListAdapter ( listener!!.getVM () )

		// Set the Layout Manager for RecyclerView.
		launchRecycler?.layoutManager = LinearLayoutManager ( context )

		// Set the Adapter to RecyclerView.
		launchRecycler?.adapter = launchRecyclerAdapter
	}

	/**Applies the DataBinding of this fragment.
	 * In Layman Terms, setting the value of Variable Used under <data> tag to set the value from
	 * here.*/
	private fun applyBindingData () {
		binding.apply {
			binding.isUpcoming = launchType == LAUNCH_TYPE_UPCOMING
		}
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

	private fun getLaunches () {
		listener?.getVM ()?.getLaunches ( launchType )
	}

	/*----------------------------------------- Observers ----------------------------------------*/

	/**[Observer] for observing changes in [List] of Upcoming [Launch]es.*/
	private val upcomingLaunchesObserver = Observer < List <Launch> > {
		// Notify changes in the Upcoming Launches Fragment.
		printLog ( tag, "Upcoming Launches Changed" )
		/*printLog ( TAG, it?.toString () )*/

		// Add the List of Upcoming Launches to the Adapter.
		launchRecyclerAdapter?.replaceLaunchesList ( it )
	}

	/**[Observer] for observing changes in [List] of Past [Launch]es.*/
	private val pastLaunchesObserver = Observer < List <Launch> > {
		// Notify changes in the Past Launches Fragment.
		printLog ( tag, "Past Launches Changed" )
		/*printLog ( TAG, it?.toString () )*/

		// Sort the past launches in Descending Order.
		Collections.sort ( it, descendingLaunchesComparator )

		// Add the List of Past Launches to the Adapter.
		launchRecyclerAdapter?.replaceLaunchesList ( it )
	}

	/**[Comparator] for Comparing two [Launch]es and put them in descending order.*/
	private val descendingLaunchesComparator = Comparator <Launch> {
		launch1 : Launch, launch2 : Launch ->
		when {
			launch1.flightNumber!! == launch2.flightNumber!! -> 0
			launch1.flightNumber > launch2.flightNumber -> -1
			launch1.flightNumber < launch2.flightNumber -> 1
			else -> 0
		}
	}

	/*---------------------------------------- Interfaces ----------------------------------------*/

	/**Interface for providing callback to [ritwik.samples.spacex.ui.main.MainActivity].*/
	interface Listener {

		/**Fetches the [MainViewModel] from [ritwik.samples.spacex.ui.main.MainActivity].
		 * @return Instance of [MainViewModel].*/
		fun getVM () : MainViewModel

	}
}