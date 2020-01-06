package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.View

import androidx.databinding.ViewDataBinding

import androidx.fragment.app.FragmentManager

import androidx.viewpager.widget.ViewPager

import com.google.android.material.tabs.TabLayout

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.ui.main.fragments.adapters.VehicleAdapter

/**[androidx.fragment.app.Fragment] to showcase all the types of Rockets used by SpaceX..
 * @author Ritwik Jamuar.*/
class VehicleFragment : BaseFragment() {

    // Views.
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null

    // Listeners.
    private var listener: Listener? = null

    /*------------------------------------- Companion Object -------------------------------------*/

    companion object {
        /**Factory method to create a new instance of [VehicleFragment].
         * @return A new instance of [VehicleFragment].*/
        @JvmStatic
        fun newInstance() =
            VehicleFragment()
                .apply {
                    arguments = Bundle()
                }
    }

    /*------------------------------------ Fragment Callbacks ------------------------------------*/

    override fun setListener(context: Context) {
        if (context is Listener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement Listener")
        }
    }

    override fun attachObservers() {}

    override fun layoutRes(): Int = R.layout.fragment_vehicle

    override fun isDataBinding(): Boolean = false

    override fun provideDataBinding(binding: ViewDataBinding) {}

    override fun initializeViews(view: View) {
        // Initialize Views
        tabLayout = view.findViewById(R.id.fragment_vehicle_tab_layout)
        viewPager = view.findViewById(R.id.fragment_vehicle_view_pager)

        // Initialize the ViewPager Adapter.
        val viewPagerAdapter = VehicleAdapter(childFragmentManager)

        // Add Instances of Fragments that have to be shown in the ViewPager.
        viewPagerAdapter.addFragment(RocketFragment.create(), "Rockets")

        // Set the ViewPager Adapter to the ViewPager.
        viewPager?.adapter = viewPagerAdapter

        // Setup the Tabs with ViewPager
        tabLayout?.setupWithViewPager(viewPager)
    }

    override fun initializeViews() {}

    override fun cleanUp() {
        viewPager?.adapter = null
        tabLayout = null
        viewPager = null
    }

    override fun removeListener() {
        listener = null
    }

    /*---------------------------------------- Interfaces ----------------------------------------*/

    /**Interface Listener for any [android.app.Activity] that uses this [androidx.fragment.app.Fragment].*/
    interface Listener {

        /**Gets the [FragmentManager] from [android.app.Activity].
         * @return Instance of [FragmentManager] from the parent [android.app.Activity].*/
        fun getFMFromActivity(): FragmentManager

    }

}