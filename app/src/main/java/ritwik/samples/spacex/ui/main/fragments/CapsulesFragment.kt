package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.view.View

import androidx.databinding.ViewDataBinding

import androidx.lifecycle.Observer

import androidx.recyclerview.widget.RecyclerView

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.component.adapter.CapsuleAdapter

import ritwik.samples.spacex.component.other.NetworkProcessor

import ritwik.samples.spacex.pojo.capsules.Capsule

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

import java.lang.RuntimeException

/**[BaseFragment] that shows the list of [Capsule]s.
 * @author Ritwik Jamuar.*/
class CapsulesFragment : BaseFragment() {

    // Views.
    private lateinit var capsules: RecyclerView

    // Adapters.
    private var adapter: CapsuleAdapter? = null

    // Listeners.
    private var listener: Listener? = null

    /*------------------------------------- Companion Object -------------------------------------*/

    companion object {

        /**Creates a new instance of [CapsulesFragment].
         * @return New Instance of [CapsulesFragment].*/
        @JvmStatic
        fun create() = CapsulesFragment()

    }

    /*----------------------------------------- Observers ----------------------------------------*/

    /**[Observer] of [List] of [Capsule].*/
    private val allCapsulesResponseObserver = Observer<NetworkProcessor.Resource<List<Capsule>>> { resources ->
        listener?.getVM()?.onCapsulesResponse(resources)
    }

    /**[Observer] that observes changes in [List] of [Capsule].*/
    private val allCapsulesObserver = Observer<List<Capsule>> { capsules ->
        adapter?.replaceList(capsules)
    }

    /*-------------------------------------- View Listeners --------------------------------------*/

    /**Listener Object of [CapsuleAdapter].*/
    private val adapterListener = object : CapsuleAdapter.Listener {
        override fun onCapsuleClicked(capsule: Capsule) {
            // Notify the implementing activity to navigate to fragment that shows Capsule details.
            listener?.navigateToCapsuleDetail(capsule)
        }
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
        listener?.getVM()?.getAllCapsulesLiveData()?.observe(viewLifecycleOwner, allCapsulesObserver)
    }

    override fun layoutRes(): Int = R.layout.fragment_capsules

    override fun isDataBinding(): Boolean = false

    override fun provideDataBinding(binding: ViewDataBinding) = Unit

    override fun initializeViews(view: View) {
        // Instantiate Adapter.
        adapter = CapsuleAdapter(adapterListener)

        // Instantiate RecyclerView.
        capsules = view.findViewById(R.id.fragment_capsules_recycler_view_capsules)

        // Set-up Adapter.
        capsules.adapter = adapter

        getCapsules()
    }

    override fun initializeViews() = Unit

    override fun cleanUp() {
        capsules.adapter = null
        adapter = null
    }

    override fun removeListener() {
        listener = null
    }

    /*-------------------------------------- Private Methods -------------------------------------*/

    /**Fetches the [List] of [Capsule].*/
    private fun getCapsules() {
        listener?.getVM()?.getCapsules()?.observe(viewLifecycleOwner, allCapsulesResponseObserver)
    }

    /*---------------------------------------- Interfaces ----------------------------------------*/

    /**Interface Listener for any [android.app.Activity] that uses this [androidx.fragment.app.Fragment].*/
    interface Listener {

        /**Provides the [androidx.lifecycle.ViewModel] of the attaching [android.app.Activity].
         * @return [androidx.lifecycle.ViewModel] of [ritwik.samples.spacex.ui.main.MainActivity]*/
        fun getVM() : MainViewModel

        /**Tells the implementing [android.app.Activity] to navigate to details of [Capsule].
         * @param capsule Instance of [Capsule] whose details has to be shown.*/
        fun navigateToCapsuleDetail(capsule: Capsule)

    }

}