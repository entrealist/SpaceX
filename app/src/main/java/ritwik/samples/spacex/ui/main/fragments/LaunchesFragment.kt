package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import androidx.viewpager.widget.ViewPager

import com.google.android.material.tabs.TabLayout

import ritwik.samples.spacex.R

import ritwik.samples.spacex.ui.main.fragments.adapters.LaunchesOptionsAdapter

/**[Fragment] to showcase all the rocket launches of SpaceX.
 * @author Ritwik Jamuar*/
class LaunchesFragment : Fragment() {
	// Views.
	private var tabLayout : TabLayout? = null
	private var viewPager : ViewPager? = null

	// Listeners.
	private var listener : Listener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {
		@JvmStatic
		fun newInstance () =
			LaunchesFragment ()
				.apply {
					arguments = Bundle ()
				}
	}

	/*------------------------------------ Fragment Callbacks ------------------------------------*/

	override fun onCreateView (
		inflater : LayoutInflater,
		container : ViewGroup?,
		savedInstanceState : Bundle?
	) : View? {
		val view : View = inflater.inflate ( R.layout.fragment_launches, container, false )
		initializeViews ( view )
		return view
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

	/*------------------------------------- Private Methods --------------------------------------*/

	private fun initializeViews ( view : View ) {
		// Initialize Views
		tabLayout = view.findViewById ( R.id.fragment_launches_tab_layout )
		viewPager = view.findViewById ( R.id.fragment_launches_view_pager )

		// Initialize the ViewPager Adapter.
		val launchesOptionsAdapter = LaunchesOptionsAdapter ( listener!!.getFMFromActivity () )

		// Add Instances of Fragments that have to be shown in the ViewPager.
		launchesOptionsAdapter.addFragment ( LaunchesListFragment (), "Upcoming" )
		launchesOptionsAdapter.addFragment ( LaunchesListFragment (), "Past" )

		// Set the ViewPager Adapter to the ViewPager.
		viewPager?.adapter = launchesOptionsAdapter

		// Setup the Tabs with ViewPager
		tabLayout?.setupWithViewPager ( viewPager )
	}

	/*---------------------------------------- Interfaces ----------------------------------------*/

	// TODO : Add Implementation to get the Fragment Manager from Activity.
	interface Listener {
		fun getFMFromActivity () : FragmentManager
	}
}