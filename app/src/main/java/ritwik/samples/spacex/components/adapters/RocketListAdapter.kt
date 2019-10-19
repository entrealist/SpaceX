package ritwik.samples.spacex.components.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import ritwik.samples.spacex.components.viewHolders.RocketListBindingViewHolder
import ritwik.samples.spacex.components.viewHolders.RocketListViewHolder

import ritwik.samples.spacex.databinding.RecyclerItemRocketBinding

import ritwik.samples.spacex.pojo.rockets.Rocket

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

/**[RecyclerView.Adapter] of [RecyclerView] that shows [List] of [Rocket].
 * @author Ritwik Jamuar.*/
class RocketListAdapter (
	private val viewModel : MainViewModel
) : RecyclerView.Adapter < RocketListViewHolder > () {

	// Lists.
	private var list : List < Rocket > = listOf ()

	/*------------------------------ RecyclerView.Adapter Callbacks ------------------------------*/

	override fun onCreateViewHolder (
		parent : ViewGroup,
		viewType : Int
	) : RocketListViewHolder {
		// Instantiate the Layout Inflater from 'parent' ViewGroup's Context.
		val inflater = LayoutInflater.from ( parent.context )

		// Using <Name_of_the_Layout_XML_in_Camel_Case>Binding, inflate the Layout.
		val binding =
			RecyclerItemRocketBinding.inflate (
				inflater,
				parent,
				false
			)

		// Instantiate the ViewHolder by providing View and Binding.
		val viewHolder = RocketListBindingViewHolder ( binding.root, binding )

		// Set the Life Cycle Owner of Binding.
		binding.lifecycleOwner = viewHolder

		return viewHolder
	}

	override fun onBindViewHolder (
		holder : RocketListViewHolder,
		position : Int
	) {
		// Get the item in that position from the List.
		val rocket = list [ position ]

		// If the holder is indeed an instance of BindingViewHolder, then we can apply the
		// binding directly to the layout.
		// Thus, check whether the holder is an instance of BindingViewHolder.
		if ( holder is RocketListBindingViewHolder ) {
			holder.apply {
				binding.viewModel = viewModel
				binding.rocket = rocket
			}
		}
	}

	override fun onViewAttachedToWindow ( holder : RocketListViewHolder ) {
		super.onViewAttachedToWindow ( holder )
		if ( holder is RocketListBindingViewHolder ) {
			holder.markAttach ()
		}
	}

	override fun onViewDetachedFromWindow ( holder : RocketListViewHolder ) {
		super.onViewDetachedFromWindow ( holder )
		if ( holder is RocketListBindingViewHolder ) {
			holder.markDetach ()
		}
	}

	override fun getItemCount () : Int = list.size

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Replaces the List of Launch with the given list as parameter.
	 * @param rockets [List] of [Rocket].*/
	fun replaceLaunchesList ( rockets : List < Rocket > ) {
		this.list = rockets
		notifyDataSetChanged ()
	}

}