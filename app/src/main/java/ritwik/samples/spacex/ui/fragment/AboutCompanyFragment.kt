package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import android.view.View

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.FragmentAboutCompanyBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import sample.ritwik.common.ui.fragment.BaseFragment

/**
 * [BaseFragment] to show the details of the Company.
 *
 * @author Ritwik Jamuar
 */
class AboutCompanyFragment : BaseFragment<FragmentAboutCompanyBinding, MainModel, MainViewModel>() {

    /*---------------------------------- BaseFragment Callbacks ----------------------------------*/

    override fun layoutRes(): Int = R.layout.fragment_about_company

    override fun extractArguments(arguments: Bundle) = Unit

    override fun initializeViews() = requestData()

    override fun showLoading() = binding?.placeholderShimmerAboutCompany?.let { shimmer ->
        shimmer.visibility = View.VISIBLE
        shimmer.startShimmer()
    } ?: Unit

    override fun hideLoading() = binding?.placeholderShimmerAboutCompany?.let { shimmer ->
        shimmer.stopShimmer()
        shimmer.visibility = View.GONE
    } ?: Unit

    override fun onUIDataChanged(uiData: MainModel) = binding?.let { dataBinding ->
        with(uiData) {
            if (isAboutCompanyPopulated()) {
                dataBinding.company = company
            }
        }
    } ?: Unit

    override fun onAction(uiData: MainModel) = Unit

    override fun cleanUp() = Unit

    /*------------------------------------- Private Methods --------------------------------------*/

    /**
     * Requests the data through [viewModel].
     */
    private fun requestData() = viewModel?.fetchInfoAboutCompany() ?: Unit

}
