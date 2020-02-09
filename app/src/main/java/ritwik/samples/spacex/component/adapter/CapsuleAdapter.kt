package ritwik.samples.spacex.component.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import ritwik.samples.spacex.common.BaseSingleVHAdapter

import ritwik.samples.spacex.component.viewHolder.CapsuleViewHolder

import ritwik.samples.spacex.databinding.RecyclerItemCapsuleBinding

import ritwik.samples.spacex.model.Capsule

/**[androidx.recyclerview.widget.RecyclerView.Adapter] for handling the [List] of [Capsule].
 * @param listener Interface Object that receives the callback.
 * @author Ritwik Jamuar.*/
class CapsuleAdapter(
    private val listener: Listener
) : BaseSingleVHAdapter<Capsule, CapsuleViewHolder>() {

    /*----------------------------------- ViewHolder Listeners -----------------------------------*/

    /**[androidx.recyclerview.widget.RecyclerView.ViewHolder]'s Listener interface object.*/
    private val viewHolderListener = object: CapsuleViewHolder.Listener {
        override fun onCapsuleClicked(position: Int) {

            // Notify the implementor that user has clicked a Capsule.
            listener.onCapsuleClicked(getList()[position])

        }
    }

    /*------------------------------ BaseSingleVHAdapter Callbacks -------------------------------*/

    override fun provideViewHolder(parent: ViewGroup): CapsuleViewHolder {
        // Instantiate the Data Binding.
        val binding = RecyclerItemCapsuleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        // Instantiate the ViewHolder.
        return CapsuleViewHolder(
            binding.root,
            binding,
            viewHolderListener
        )
    }

    override fun onBind(holder: CapsuleViewHolder, position: Int) {
        // Pass the Capsule onto ViewHolder.
        holder.setCapsule(getList()[position])
    }

    /*---------------------------------------- Interfaces ----------------------------------------*/

    /**Interface to listen to the event of this [BaseSingleVHAdapter].*/
    interface Listener {

        /**Notifies the implementor about the click event of button 'Specification'.
         * @param capsule [Capsule] denoting the item in the [List] that has been clicked by the user.*/
        fun onCapsuleClicked(capsule: Capsule)

    }

}