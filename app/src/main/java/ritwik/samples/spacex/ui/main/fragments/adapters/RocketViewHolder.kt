package ritwik.samples.spacex.ui.main.fragments.adapters

import android.view.View
import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseViewHolder

import ritwik.samples.spacex.databinding.RecyclerItemRocketBinding

import ritwik.samples.spacex.pojo.rockets.Rocket

/**[androidx.recyclerview.widget.RecyclerView.ViewHolder] for rendering [Rocket].
 * @param containerView [View] of this [androidx.recyclerview.widget.RecyclerView.ViewHolder].
 * @param binding Data Binding Reference of the layout of this [androidx.recyclerview.widget.RecyclerView.ViewHolder].
 * @param listener Interface object for the [Listener].
 * @author Ritwik Jamuar.*/
class RocketViewHolder(
    override val containerView: View,
    private val binding: RecyclerItemRocketBinding,
    private val listener: Listener
) : BaseViewHolder(containerView) {

    /*-------------------------------------- View Listeners --------------------------------------*/

    /**Click Listener of Whole Item.*/
    private val rootClickListener: View.OnClickListener = View.OnClickListener {
        val isExpanded = binding.expanded ?:false
        val drawable = if (isExpanded) {
            R.drawable.ic_arrow_drop_up_black_24dp
        } else {
            R.drawable.ic_arrow_drop_down_black_24dp
        }
        binding.recyclerItemRocketImageViewButtonDrop.setImageResource(drawable)
    }

    /**Click Listener of Rocket Specifications.*/
    private val specificationClickListener = View.OnClickListener {
        listener.onSpecificationClicked(adapterPosition)
    }

    /*------------------------------------- Initializer Block ------------------------------------*/

    init {
        // Set the Lifecycle Owner of the DataBinding to this.
        binding.lifecycleOwner = this

        // Set the Expanded to be false.
        binding.expanded = false

        // Set the Click Listeners.
        binding.recyclerItemRocketRoot.setOnClickListener(rootClickListener)
        binding.recyclerItemRocketImageViewButtonSpecification.setOnClickListener(
            specificationClickListener
        )
    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**Sets the [Rocket] to [RecyclerItemRocketBinding].
     * @param rocket Instance of [Rocket] which will be set.*/
    fun setRocketDetails(rocket: Rocket) {
        binding.rocket = rocket
    }

    /*---------------------------------------- Interfaces ----------------------------------------*/

    /**Interface to listen to the event of this [BaseViewHolder].*/
    interface Listener {

        /**Notifies the implementor about the click event of button 'Specification'.
         * @param position [Int] denoting the position in the [List] where user made the click.*/
        fun onSpecificationClicked(position: Int)

    }

}