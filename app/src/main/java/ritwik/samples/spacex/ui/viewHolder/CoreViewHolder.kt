package ritwik.samples.spacex.ui.viewHolder

import android.view.View

import ritwik.samples.spacex.data.ui.Core

import ritwik.samples.spacex.databinding.ItemCoreBinding

import sample.ritwik.common.ui.viewHolder.BaseViewHolder

/**
 * [BaseViewHolder] to render a [Core].
 *
 * @param binding Data Binding of this [BaseViewHolder].
 * @param listener Lambda Expression as the Click Listener of this [BaseViewHolder].
 * @author Ritwik Jamuar
 */
class CoreViewHolder(
    binding: ItemCoreBinding,
    private val listener: (Int) -> Unit
) : BaseViewHolder<ItemCoreBinding>(binding) {

    /*-------------------------------------- View Listeners --------------------------------------*/

    /**
     * [View.OnClickListener] to intercept click on the item.
     */
    private val rootClickListener = View.OnClickListener {
        listener.invoke(adapterPosition)
    }

    /*--------------------------------- BaseViewHolder Callbacks ---------------------------------*/

    override fun initializeComponents() = with(binding) {
        rootView.setOnClickListener(rootClickListener)
    }

    override fun cleanUp() = with(binding) {
        rootView.setOnClickListener(null)
    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Sets the [Core] in the [binding].
     *
     * @param coreItem Instance of [Core] to be assigned into the [binding].
     */
    fun setCoreItem(coreItem: Core) = with(binding) {
        core = coreItem
    }

}
