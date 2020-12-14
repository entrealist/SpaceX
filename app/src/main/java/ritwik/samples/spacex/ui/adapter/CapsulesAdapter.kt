package ritwik.samples.spacex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import ritwik.samples.spacex.data.ui.Capsule

import ritwik.samples.spacex.databinding.ItemCapsuleBinding

import ritwik.samples.spacex.ui.viewHolder.CapsuleViewHolder

import sample.ritwik.common.ui.adapter.BaseSingleVHAdapter

/**
 * [BaseSingleVHAdapter] to render a collection of [Capsule] using [CapsuleViewHolder].
 *
 * @param listener Lambda Expression as the Click Listener of this [CapsuleViewHolder].
 * @author Ritwik Jamuar
 */
class CapsulesAdapter(
    private val listener: (Int) -> Unit
) : BaseSingleVHAdapter<Capsule, CapsuleViewHolder>() {

    /*----------------------------------- BaseSingleVHAdapter ------------------------------------*/

    override fun provideViewHolder(parent: ViewGroup): CapsuleViewHolder = CapsuleViewHolder(
        ItemCapsuleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        listener
    )

    override fun onBind(viewHolder: CapsuleViewHolder, position: Int) =
        viewHolder.setCapsuleItem(list[position])

}
