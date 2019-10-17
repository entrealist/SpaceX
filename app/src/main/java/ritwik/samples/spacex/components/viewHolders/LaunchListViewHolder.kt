package ritwik.samples.spacex.components.viewHolders

import android.view.View

import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.extensions.LayoutContainer

/**[RecyclerView.ViewHolder] of [ritwik.samples.spacex.components.adapters.LaunchListAdapter].
 * @author Ritwik Jamuar.*/
open class LaunchListViewHolder (
	override val containerView: View
) : RecyclerView.ViewHolder ( containerView ), LayoutContainer