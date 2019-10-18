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

import ritwik.samples.spacex.application.database.LAUNCH_TYPE_PAST
import ritwik.samples.spacex.application.database.LAUNCH_TYPE_UPCOMING

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.components.adapters.LaunchesOptionsAdapter

/**[Fragment] to showcase all the Upcoming and Past Launches conducted by SpaceX.
 * @author Ritwik Jamuar*/
class LaunchesFragment : BaseFragment () {

	// Views.
	private var tabLayout : TabLayout? = null
	private var viewPager : ViewPager? = null

	// Listeners.
	private var listener : Listener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {

		@JvmStatic
		fun create () = LaunchesFragment ()

	}

	/*---------------------------------- BaseFragment Callbacks ----------------------------------*/

	override fun initializeViews ( view : View ) {
		// Initialize Views
		tabLayout = view.findViewById ( R.id.fragment_launches_tab_layout )
		viewPager = view.findViewById ( R.id.fragment_launches_view_pager )

		// Initialize the ViewPager Adapter.
		val launchesOptionsAdapter = LaunchesOptionsAdapter ( childFragmentManager )

		// Add Instances of Fragments that have to be shown in the ViewPager.
		launchesOptionsAdapter.addFragment ( LaunchesListFragment.newInstance ( LAUNCH_TYPE_UPCOMING ), "Upcoming" )
		launchesOptionsAdapter.addFragment ( LaunchesListFragment.newInstance ( LAUNCH_TYPE_PAST ), "Past" )

		// Set the ViewPager Adapter to the ViewPager.
		viewPager?.adapter = launchesOptionsAdapter

		// Setup the Tabs with ViewPager
		tabLayout?.setupWithViewPager ( viewPager )
	}

	override fun getLayoutRes () : Int = R.layout.fragment_launches

	override fun setListener ( context : Context ) {
		if ( context is Listener ) {
			listener = context
		} else {
			throw RuntimeException ( "$context must implement Listener" )
		}
	}

	override fun cleanUp () {
		listener = null
		tabLayout = null
		viewPager = null
	}

	override fun tag () : String = LaunchesFragment::class.java.simpleName

	override fun isDataBinding () : Boolean = false

	override fun applyBinding (
		inflater : LayoutInflater,
		container : ViewGroup?,
		savedInstanceState : Bundle? )
		: View? = null

	/*---------------------------------------- Interfaces ----------------------------------------*/

	// TODO : Add Implementation to get the Fragment Manager from Activity.
	interface Listener {

		fun getFMFromActivity () : FragmentManager

	}

}