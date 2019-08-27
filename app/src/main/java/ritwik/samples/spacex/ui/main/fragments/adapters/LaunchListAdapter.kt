package ritwik.samples.spacex.ui.main.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import ritwik.samples.spacex.databinding.RecyclerItemLaunchBinding

import ritwik.samples.spacex.pojo.Launch

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

/**[RecyclerView.Adapter] of [RecyclerView] that shows list of launches.
 * @author Ritwik Jamuar.*/
class LaunchListAdapter (
	private val viewModel : MainViewModel
) : RecyclerView.Adapter < LaunchListViewHolder > () {
	// Lists.
	private var launchesList : List < Launch > = listOf ()

	/*------------------------------ RecyclerView.Adapter Callbacks ------------------------------*/

	override fun onCreateViewHolder (
		parent : ViewGroup,
		viewType : Int
	) : LaunchListViewHolder {
		// Instantiate the Layout Inflater from 'parent' ViewGroup's Context.
		val inflater = LayoutInflater.from ( parent.context )

		// Using <Name_of_the_Layout_XML_in_Camel_Case>Binding, inflate the Layout.
		val binding = RecyclerItemLaunchBinding.inflate ( inflater, parent, false )

		// Instantiate the ViewHolder by providing View and Binding.
		val viewHolder = LaunchListBindingViewHolder ( binding.root, binding )

		// Set the Life Cycle Owner of Binding.
		binding.lifecycleOwner = viewHolder

		return viewHolder
	}

	override fun onBindViewHolder (
		holder : LaunchListViewHolder,
		position : Int
	) {
		// Get the item in that position from the List.
		val launch = launchesList [ position ]

		// If the holder is indeed an instance of BindingViewHolder, then we can apply the
		// binding directly to the layout.
		// Thus, check whether the holder is an instance of BindingViewHolder.
		if ( holder is LaunchListBindingViewHolder ) {
			holder.apply {
				binding.viewModel = viewModel
				binding.launch = launch
			}
		}
	}

	override fun onViewAttachedToWindow ( holder : LaunchListViewHolder ) {
		super.onViewAttachedToWindow ( holder )
		if ( holder is LaunchListBindingViewHolder ) {
			holder.markAttach ()
		}
	}

	override fun onViewDetachedFromWindow ( holder : LaunchListViewHolder ) {
		super.onViewDetachedFromWindow ( holder )
		if ( holder is LaunchListBindingViewHolder ) {
			holder.markDetach ()
		}
	}

	override fun getItemCount () : Int {
		return launchesList.size
	}

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Replaces the List of Launch with the given list as parameter.
	 * @param launches [List] of [Launch].*/
	fun replaceLaunchesList ( launches : List < Launch > ) {
		this.launchesList = launches
		notifyDataSetChanged ()
	}

}