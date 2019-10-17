package ritwik.samples.spacex.components.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**[FragmentStatePagerAdapter] to be used as an Adapter of ViewPager.
 * @author Ritwik Jamuar.*/
class LaunchesOptionsAdapter ( supportFragmentManager : FragmentManager )
	: FragmentStatePagerAdapter ( supportFragmentManager ) {

	// Variables.
	private val fragmentList = ArrayList < Fragment > ()
	private val fragmentTitleList = ArrayList < String > ()

	/*---------------------------- FragmentStatePagerAdapter Callbacks ---------------------------*/

	override fun getItem ( position : Int ) : Fragment {
		return fragmentList [ position ]
	}

	override fun getCount () : Int {
		return fragmentList.size
	}

	override fun getPageTitle ( position : Int ) : CharSequence? {
		return fragmentTitleList [ position ]
	}

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Adds a Fragment in the adapter.
	 * @param fragment [Fragment] to be added.
	 * @param title Title of the [Fragment].*/
	fun addFragment ( fragment : Fragment, title : String ) {
		fragmentList.add ( fragment )
		fragmentTitleList.add ( title )
	}

}