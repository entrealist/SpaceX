package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.View

import androidx.databinding.ViewDataBinding

import androidx.fragment.app.Fragment

import androidx.viewpager.widget.ViewPager

import com.google.android.material.tabs.TabLayout

import ritwik.samples.spacex.R

import ritwik.samples.spacex.application.database.LaunchType

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.component.adapter.LaunchesOptionsAdapter

/**[Fragment] to showcase all the Upcoming and Past Launches conducted by SpaceX.
 * @author Ritwik Jamuar*/
class LaunchesFragment : BaseFragment () {
	// Views.
	private lateinit var tabLayout : TabLayout
	private lateinit var viewPager : ViewPager

	// Listeners.
	private var listener : MainFragmentListener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {
		@JvmStatic
		fun newInstance () =
			LaunchesFragment ()
				.apply {
					arguments = Bundle ()
				}
	}

	/*---------------------------------- BaseFragment Callbacks ----------------------------------*/

	override fun setListener(context: Context) {
		if ( context is MainFragmentListener ) {
			listener = context
		} else {
			throw RuntimeException ( "$context must implement Listener" )
		}
	}

	override fun attachObservers() = Unit

	override fun layoutRes(): Int = R.layout.fragment_launches

	override fun isDataBinding(): Boolean = false

	override fun provideDataBinding(binding: ViewDataBinding) = Unit

	override fun initializeViews (view : View) {
		// Initialize Views
		tabLayout = view.findViewById ( R.id.fragment_launches_tab_layout )
		viewPager = view.findViewById ( R.id.fragment_launches_view_pager )

		// Set the ViewPager Adapter to the ViewPager.
		viewPager.adapter = provideViewPagerAdapter()

		// Setup the Tabs with ViewPager
		tabLayout.setupWithViewPager (viewPager)
	}

	override fun initializeViews() = Unit

	override fun cleanUp() = Unit

	override fun removeListener() {
		listener = null
	}

	/*------------------------------------- Private Methods --------------------------------------*/

	private fun provideViewPagerAdapter () =
		LaunchesOptionsAdapter(childFragmentManager)
			.apply {
				// Add Instances of Fragments that have to be shown in the ViewPager.
				this.addFragment (LaunchesListFragment.newInstance (LaunchType.UPCOMING), "Upcoming")
				this.addFragment (LaunchesListFragment.newInstance (LaunchType.PAST), "Past")
			}

}