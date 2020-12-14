package ritwik.samples.spacex.ui.viewHolder

import android.view.View

import com.squareup.picasso.Picasso

import ritwik.samples.spacex.R

import ritwik.samples.spacex.data.ui.Rocket

import ritwik.samples.spacex.databinding.ItemRocketBinding

import sample.ritwik.common.ui.viewHolder.BaseViewHolder

/**
 * [BaseViewHolder] to render a [Rocket].
 *
 * @param binding Data Binding of this [BaseViewHolder].
 * @param picasso Instance of [Picasso] to facilitate loading of Images.
 * @param listener Lambda Expression as the Click Listener of this [BaseViewHolder].
 * @author Ritwik Jamuar
 */
class RocketViewHolder(
    binding: ItemRocketBinding,
    private val picasso: Picasso,
    private val listener: (Int) -> Unit
) : BaseViewHolder<ItemRocketBinding>(binding) {

    /*-------------------------------------- View Listeners --------------------------------------*/

    /**
     * [View.OnClickListener] to intercept click on the item.
     */
    private val rootClickListener = View.OnClickListener {
        val currentValue = binding.isExpanded ?: false
        binding.isExpanded = !currentValue
    }

    /**
     * [View.OnClickListener] to intercept the click on 'Rocket Specs'.
     */
    private val rocketSpecClickListener = View.OnClickListener {
        listener.invoke(adapterPosition)
    }

    /*--------------------------------- BaseViewHolder Callbacks ---------------------------------*/

    override fun initializeComponents() = with(binding) {
        rootView.setOnClickListener(rootClickListener)
        buttonRocketSpecs.setOnClickListener(rocketSpecClickListener)
    }

    override fun cleanUp() = with(binding) {
        rootView.setOnClickListener(null)
        buttonRocketSpecs.setOnClickListener(null)
    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Sets the [Rocket] in the [binding].
     *
     * @param rocketItem Instance of [Rocket] to be assigned into the [binding].
     */
    fun setRocketItem(rocketItem: Rocket) = with(binding) {
        rocket = rocketItem
        picasso
            .load(rocketItem.images[0])
            .placeholder(R.drawable.ic_space_x_logo)
            .error(R.drawable.ic_launcher_foreground)
            .resize(400, 400)
            .into(valueImageRocket)
    }

}
