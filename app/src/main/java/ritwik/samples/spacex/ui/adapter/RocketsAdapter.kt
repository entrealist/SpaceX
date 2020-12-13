package ritwik.samples.spacex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import com.squareup.picasso.Picasso

import ritwik.samples.spacex.data.ui.Rocket

import ritwik.samples.spacex.databinding.ItemRocketBinding

import ritwik.samples.spacex.ui.viewHolder.RocketViewHolder

import sample.ritwik.common.ui.adapter.BaseSingleVHAdapter

/**
 * [BaseSingleVHAdapter] to render a collection of [Rocket] using [RocketViewHolder].
 *
 * @param picasso Instance of [Picasso] to facilitate loading of Images.
 * @param listener Lambda Expression as the Click Listener of this [RocketViewHolder].
 * @author Ritwik Jamuar
 */
class RocketsAdapter(
    private val picasso: Picasso,
    private val listener: (Int) -> Unit
) : BaseSingleVHAdapter<Rocket, RocketViewHolder>() {

    /*----------------------------------- BaseSingleVHAdapter ------------------------------------*/

    override fun provideViewHolder(parent: ViewGroup): RocketViewHolder = RocketViewHolder(
        ItemRocketBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        picasso,
        listener
    )

    override fun onBind(viewHolder: RocketViewHolder, position: Int) =
        viewHolder.setRocketItem(list[position])

}
