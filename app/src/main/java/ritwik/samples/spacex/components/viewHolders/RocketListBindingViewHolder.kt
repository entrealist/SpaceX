package ritwik.samples.spacex.components.viewHolders

import android.view.View

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

import ritwik.samples.spacex.databinding.RecyclerItemRocketBinding

/**Data Binding [androidx.recyclerview.widget.RecyclerView.ViewHolder] of [RocketListViewHolder].
 * @author Ritwik Jamuar*/
class RocketListBindingViewHolder (
	override val containerView : View,
	val binding : RecyclerItemRocketBinding
) : RocketListViewHolder ( containerView ), LifecycleOwner {

	// LifeCycle Registry.
	private val lifecycleRegistry = LifecycleRegistry ( this )

	/*------------------------------------- Constructor Field ------------------------------------*/

	init {
		lifecycleRegistry.markState ( Lifecycle.State.INITIALIZED )
	}

	/*--------------------------------- LifecycleOwner Callbacks ---------------------------------*/

	override fun getLifecycle () : Lifecycle = lifecycleRegistry

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Marks the State of [RocketListViewHolder] to be [Lifecycle.State.STARTED].
	 * This tells that the LifecycleOwner of the [RocketListViewHolder] is in Started State.*/
	fun markAttach () {
		lifecycleRegistry.markState ( Lifecycle.State.STARTED )
	}

	/**Marks the State of [RocketListViewHolder] to be [Lifecycle.State.DESTROYED].
	 * This tells that the LifecycleOwner of the [RocketListViewHolder] is in Destroyed State.*/
	fun markDetach () {
		lifecycleRegistry.markState ( Lifecycle.State.DESTROYED )
	}

}