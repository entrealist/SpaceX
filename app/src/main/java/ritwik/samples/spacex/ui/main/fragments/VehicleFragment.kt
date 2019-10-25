package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.viewpager.widget.ViewPager

import com.google.android.material.tabs.TabLayout

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.components.adapters.ViewPagerFragmentsAdapter

/**[androidx.fragment.app.Fragment] to showcase all the types of Rockets used by SpaceX..
 * @author Ritwik Jamuar.*/
class VehicleFragment : BaseFragment () {

	// Views.
	private var tabLayout : TabLayout? = null
	private var viewPager : ViewPager? = null

	// Listeners.
	private var listener : Listener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {

		/**Factory method to create a new instance of [VehicleFragment].
		 * @return A new instance of [VehicleFragment].*/
		@JvmStatic
		fun create () = VehicleFragment ()

	}

	/*---------------------------------- BaseFragment Callbacks ----------------------------------*/

	override fun getLayoutRes () : Int = R.layout.fragment_vehicle

	override fun initializeViews ( view : View ) {
		initializeViewPagerAndAdapter ( view )
	}

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

	override fun tag () : String = VehicleFragment::class.java.simpleName

	override fun isDataBinding () : Boolean = false

	override fun applyBinding (
		inflater : LayoutInflater,
		container : ViewGroup?,
		savedInstanceState : Bundle? )
		: View? = null

	/*-------------------------------------- Private Methods -------------------------------------*/

	private fun initializeViewPagerAndAdapter ( view : View ) {
		// Initialize Views
		tabLayout = view.findViewById ( R.id.fragment_vehicle_tab_layout )
		viewPager = view.findViewById ( R.id.fragment_vehicle_view_pager )

		// Initialize the ViewPager Adapter.
		val viewPagerFragmentsAdapter = ViewPagerFragmentsAdapter ( childFragmentManager )

		// Add Instances of Fragments that have to be shown in the ViewPager.
		viewPagerFragmentsAdapter.addFragment ( RocketListFragment.create (), "Rockets" )
		viewPagerFragmentsAdapter.addFragment ( CapsuleListFragment.create (), "Capsules" )

		// Set the ViewPager Adapter to the ViewPager.
		viewPager?.adapter = viewPagerFragmentsAdapter

		// Setup the Tabs with ViewPager.
		tabLayout?.setupWithViewPager ( viewPager )
	}

	/*---------------------------------------- Interfaces ----------------------------------------*/

	/**Interface that acts as a Listener for [VehicleFragment] to whoever implements it.*/
	interface Listener : MainFragmentListener

}