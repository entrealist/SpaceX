package ritwik.samples.spacex.ui.main.fragments.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**[FragmentStatePagerAdapter] to be used by [androidx.viewpager.widget.ViewPager] as it's adapter.
 * @author Ritwik Jamuar.*/
class VehicleAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    // Variables.
    private val fragmentList = ArrayList <Fragment> ()
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

    /**Adds the [androidx.fragment.app.Fragment] along with it's title in this adapter.
     * @param fragment [androidx.fragment.app.Fragment] to be added.
     * @param title [String] denoting title of the [Fragment].*/
    fun addFragment (fragment : Fragment, title : String ) {
        fragmentList.add ( fragment )
        fragmentTitleList.add ( title )
    }

}