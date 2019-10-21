package ritwik.samples.spacex.components.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import ritwik.samples.spacex.components.viewHolders.CapsuleListBindingViewHolder
import ritwik.samples.spacex.components.viewHolders.CapsuleListViewHolder

import ritwik.samples.spacex.databinding.RecyclerItemCapsuleBinding

import ritwik.samples.spacex.pojo.capsules.Capsule

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

/**[RecyclerView.Adapter] of [RecyclerView] that shows [List] of [Capsule].
 * @author Ritwik Jamuar.*/
class CapsuleListAdapter (
	private val viewModel : MainViewModel
) : RecyclerView.Adapter < CapsuleListViewHolder > () {

	// Lists.
	private var list : List < Capsule > = listOf ()

	/*------------------------------ RecyclerView.Adapter Callbacks ------------------------------*/

	override fun onCreateViewHolder (
		parent : ViewGroup,
		viewType : Int
	) : CapsuleListViewHolder {
		// Instantiate the Layout Inflater from 'parent' ViewGroup's Context.
		val inflater = LayoutInflater.from ( parent.context )

		// Using <Name_of_the_Layout_XML_in_Camel_Case>Binding, inflate the Layout.
		val binding =
			RecyclerItemCapsuleBinding.inflate (
				inflater,
				parent,
				false
			)

		// Instantiate the ViewHolder by providing View and Binding.
		val viewHolder = CapsuleListBindingViewHolder ( binding.root, binding )

		// Set the Life Cycle Owner of Binding.
		binding.lifecycleOwner = viewHolder

		return viewHolder
	}

	override fun onBindViewHolder (
		holder : CapsuleListViewHolder,
		position : Int
	) {
		// Get the item in that position from the List.
		val capsule = list [ position ]

		// If the holder is indeed an instance of BindingViewHolder, then we can apply the
		// binding directly to the layout.
		// Thus, check whether the holder is an instance of BindingViewHolder.
		if ( holder is CapsuleListBindingViewHolder ) {
			holder.apply {
				binding.viewModel = viewModel
				binding.capsule = capsule
			}
		}
	}

	override fun onViewAttachedToWindow ( holder : CapsuleListViewHolder ) {
		super.onViewAttachedToWindow ( holder )
		if ( holder is CapsuleListBindingViewHolder ) {
			holder.markAttach ()
		}
	}

	override fun onViewDetachedFromWindow ( holder : CapsuleListViewHolder ) {
		super.onViewDetachedFromWindow ( holder )
		if ( holder is CapsuleListBindingViewHolder ) {
			holder.markDetach ()
		}
	}

	override fun getItemCount () : Int = list.size

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Replaces the List of Launch with the given list as parameter.
	 * @param rockets [List] of [Capsule].*/
	fun replaceCapsuleList ( rockets : List < Capsule > ) {
		this.list = rockets
		notifyDataSetChanged ()
	}

}