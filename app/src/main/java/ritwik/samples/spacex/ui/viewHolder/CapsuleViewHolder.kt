package ritwik.samples.spacex.ui.viewHolder

import android.view.View

import ritwik.samples.spacex.data.ui.Capsule

import ritwik.samples.spacex.databinding.ItemCapsuleBinding

import sample.ritwik.common.ui.viewHolder.BaseViewHolder

/**
 * [BaseViewHolder] to render a [Capsule].
 *
 * @param binding Data Binding of this [BaseViewHolder].
 * @param listener Lambda Expression as the Click Listener of this [BaseViewHolder].
 * @author Ritwik Jamuar
 */
class CapsuleViewHolder(
    binding: ItemCapsuleBinding,
    private val listener: (Int) -> Unit
) : BaseViewHolder<ItemCapsuleBinding>(binding) {

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
     * Sets the [Capsule] in the [binding].
     *
     * @param capsuleItem Instance of [Capsule] to be assigned into the [binding].
     */
    fun setCapsuleItem(capsuleItem: Capsule) = with(binding) {
        capsule = capsuleItem
    }

}
