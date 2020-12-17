package ritwik.samples.spacex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import ritwik.samples.spacex.data.ui.HistoricEvent

import ritwik.samples.spacex.databinding.ItemHistoricEventBinding

import ritwik.samples.spacex.ui.viewHolder.HistoricEventViewHolder

import sample.ritwik.common.ui.adapter.BaseSingleVHAdapter

/**
 * [BaseSingleVHAdapter] to render a collection of [HistoricEvent] using [HistoricEventViewHolder].
 *
 * @param listener Lambda Expression as the Click Listener of this [HistoricEventViewHolder].
 * @author Ritwik Jamuar
 */
class HistoricEventsAdapter(
    private val listener: (HistoricEvent) -> Unit
) : BaseSingleVHAdapter<HistoricEvent, HistoricEventViewHolder>() {

    /*----------------------------------- BaseSingleVHAdapter ------------------------------------*/

    override fun provideViewHolder(parent: ViewGroup): HistoricEventViewHolder =
        HistoricEventViewHolder(
            ItemHistoricEventBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            listener
        )

    override fun onBind(viewHolder: HistoricEventViewHolder, position: Int) =
        viewHolder.setHistoricEventItem(list[position])

}
