package ritwik.samples.spacex.common

import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

import androidx.fragment.app.Fragment

/**Base [Fragment] to abstract common instantiation and clan-up procedures.
 * @author Ritwik Jamuar.*/
abstract class BaseFragment : Fragment() {

    /*------------------------------------ Fragment Callbacks ------------------------------------*/

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            setListener(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (isDataBinding()) {
            val binding: ViewDataBinding = DataBindingUtil.inflate(
                inflater,
                layoutRes(),
                container,
                false
            )
            provideDataBinding(binding = binding)
            binding.root
        } else {
            inflater.inflate(layoutRes(), container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isDataBinding()) {
            initializeViews()
        } else {
            initializeViews(view)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cleanUp()
    }

    override fun onDetach() {
        super.onDetach()
        removeListener()
    }

    /*------------------------------------- Abstract Methods -------------------------------------*/

    /**Tells the implementing [Fragment] to set the interface listener if it wishes.
     * @param context [Context] from where this [Fragment] has been started.*/
    abstract fun setListener(context: Context)

    /**Tells the implementing [Fragment] to attach [androidx.lifecycle.Observer]s to
     * any [androidx.lifecycle.LiveData].*/
    abstract fun attachObservers()

    /**Tells the implementing [Fragment] to provide it's Layout Resource ID.
     * @return [Int] denoting the Layout's Resource ID of [Fragment].*/
    abstract fun layoutRes(): Int

    /**Determines from the implementing [Fragment] whether it is employing DataBinding or not.
     * @return true, if the implementing [Fragment] uses DataBinding, else false.*/
    abstract fun isDataBinding(): Boolean

    /**Provides the binding to implementing [Fragment].
     * @param binding [ViewDataBinding] that can be cast to View specific Binding Class.*/
    abstract fun provideDataBinding(binding: ViewDataBinding)

    /**Tells the implementing [Fragment] to initializes it's Child [View]s.
     * @param view [View] of the Root, which contains all other child [View]s.*/
    abstract fun initializeViews(view: View)

    /**Tells the implementing [Fragment] to initializes it's Child [View]s.*/
    abstract fun initializeViews()

    /**Tells the implementing [Fragment] to clean-up it's resources for preventing
     * a potential Memory Leak.*/
    abstract fun cleanUp()

    /**Tells the implementing [Fragment] to remove it's listener to the [Context].*/
    abstract fun removeListener()

}