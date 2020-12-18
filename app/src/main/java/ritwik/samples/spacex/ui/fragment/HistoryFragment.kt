package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import android.view.View

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.FragmentHistoryBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import ritwik.samples.spacex.ui.adapter.HistoricYearsAdapter

import sample.ritwik.common.ui.fragment.BaseFragment

/**
 * [BaseFragment] to the list of Historic Events significant to the SpaceX.
 *
 * @author Ritwik Jamuar
 */
class HistoryFragment : BaseFragment<FragmentHistoryBinding, MainModel, MainViewModel>() {

    /*---------------------------------- BaseFragment Callbacks ----------------------------------*/

    override fun layoutRes(): Int = R.layout.fragment_history

    override fun extractArguments(arguments: Bundle) = Unit

    override fun initializeViews() {
        setUpView()
        requestData()
    }

    override fun showLoading() = binding?.placeholderShimmerHistoricYears?.let { shimmer ->
        shimmer.visibility = View.VISIBLE
        shimmer.startShimmer()
    } ?: Unit

    override fun hideLoading() = binding?.placeholderShimmerHistoricYears?.let { shimmer ->
        shimmer.stopShimmer()
        shimmer.visibility = View.GONE
    } ?: Unit

    override fun onUIDataChanged(uiData: MainModel) = with(uiData) {
        if (isHistoricEventsPopulated()) {
            binding?.let { dataBinding ->
                (dataBinding.listHistoricEvents.adapter as HistoricYearsAdapter).replaceList(historicEvents)
            } ?: Unit
        }
    }

    override fun onAction(uiData: MainModel) = Unit

    override fun cleanUp() = binding?.let { dataBinding ->
        dataBinding.listHistoricEvents.adapter = null
    } ?: Unit

    /*------------------------------------- Private Methods --------------------------------------*/

    /**
     * Sets-up the views under [binding].
     */
    private fun setUpView() = binding?.let { dataBinding ->
        viewModel?.let { vm ->
            with(dataBinding) {
                listHistoricEvents.adapter = HistoricYearsAdapter(vm.historicEventListener)
            }
        } ?: Unit
    } ?: Unit

    /**
     * Requests the data through [viewModel].
     */
    private fun requestData() = viewModel?.fetchAllHistoricEvents() ?: Unit

}
