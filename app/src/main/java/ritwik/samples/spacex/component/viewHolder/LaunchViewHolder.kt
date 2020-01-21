package ritwik.samples.spacex.component.viewHolder

import android.view.View

import ritwik.samples.spacex.common.BaseViewHolder

import ritwik.samples.spacex.databinding.RecyclerItemLaunchBinding

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

import ritwik.samples.spacex.pojo.launches.Launch

/**[androidx.recyclerview.widget.RecyclerView.ViewHolder] for rendering [Launch].
 * @param containerView [View] of this [androidx.recyclerview.widget.RecyclerView.ViewHolder].
 * @param binding Data Binding Reference of the layout of this [androidx.recyclerview.widget.RecyclerView.ViewHolder].
 * @param viewModel ViewModel of [ritwik.samples.spacex.ui.main.MainActivity].
 * @author Ritwik Jamuar.*/
class LaunchViewHolder(
    override val containerView: View,
    private val binding: RecyclerItemLaunchBinding,
    viewModel: MainViewModel
) : BaseViewHolder (containerView) {

    /*------------------------------------- Initializer Block ------------------------------------*/

    init {
        // Set the Lifecycle Owner of the DataBinding to this.
        binding.lifecycleOwner = this

        // Set the ViewModel to the DataBinding.
        binding.viewModel = viewModel
    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**Sets the [Launch] to [RecyclerItemLaunchBinding].
     * @param launch Instance of [Launch] which will be set.*/
    fun setLaunch(launch: Launch) {
        binding.launch = launch
    }

}