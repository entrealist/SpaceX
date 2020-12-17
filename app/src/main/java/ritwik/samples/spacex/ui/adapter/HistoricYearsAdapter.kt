package ritwik.samples.spacex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import ritwik.samples.spacex.data.ui.HistoricEvent
import ritwik.samples.spacex.data.ui.HistoricEvents

import ritwik.samples.spacex.databinding.ItemHistoricYearBinding

import ritwik.samples.spacex.ui.viewHolder.HistoricYearViewHolder

import sample.ritwik.common.ui.adapter.BaseSingleVHAdapter

/**
 * [BaseSingleVHAdapter] to render a collection of [HistoricEvents] using [HistoricYearViewHolder].
 *
 * @param listener Lambda Expression as the Click Listener of this [HistoricYearViewHolder].
 * @author Ritwik Jamuar
 */
class HistoricYearsAdapter(
    private val listener: (HistoricEvent) -> Unit
) : BaseSingleVHAdapter<HistoricEvents, HistoricYearViewHolder>() {

    /*----------------------------------- BaseSingleVHAdapter ------------------------------------*/

    override fun provideViewHolder(parent: ViewGroup): HistoricYearViewHolder =
        HistoricYearViewHolder(
            ItemHistoricYearBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            listener
        )

    override fun onBind(viewHolder: HistoricYearViewHolder, position: Int) =
        viewHolder.setHistoricEventsItem(list[position])

}
