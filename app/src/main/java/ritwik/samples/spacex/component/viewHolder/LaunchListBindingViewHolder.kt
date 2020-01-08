package ritwik.samples.spacex.component.viewHolder

import android.view.View

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

import ritwik.samples.spacex.databinding.RecyclerItemLaunchBinding

/**Data Binding [androidx.recyclerview.widget.RecyclerView.ViewHolder] of [LaunchListViewHolder].
 * @author Ritwik Jamuar*/
class LaunchListBindingViewHolder (
	override val containerView : View,
	val binding : RecyclerItemLaunchBinding
) : LaunchListViewHolder( containerView ), LifecycleOwner {
	// LifeCycle Registry.
	private val lifecycleRegistry = LifecycleRegistry ( this )

	/*------------------------------------- Constructor Field ------------------------------------*/

	init {
		lifecycleRegistry.markState ( Lifecycle.State.INITIALIZED )
	}

	/*--------------------------------- LifecycleOwner Callbacks ---------------------------------*/

	override fun getLifecycle () : Lifecycle {
		return lifecycleRegistry
	}

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Marks the State of [LaunchListViewHolder] to be [Lifecycle.State.STARTED].
	 * This tells that the LifecycleOwner of the [LaunchListViewHolder] is in Started State.*/
	fun markAttach () {
		lifecycleRegistry.markState ( Lifecycle.State.STARTED )
	}

	/**Marks the State of [LaunchListViewHolder] to be [Lifecycle.State.DESTROYED].
	 * This tells that the LifecycleOwner of the [LaunchListViewHolder] is in Destroyed State.*/
	fun markDetach () {
		lifecycleRegistry.markState ( Lifecycle.State.DESTROYED )
	}
}