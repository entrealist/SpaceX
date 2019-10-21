package ritwik.samples.spacex.components.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

/**[RecyclerView.ViewHolder] of [ritwik.samples.spacex.components.adapters.CapsuleListAdapter].
 * @author Ritwik Jamuar.*/
open class CapsuleListViewHolder (
	override val containerView: View
) : RecyclerView.ViewHolder ( containerView ), LayoutContainer