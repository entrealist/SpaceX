package ritwik.samples.spacex.components.viewHolders

import android.view.View

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

import ritwik.samples.spacex.databinding.RecyclerItemCapsuleBinding

/**Data Binding [androidx.recyclerview.widget.RecyclerView.ViewHolder] of [CapsuleListViewHolder].
 * @author Ritwik Jamuar*/
class CapsuleListBindingViewHolder (
	override val containerView : View,
	val binding : RecyclerItemCapsuleBinding
) : CapsuleListViewHolder ( containerView ), LifecycleOwner {

	// LifeCycle Registry.
	private val lifecycleRegistry = LifecycleRegistry ( this )

	/*------------------------------------- Constructor Field ------------------------------------*/

	init {
		lifecycleRegistry.markState ( Lifecycle.State.INITIALIZED )
	}

	/*--------------------------------- LifecycleOwner Callbacks ---------------------------------*/

	override fun getLifecycle () : Lifecycle = lifecycleRegistry

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Marks the State of [CapsuleListViewHolder] to be [Lifecycle.State.STARTED].
	 * This tells that the LifecycleOwner of the [CapsuleListViewHolder] is in Started State.*/
	fun markAttach () {
		lifecycleRegistry.markState ( Lifecycle.State.STARTED )
	}

	/**Marks the State of [CapsuleListViewHolder] to be [Lifecycle.State.DESTROYED].
	 * This tells that the LifecycleOwner of the [CapsuleListViewHolder] is in Destroyed State.*/
	fun markDetach () {
		lifecycleRegistry.markState ( Lifecycle.State.DESTROYED )
	}

}