package ritwik.samples.spacex.component.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import ritwik.samples.spacex.common.BaseSingleVHAdapter

import ritwik.samples.spacex.component.viewHolder.LaunchViewHolder

import ritwik.samples.spacex.databinding.RecyclerItemLaunchBinding

import ritwik.samples.spacex.pojo.launches.Launch

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

/**[RecyclerView.Adapter] of [RecyclerView] that shows list of launches.
 * @param viewModel ViewModel of [ritwik.samples.spacex.ui.main.MainActivity].
 * @author Ritwik Jamuar.*/
class LaunchListAdapter (
	private val viewModel : MainViewModel
) : BaseSingleVHAdapter<Launch, LaunchViewHolder> () {

	/*------------------------------ BaseSingleVHAdapter Callbacks -------------------------------*/

	override fun provideViewHolder(parent: ViewGroup): LaunchViewHolder {
		// Instantiate the Data Binding.
		val binding = RecyclerItemLaunchBinding.inflate(
			LayoutInflater.from(parent.context),
			parent,
			false
		)

		// Instantiate the ViewHolder.
		return LaunchViewHolder(
			binding.root,
			binding,
			viewModel
		)
	}

	override fun onBind(holder: LaunchViewHolder, position: Int) {
		holder.setLaunch(getList()[position])
	}

}