package ritwik.samples.spacex.ui.adapter

import android.os.Bundle

import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter

import ritwik.samples.spacex.ui.fragment.LaunchesFragment

import ritwik.samples.spacex.utility.constant.LAUNCH_TYPE

/**
 * [FragmentStateAdapter] to render multiple [LaunchesFragment]s.
 *
 * @param fragment Instance of [Fragment] on which [LaunchesFragment] is to be rendered.
 * @author Ritwik Jamuar
 */
class LaunchesAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    /*---------------------------- FragmentStatePagerAdapter Callbacks ---------------------------*/

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = LaunchesFragment().apply {
        arguments = Bundle().apply {
            putInt(LAUNCH_TYPE, position)
        }
    }

}
