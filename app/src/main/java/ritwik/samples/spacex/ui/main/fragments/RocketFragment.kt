package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.view.View

import androidx.databinding.ViewDataBinding

import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.model.Rocket

import ritwik.samples.spacex.component.adapter.RocketAdapter

import ritwik.samples.spacex.component.other.NetworkProcessor

import java.lang.RuntimeException

/**[BaseFragment] that shows the list of [Rocket]s.
 * @author Ritwik Jamuar.*/
class RocketFragment : BaseFragment() {

    // Views.
    private lateinit var rockets: RecyclerView

    // Adapters.
    private var adapter: RocketAdapter? = null

    // Layout Managers.
    private var layoutManager: LinearLayoutManager? = null

    // Listener.
    private var listener: MainFragmentListener? = null

    /*------------------------------------- Companion Object -------------------------------------*/

    companion object {

        /**Creates an instance of [RocketFragment].
         * @return New Instance of [RocketFragment].*/
        @JvmStatic
        fun create(): RocketFragment = RocketFragment()

    }

    /*-------------------------------------- View Listeners --------------------------------------*/

    /**Listener instance of [RocketAdapter.Listener].*/
    private val adapterListener = object : RocketAdapter.Listener {
        override fun onSpecificationClicked(rocket: Rocket) {
            // TODO: Open Details of Rocket.
        }
    }

    /*----------------------------------------- Observers ----------------------------------------*/

    /**[Observer] of [List] of [Rocket].*/
    private val allRocketsResponseObserver = Observer<NetworkProcessor.Resource<List<Rocket>>> { resource ->
        listener?.getVM()?.onRocketsResponse(resource)
    }

    /**[Observer] that observes changes in [List] of [Rocket].*/
    private val allRocketsObserver = Observer<List<Rocket>> { rockets ->
        adapter?.replaceList(rockets)
    }

    /*---------------------------------- BaseFragment Callbacks ----------------------------------*/

    override fun setListener(context: Context) {
        if (context is MainFragmentListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement Listener")
        }
    }

    override fun attachObservers() {
        listener?.getVM()?.getAllRocketsLiveData()?.observe(viewLifecycleOwner, allRocketsObserver)
    }

    override fun layoutRes(): Int = R.layout.fragment_rocket

    override fun isDataBinding(): Boolean = false

    override fun provideDataBinding(binding: ViewDataBinding) {}

    override fun initializeViews(view: View) {
        // Instantiate Adapter and Layout Manager.
        adapter = RocketAdapter(
            adapterListener,
            listener!!.getPicasso()
        )
        layoutManager = LinearLayoutManager(context)

        // Instantiate RecyclerView.
        rockets = view.findViewById(R.id.fragment_rocket_recycler_view_rockets)

        // Set-up Layout Manager and Adapter.
        rockets.layoutManager = layoutManager
        rockets.adapter = adapter

        getRockets()
    }

    override fun initializeViews() {}

    override fun cleanUp() {
        layoutManager = null
        adapter = null

        rockets.adapter = null
    }

    override fun removeListener() {
        listener = null
    }

    /*-------------------------------------- Private Methods -------------------------------------*/

    /**Fetches the [List] of [Rocket]s.*/
    private fun getRockets() {
        listener?.getVM()?.getRockets()?.observe(viewLifecycleOwner, allRocketsResponseObserver)
    }

}