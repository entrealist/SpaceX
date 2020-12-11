package ritwik.samples.spacex.ui.viewHolder

import android.view.View

import ritwik.samples.spacex.data.ui.Launch

import ritwik.samples.spacex.databinding.ItemUpcomingLaunchBinding

import sample.ritwik.common.ui.viewHolder.BaseViewHolder

/**
 * [BaseViewHolder] to render an Upcoming Launch.
 *
 * @param binding Data Binding of this [BaseViewHolder].
 * @param listener Lambda Expression as the Click Listener of this [BaseViewHolder].
 * @author Ritwik Jamuar
 */
class UpcomingLaunchViewHolder(
    binding: ItemUpcomingLaunchBinding,
    private val listener: (Int) -> Unit
) : BaseViewHolder<ItemUpcomingLaunchBinding>(binding) {

    /*-------------------------------------- View Listeners --------------------------------------*/

    /**
     * [View.OnClickListener] to intercept click on the item.
     */
    private var rootClickListener = View.OnClickListener {
        listener.invoke(adapterPosition)
    }

    /*--------------------------------- BaseViewHolder Callbacks ---------------------------------*/

    override fun initializeComponents() = with(binding) {
        rootView.setOnClickListener(rootClickListener)
    }

    override fun cleanUp() = with(binding) {
        rootView.setOnClickListener(null)
    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Sets the [Launch] in the [binding].
     *
     * @param launchItem Instance of [Launch] to be assigned into the [binding].
     */
    fun setLaunchItem(launchItem: Launch) = with(binding) {
        launch = launchItem
    }

}
