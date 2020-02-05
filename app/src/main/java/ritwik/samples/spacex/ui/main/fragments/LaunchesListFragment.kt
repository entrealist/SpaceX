package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.View

import androidx.databinding.ViewDataBinding

import androidx.fragment.app.Fragment

import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager

import ritwik.samples.spacex.R

import ritwik.samples.spacex.application.database.LaunchType

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.databinding.FragmentLaunchesListBinding

import ritwik.samples.spacex.pojo.launches.Launch

import ritwik.samples.spacex.component.adapter.LaunchListAdapter

import ritwik.samples.spacex.component.other.NetworkProcessor

/**[Fragment] to show the list of upcomingLaunches of SpaceX.
 * @author Ritwik Jamuar.*/
class LaunchesListFragment : BaseFragment () {

	// Adapters.
	private var adapter : LaunchListAdapter? = null

	// Bindings.
	private lateinit var binding : FragmentLaunchesListBinding

	// Variables.
	private lateinit var launchType : LaunchType

	// Listener.
	private var listener : MainFragmentListener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {

		@JvmStatic
		fun newInstance ( type : LaunchType ) =
			LaunchesListFragment ()
				.apply {
					launchType = type
					arguments = Bundle ()
				}

	}

	/*----------------------------------------- Observers ----------------------------------------*/

	/**[Observer] for observing changes in [List] of Upcoming [Launch]es.*/
	private val upcomingLaunchesResponseObserver = Observer<NetworkProcessor.Resource<List<Launch>>> { resources ->
		listener?.getVM()?.onLaunchesResponse(resources, launchType)
	}

	/**[Observer] for observing changes in [List] of Past [Launch]es.*/
	private val pastLaunchesResponseObserver = Observer<NetworkProcessor.Resource<List<Launch>>> { resource ->
		listener?.getVM()?.onLaunchesResponse(resource, launchType)
	}

	/**[Observer] that observes the collection of Upcoming [Launch]es.*/
	private val allUpComingLaunchesObserver = Observer<List<Launch>> { launches ->
		adapter?.replaceList(launches)
	}

	/**[Observer] that observes the collection of Past [Launch]es.*/
	private val allPastLaunchesObserver = Observer<List<Launch>> { launches ->
		adapter?.replaceList(launches)
	}

	/*---------------------------------- BaseFragment Callbacks ----------------------------------*/

	override fun setListener(context: Context) {
		if ( context is MainFragmentListener ) {
			listener = context
		} else {
			throw RuntimeException ( "$context must implement Listener" )
		}
	}

	override fun initializeViews ( view : View ) = Unit

	override fun initializeViews() {
		// Initialize Adapters.
		adapter = LaunchListAdapter(listener!!.getVM())

		// Set the Layout Manager for RecyclerView.
		binding.fragmentLaunchesListRecyclerViewLaunches.layoutManager = LinearLayoutManager ( context )

		// Set the Adapter to RecyclerView.
		binding.fragmentLaunchesListRecyclerViewLaunches.adapter = adapter

		getLaunches()
	}

	override fun attachObservers () {
		listener?.getVM()?.let { viewModel ->
			when(launchType) {
				LaunchType.UPCOMING -> viewModel.getAllUpComingLaunchesLiveData().observe(viewLifecycleOwner, allUpComingLaunchesObserver)
				LaunchType.PAST -> viewModel.getAllPastLaunchesLiveData().observe(viewLifecycleOwner, allPastLaunchesObserver)
			}
		}
	}

	override fun layoutRes(): Int = R.layout.fragment_launches_list

	override fun isDataBinding(): Boolean = true

	override fun provideDataBinding(binding: ViewDataBinding) {
		this.binding = binding as FragmentLaunchesListBinding
		this.binding.apply {
			this.isUpcoming = launchType == LaunchType.UPCOMING
		}
	}

	override fun cleanUp() {
		binding.fragmentLaunchesListRecyclerViewLaunches.adapter = null
		adapter = null
	}

	override fun removeListener() {
		listener = null
	}

	/*-------------------------------------- Private Methods -------------------------------------*/

	private fun getLaunches() {
		listener?.getVM()?.getLaunches(launchType)?.observe(
			viewLifecycleOwner,
			when(launchType) {
				LaunchType.UPCOMING -> upcomingLaunchesResponseObserver
				LaunchType.PAST -> pastLaunchesResponseObserver
			}
		)
	}

}