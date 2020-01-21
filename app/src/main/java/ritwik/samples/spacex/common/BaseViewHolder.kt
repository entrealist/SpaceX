package ritwik.samples.spacex.common

import android.view.View

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.extensions.LayoutContainer

/**[androidx.recyclerview.widget.RecyclerView.ViewHolder] that abstracts the common setup.
 * @author Ritwik Jamuar.*/
abstract class BaseViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer, LifecycleOwner {

    /**Marks the [Lifecycle] state of this [androidx.recyclerview.widget.RecyclerView.ViewHolder].*/
    private val lifecycleRegistry = getLifecycleRegistry()

    /*------------------------------------ Initializer Block -------------------------------------*/

    init {
        // State the Lifecycle of this ViewHolder to be created.
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
    }

    /*--------------------------------- LifecycleOwner Callbacks ---------------------------------*/

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    /*------------------------------------- Private Methods -------------------------------------*/

    /**Provides the [LifecycleRegistry].
     * @return Instance of [LifecycleRegistry].*/
    private fun getLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(this)

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**Marks the State of [BaseViewHolder] to be [Lifecycle.State.STARTED].
     * This tells that the LifecycleOwner of the [BaseViewHolder] is in Started State.*/
    fun markAttach () {
        lifecycleRegistry.markState ( Lifecycle.State.STARTED )
    }

    /**Marks the State of [BaseViewHolder] to be [Lifecycle.State.DESTROYED].
     * This tells that the LifecycleOwner of the [BaseViewHolder] is in Destroyed State.*/
    fun markDetach () {
        lifecycleRegistry.markState ( Lifecycle.State.DESTROYED )
    }

}