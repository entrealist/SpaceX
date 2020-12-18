package ritwik.samples.spacex.ui.viewHolder

import ritwik.samples.spacex.data.ui.HistoricEvent
import ritwik.samples.spacex.data.ui.HistoricEvents

import ritwik.samples.spacex.databinding.ItemHistoricYearBinding

import ritwik.samples.spacex.ui.adapter.HistoricEventsAdapter

import sample.ritwik.common.ui.viewHolder.BaseViewHolder

/**
 * [BaseViewHolder] to render a [HistoricEvents].
 *
 * @param binding Data Binding of this [BaseViewHolder].
 * @param listener Lambda Expression as the Click Listener of this [BaseViewHolder].
 * @author Ritwik Jamuar
 */
class HistoricYearViewHolder(
    binding: ItemHistoricYearBinding,
    private val listener: (HistoricEvent) -> Unit,
) : BaseViewHolder<ItemHistoricYearBinding>(binding) {

    /*--------------------------------- BaseViewHolder Callbacks ---------------------------------*/

    override fun initializeComponents() = Unit

    override fun cleanUp() = Unit

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Makes use of [HistoricEvents] and populate [List] of [HistoricEvent] under [binding].
     *
     * @param historicEventsItem Instance of [HistoricEvent] denoting the Historic Events for a Year.
     */
    fun setHistoricEventsItem(historicEventsItem: HistoricEvents) = with(binding) {
        year = historicEventsItem.year.toString()
        listHistoricEvents.adapter = HistoricEventsAdapter(listener).apply {
            replaceList(historicEventsItem.events)
        }
    }

}
