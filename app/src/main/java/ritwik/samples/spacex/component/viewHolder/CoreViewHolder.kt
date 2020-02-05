package ritwik.samples.spacex.component.viewHolder

import android.view.View

import ritwik.samples.spacex.common.BaseViewHolder

import ritwik.samples.spacex.databinding.RecyclerItemCoreBinding

import ritwik.samples.spacex.model.Core

/**[androidx.recyclerview.widget.RecyclerView.ViewHolder] for rendering [Core]s.
 * @param containerView [View] of this [androidx.recyclerview.widget.RecyclerView.ViewHolder].
 * @param binding Data Binding Reference of the layout of this [androidx.recyclerview.widget.RecyclerView.ViewHolder].
 * @author Ritwik Jamuar.*/
class CoreViewHolder (
    override val containerView: View,
    private val binding: RecyclerItemCoreBinding
) : BaseViewHolder(containerView) {

    /*------------------------------------- Initializer Block ------------------------------------*/

    init {

        // Set the Lifecycle Owner of the DataBinding to this.
        binding.lifecycleOwner = this

    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**Sets the [Core] to [RecyclerItemCoreBinding].
     * @param core Instance of [Core] which will be set.*/
    fun setCore(core: Core) {
        binding.core = core
    }

}