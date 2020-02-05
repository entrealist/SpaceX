package ritwik.samples.spacex.component.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import ritwik.samples.spacex.common.BaseSingleVHAdapter

import ritwik.samples.spacex.component.viewHolder.CoreViewHolder

import ritwik.samples.spacex.databinding.RecyclerItemCoreBinding

import ritwik.samples.spacex.model.Core

/**[androidx.recyclerview.widget.RecyclerView.Adapter] for handling the [List] of [Core].
 * @author Ritwik Jamuar.*/
class CoreAdapter : BaseSingleVHAdapter<Core, CoreViewHolder> () {

    /*------------------------------ BaseSingleVHAdapter Callbacks -------------------------------*/

    override fun provideViewHolder(parent: ViewGroup): CoreViewHolder {
        // Instantiate the Data Binding.
        val binding = RecyclerItemCoreBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        // Instantiate the ViewHolder.
        return CoreViewHolder(
            binding.root,
            binding
        )
    }

    override fun onBind(holder: CoreViewHolder, position: Int) {
        // Pass the Capsule onto ViewHolder.
        holder.setCore(getList()[position])
    }

}