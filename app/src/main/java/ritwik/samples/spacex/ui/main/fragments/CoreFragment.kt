package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.view.View

import androidx.databinding.ViewDataBinding

import androidx.lifecycle.Observer

import androidx.recyclerview.widget.RecyclerView

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.component.adapter.CoreAdapter

import ritwik.samples.spacex.component.other.NetworkProcessor

import ritwik.samples.spacex.model.Core

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

/**[androidx.fragment.app.Fragment] to showcase all the Cores used by SpaceX..
 * @author Ritwik Jamuar.*/
class CoreFragment : BaseFragment() {

    // Views.
    private lateinit var cores: RecyclerView

    // Adapters.
    private var adapter: CoreAdapter? = null

    // Listeners.
    private var listener: Listener? = null

    /*----------------------------------------- Observers ----------------------------------------*/

    /**[Observer] that observes the Network Response of fetching all [Core]s.*/
    private val allCoresResponseObserver = Observer<NetworkProcessor.Resource<List<Core>>> { resources ->
        listener?.getVM()?.onCoresResponse(resources)
    }

    /**[Observer] that observes the collection of [Core]s.*/
    private val allCoresObserver = Observer<List<Core>> { cores ->
        adapter?.replaceList(cores)
    }

    /*---------------------------------- BaseFragment Callbacks ----------------------------------*/

    override fun setListener(context: Context) {
        if (context is Listener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement Listener")
        }
    }

    override fun attachObservers() {
        listener?.getVM()?.getAllCoresLiveData()?.observe(viewLifecycleOwner, allCoresObserver)
    }

    override fun layoutRes(): Int = R.layout.fragment_core

    override fun isDataBinding(): Boolean = false

    override fun provideDataBinding(binding: ViewDataBinding) = Unit

    override fun initializeViews(view: View) {
        // Instantiate Adapter.
        adapter = CoreAdapter()

        // Instantiate RecyclerView.
        cores = view.findViewById(R.id.fragment_core_recycler_view_cores)

        // Set-up Adapter.
        cores.adapter = adapter

        getCores()
    }

    override fun initializeViews() = Unit

    override fun cleanUp() {
        cores.adapter = null
        adapter = null
    }

    override fun removeListener() {
        listener = null
    }

    /*-------------------------------------- Private Methods -------------------------------------*/

    /**Fetches the [List] of [Core].*/
    private fun getCores() {
        listener?.getVM()?.getCores()?.observe(viewLifecycleOwner, allCoresResponseObserver)
    }

    /*---------------------------------------- Interfaces ----------------------------------------*/

    /**Interface Listener for any [android.app.Activity] that uses this [androidx.fragment.app.Fragment].*/
    interface Listener {

        /**Provides the [androidx.lifecycle.ViewModel] of the attaching [android.app.Activity].
         * @return [androidx.lifecycle.ViewModel] of [ritwik.samples.spacex.ui.main.MainActivity]*/
        fun getVM() : MainViewModel

    }

}