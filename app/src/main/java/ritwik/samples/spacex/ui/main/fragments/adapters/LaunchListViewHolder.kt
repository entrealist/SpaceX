package ritwik.samples.spacex.ui.main.fragments.adapters

import android.view.View

import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.extensions.LayoutContainer

/**[RecyclerView.ViewHolder] of [LaunchListAdapter].
 * @author Ritwik Jamuar.*/
open class LaunchListViewHolder (
	override val containerView: View
) : RecyclerView.ViewHolder ( containerView ), LayoutContainer