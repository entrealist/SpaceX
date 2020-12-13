package ritwik.samples.spacex.ui.adapter

import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter

import ritwik.samples.spacex.ui.fragment.CapsulesFragment
import ritwik.samples.spacex.ui.fragment.RocketsFragment

/**
 * [FragmentStateAdapter] to render [RocketsFragment] and [CapsulesFragment].
 *
 * @param fragment Instance of [Fragment] on which [Fragment]s is to be rendered.
 * @author Ritwik Jamuar
 */
class VehiclesAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    /*---------------------------- FragmentStatePagerAdapter Callbacks ---------------------------*/

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when(position) {
        0 -> RocketsFragment()
        1 -> CapsulesFragment()
        else -> RocketsFragment()
    }

}
