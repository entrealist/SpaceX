package ritwik.samples.spacex.component.viewHolder

import android.view.View

import ritwik.samples.spacex.common.BaseViewHolder

import ritwik.samples.spacex.databinding.RecyclerItemCapsuleBinding

import ritwik.samples.spacex.model.Capsule

/**[androidx.recyclerview.widget.RecyclerView.ViewHolder] for rendering [Capsule]s.
 * @param containerView [View] of this [androidx.recyclerview.widget.RecyclerView.ViewHolder].
 * @param binding Data Binding Reference of the layout of this [androidx.recyclerview.widget.RecyclerView.ViewHolder].
 * @param listener Interface object for the [Listener].
 * @author Ritwik Jamuar.*/
class CapsuleViewHolder(
    override val containerView: View,
    private val binding: RecyclerItemCapsuleBinding,
    private val listener: Listener
) : BaseViewHolder(containerView) {

    /*-------------------------------------- View Listeners --------------------------------------*/

    /**[View.OnClickListener] for Root Layout.*/
    private val rootClickListener = View.OnClickListener {

        // Notify the implementor that user has clicked a Capsule.
        listener.onCapsuleClicked(adapterPosition)

    }

    /*------------------------------------- Initializer Block ------------------------------------*/

    init {

        // Set the Lifecycle Owner of the DataBinding to this.
        binding.lifecycleOwner = this

        // Set the Click Listeners.
        binding.recyclerItemCapsuleRoot.setOnClickListener(rootClickListener)

    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**Sets the [Capsule] to [RecyclerItemCapsuleBinding].
     * @param capsule Instance of [Capsule] which will be set.*/
    fun setCapsule(capsule: Capsule) {
        binding.capsule = capsule
    }

    /*---------------------------------------- Interfaces ----------------------------------------*/

    /**Interface to listen to the event of this [BaseViewHolder].*/
    interface Listener {

        /**Notifies the implementor about the click event of this item 'Capsule'.
         * @param position [Int] denoting the position in the [List] where user made the click.*/
        fun onCapsuleClicked(position: Int)

    }

}