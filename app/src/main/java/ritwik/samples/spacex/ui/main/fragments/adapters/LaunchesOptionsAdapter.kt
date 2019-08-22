package ritwik.samples.spacex.ui.main.fragments.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

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

	/*-------------------------------------- Public Methods --------------------------------------*/

	fun addFragment ( fragment : Fragment, title : String ) {
		fragmentList.add ( fragment )
		fragmentTitleList.add ( title )
	}
}