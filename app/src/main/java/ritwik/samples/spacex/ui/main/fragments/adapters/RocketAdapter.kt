package ritwik.samples.spacex.ui.main.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import ritwik.samples.spacex.common.BaseSingleVHAdapter

import ritwik.samples.spacex.databinding.RecyclerItemRocketBinding

import ritwik.samples.spacex.pojo.rockets.Rocket

/**[androidx.recyclerview.widget.RecyclerView.Adapter] for handling the [List] of [Rocket]
 * @param listener Interface Object that receives the callback.
 * @author Ritwik Jamuar.*/
class RocketAdapter(
    private val listener: Listener
) : BaseSingleVHAdapter<Rocket, RocketViewHolder>() {

    /*----------------------------------- ViewHolder Listeners -----------------------------------*/

    /**Listener instance of [RocketViewHolder].*/
    private val viewHolderListener = object : RocketViewHolder.Listener {
        override fun onSpecificationClicked(position: Int) {
            listener.onSpecificationClicked(getList()[position])
        }
    }

    /*------------------------------ BaseSingleVHAdapter Callbacks -------------------------------*/

    override fun provideViewHolder(parent: ViewGroup): RocketViewHolder {
        // Instantiate the Data Binding.
        val binding = RecyclerItemRocketBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        // Instantiate the ViewHolder.
        return RocketViewHolder(binding.root, binding, viewHolderListener)
    }

    override fun onBind(holder: RocketViewHolder, position: Int) {
        // Pass the Rocket onto ViewHolder.
        holder.setRocketDetails(getList()[position])
    }

    /*---------------------------------------- Interfaces ----------------------------------------*/

    /**Interface to listen to the event of this [BaseSingleVHAdapter].*/
    interface Listener {

        /**Notifies the implementor about the click event of button 'Specification'.
         * @param rocket [Rocket] denoting the item in the [List] that has been clicked by the user.*/
        fun onSpecificationClicked(rocket: Rocket)

    }

}