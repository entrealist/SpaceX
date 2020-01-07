package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.view.View

import androidx.databinding.ViewDataBinding

import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.pojo.rockets.Rocket

import ritwik.samples.spacex.ui.main.fragments.adapters.RocketAdapter

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

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
    private var listener: Listener? = null

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
    private val rocketObserver = Observer<List<Rocket>> {
        adapter?.replaceList(it)
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
        listener?.getVM()?.repository?.allRocketsLiveData?.observe(this, rocketObserver)
    }

    override fun layoutRes(): Int = R.layout.fragment_rocket

    override fun isDataBinding(): Boolean = false

    override fun provideDataBinding(binding: ViewDataBinding) {}

    override fun initializeViews(view: View) {
        // Instantiate Adapter and Layout Manager.
        adapter = RocketAdapter(adapterListener, listener!!.getPicasso())
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
        listener?.getVM()?.getRockets()
    }

    /*---------------------------------------- Interfaces ----------------------------------------*/

    /**Interface Listener for any [android.app.Activity] that uses this [androidx.fragment.app.Fragment].*/
    interface Listener {

        /**Provides the [androidx.lifecycle.ViewModel] of the attaching [android.app.Activity].
         * @return [androidx.lifecycle.ViewModel] of [ritwik.samples.spacex.ui.main.MainActivity]*/
        fun getVM(): MainViewModel

        /**Provides [Picasso] from attaching [android.app.Activity].
         * @return Instance of [Picasso].*/
        fun getPicasso(): Picasso

    }

}