package ritwik.samples.spacex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import ritwik.samples.spacex.data.ui.Launch

import ritwik.samples.spacex.databinding.ItemUpcomingLaunchBinding

import ritwik.samples.spacex.ui.viewHolder.UpcomingLaunchViewHolder

import sample.ritwik.common.ui.adapter.BaseSingleVHAdapter

/**
 * [BaseSingleVHAdapter] to render a collection of [Launch] using [UpcomingLaunchViewHolder].
 *
 * @param listener Lambda Expression as the Click Listener of this [UpcomingLaunchViewHolder].
 * @author Ritwik Jamuar
 */
class UpcomingLaunchAdapter(
    private val listener: (Int) -> Unit
) : BaseSingleVHAdapter<Launch, UpcomingLaunchViewHolder>() {

    /*----------------------------------- BaseSingleVHAdapter ------------------------------------*/

    override fun provideViewHolder(parent: ViewGroup): UpcomingLaunchViewHolder =
        UpcomingLaunchViewHolder(
            ItemUpcomingLaunchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            listener
        )

    override fun onBind(viewHolder: UpcomingLaunchViewHolder, position: Int) =
        viewHolder.setLaunchItem(list[position])

}
