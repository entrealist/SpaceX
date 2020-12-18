package ritwik.samples.spacex.ui.viewHolder

import android.view.View

import ritwik.samples.spacex.data.ui.HistoricEvent

import ritwik.samples.spacex.databinding.ItemHistoricEventBinding

import sample.ritwik.common.ui.viewHolder.BaseViewHolder

/**
 * [BaseViewHolder] to render a [HistoricEvent].
 *
 * @param binding Data Binding of this [BaseViewHolder].
 * @param listener Lambda Expression as the Click Listener of this [BaseViewHolder].
 * @author Ritwik Jamuar
 */
class HistoricEventViewHolder(
    binding: ItemHistoricEventBinding,
    private val listener: (HistoricEvent) -> Unit,
) : BaseViewHolder<ItemHistoricEventBinding>(binding) {

    /*-------------------------------------- View Listeners --------------------------------------*/

    /**
     * [View.OnClickListener] to intercept click on 'More Info'.
     */
    private val moreInfoClickListener = View.OnClickListener {
        binding.historicEvent?.let { event ->
            listener.invoke(event)
        }
    }

    /*--------------------------------- BaseViewHolder Callbacks ---------------------------------*/

    override fun initializeComponents() = with(binding) {
        buttonMoreInfo.setOnClickListener(moreInfoClickListener)
    }

    override fun cleanUp() = with(binding) {
        buttonMoreInfo.setOnClickListener(null)
    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Sets the [HistoricEvent] in the [binding].
     *
     * @param historicEventItem Instance of [HistoricEvent] to be assigned into the [binding].
     */
    fun setHistoricEventItem(historicEventItem: HistoricEvent) = with(binding) {
        historicEvent = historicEventItem
    }

}
