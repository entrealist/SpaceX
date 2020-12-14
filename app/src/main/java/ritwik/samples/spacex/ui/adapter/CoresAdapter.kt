package ritwik.samples.spacex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import ritwik.samples.spacex.data.ui.Core

import ritwik.samples.spacex.databinding.ItemCoreBinding

import ritwik.samples.spacex.ui.viewHolder.CoreViewHolder

import sample.ritwik.common.ui.adapter.BaseSingleVHAdapter

/**
 * [BaseSingleVHAdapter] to render a collection of [Core] using [CoreViewHolder].
 *
 * @param listener Lambda Expression as the Click Listener of this [CoreViewHolder].
 * @author Ritwik Jamuar
 */
class CoresAdapter(
    private val listener: (Int) -> Unit
) : BaseSingleVHAdapter<Core, CoreViewHolder>() {

    /*----------------------------------- BaseSingleVHAdapter ------------------------------------*/

    override fun provideViewHolder(parent: ViewGroup): CoreViewHolder = CoreViewHolder(
        ItemCoreBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        listener
    )

    override fun onBind(viewHolder: CoreViewHolder, position: Int) =
        viewHolder.setCoreItem(list[position])

}
