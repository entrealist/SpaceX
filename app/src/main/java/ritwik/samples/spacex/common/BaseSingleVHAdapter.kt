package ritwik.samples.spacex.common

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

/**[androidx.recyclerview.widget.RecyclerView.Adapter] that abstracts the common set-up of itself.
 * @param Model Data Model Object on which the Adapter will render the items.
 * @param ViewHolder [BaseViewHolder] that will render the View of each [Model].
 * @author Ritwik Jamuar.*/
abstract class BaseSingleVHAdapter<
        Model,
        ViewHolder : BaseViewHolder
        > : RecyclerView.Adapter<ViewHolder>() {

    /**[List] of [Model] maintained in this Adapter.*/
    private val list = ArrayList<Model>()

    /*------------------------------ RecyclerView.Adapter Callbacks ------------------------------*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        provideViewHolder(parent)

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = onBind(holder, position)

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.markAttach()
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.markDetach()
    }

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**Replaces the existing [List] of [Model] with the new [List] of [Model] provided in the
     * parameter.
     * @param list New [List] of [Model].*/
    fun replaceList(list: List<Model>) {
        // Clear and Add the new List in the existing list.
        this.list.clear()
        this.list.addAll(list)

        // Notify this adapter of changes in the Data Set.
        // This will make the method 'onBindViewHolder()' to be called again for every item in the list.
        // Although for small list, this does not mark any significant impact, but as the list
        // gets larger, this operation becomes very heavy in terms of CPU and Memory usage.
        // So, if the List going to be rendered is very large, then using DIffUtil is recommended.
        notifyDataSetChanged()
    }

    /**Provides the existing [List] of [Model].
     * @return Existing [List] of [Model] in this adapter.*/
    protected fun getList(): List<Model> = list

    /*------------------------------------- Abstract Methods -------------------------------------*/

    /**
     * Tells the implementor to provide [ViewHolder].
     * @return Instance of [ViewHolder].
     */
    abstract fun provideViewHolder(parent: ViewGroup): ViewHolder

    /**Notifies the implementor to apply the Bindings.
     * @param holder Reference of [ViewHolder] in the [position].
     * @param position Position in the [List] of [Model].*/
    abstract fun onBind(holder: ViewHolder, position: Int)

}