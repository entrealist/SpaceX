package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.view.View

import androidx.databinding.ViewDataBinding

import androidx.lifecycle.Observer

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.component.other.NetworkProcessor

import ritwik.samples.spacex.databinding.FragmentTheCompanyBinding

import ritwik.samples.spacex.model.Company

import java.lang.RuntimeException

/**
 * [BaseFragment] that shows information about the company 'SpaceX'.
 * @author Ritwik Jamuar.
 */
class TheCompanyFragment : BaseFragment() {

	// DataBinding.
	private lateinit var binding : FragmentTheCompanyBinding

	// Listeners.
	private var listener : MainFragmentListener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {

		/**Creates an instance of [TheCompanyFragment].
		 * @return New Instance of [TheCompanyFragment].*/
		@JvmStatic
		fun create(): TheCompanyFragment = TheCompanyFragment()

	}

	/*----------------------------------------- Observers ----------------------------------------*/

	private val aboutTheCompanyObserver = Observer<NetworkProcessor.Resource<Company>> { resource ->
		listener?.getVM()?.onAboutTheCompanyResponse(resource)
	}

	private val companyObserver = Observer<Company> { company ->
		binding.company = company
	}

	/*---------------------------------- BaseFragment Callbacks ----------------------------------*/

	override fun setListener(context : Context) {
		if (context is MainFragmentListener) {
			listener = context
		} else {
			throw RuntimeException("$context must implement Listener")
		}
	}

	override fun attachObservers() {
		listener?.getVM()?.getAboutTheCompanyLiveData()?.observe(viewLifecycleOwner, companyObserver)
	}

	override fun layoutRes() : Int = R.layout.fragment_the_company

	override fun isDataBinding() : Boolean = true

	override fun provideDataBinding(binding : ViewDataBinding) {
		this.binding = binding as FragmentTheCompanyBinding
	}

	override fun initializeViews(view : View) = Unit

	override fun initializeViews() {
		getAboutTheCompany()
	}

	override fun cleanUp() = Unit

	override fun removeListener() {
		listener = null
	}

	/*-------------------------------------- Private Methods -------------------------------------*/

	private fun getAboutTheCompany() {
		listener?.getVM()?.getAboutTheCompany()?.observe(viewLifecycleOwner, aboutTheCompanyObserver)
	}

}