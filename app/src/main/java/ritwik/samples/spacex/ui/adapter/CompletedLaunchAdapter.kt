package ritwik.samples.spacex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import ritwik.samples.spacex.data.ui.Launch

import ritwik.samples.spacex.databinding.ItemCompletedLaunchBinding

import ritwik.samples.spacex.ui.viewHolder.CompletedLaunchViewHolder

import sample.ritwik.common.ui.adapter.BaseSingleVHAdapter

/**
 * [BaseSingleVHAdapter] to render a collection of [Launch] using [CompletedLaunchViewHolder].
 *
 * @param listener Lambda Expression as the Click Listener of this [CompletedLaunchViewHolder].
 * @author Ritwik Jamuar
 */
class CompletedLaunchAdapter(
    private val listener: (Int) -> Unit
) : BaseSingleVHAdapter<Launch, CompletedLaunchViewHolder>() {

    /*----------------------------------- BaseSingleVHAdapter ------------------------------------*/

    override fun provideViewHolder(parent: ViewGroup): CompletedLaunchViewHolder =
        CompletedLaunchViewHolder(
            ItemCompletedLaunchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            listener
        )

    override fun onBind(viewHolder: CompletedLaunchViewHolder, position: Int) =
        viewHolder.setLaunchItem(list[position])

}
