package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import android.view.View

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.FragmentCoresBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import ritwik.samples.spacex.ui.adapter.CoresAdapter

import ritwik.samples.spacex.utility.constant.POPULATE_CORES

import sample.ritwik.common.ui.fragment.BaseFragment

/**
 * [BaseFragment] to show different Cores of SpaceX.
 *
 * @author Ritwik Jamuar
 */
class CoresFragment : BaseFragment<FragmentCoresBinding, MainModel, MainViewModel>() {

    /*---------------------------------- BaseFragment Callbacks ----------------------------------*/

    override fun layoutRes(): Int = R.layout.fragment_cores

    override fun extractArguments(arguments: Bundle) = Unit

    override fun initializeViews() {
        setUpView()
        requestData()
    }

    override fun showLoading() = binding?.placeholderShimmerContainer?.let { shimmer ->
        shimmer.visibility = View.VISIBLE
        shimmer.startShimmerAnimation()
    } ?: Unit

    override fun hideLoading() = binding?.placeholderShimmerContainer?.let { shimmer ->
        shimmer.stopShimmerAnimation()
        shimmer.visibility = View.GONE
    } ?: Unit

    override fun onUIDataChanged(uiData: MainModel) = Unit

    override fun onAction(uiData: MainModel) = when(uiData.action) {

        POPULATE_CORES -> {
            binding?.listCores?.adapter?.let { adapter ->
                (adapter as? CoresAdapter)?.replaceList(uiData.cores) ?: Unit
            } ?: Unit
        }

        else -> Unit

    }

    override fun cleanUp() = binding?.let { dataBinding ->
        dataBinding.listCores.adapter = null
    } ?: Unit

    /*------------------------------------- Private Methods --------------------------------------*/

    /**
     * Sets-up the views under [binding].
     */
    private fun setUpView() = binding?.let { dataBinding ->
        viewModel?.let { vm ->
            with(dataBinding) {
                listCores.adapter = CoresAdapter(vm.coreListener)
            }
        } ?: Unit
    } ?: Unit

    /**
     * Requests the data through [viewModel].
     */
    private fun requestData() = viewModel?.fetchCores() ?: Unit

}
