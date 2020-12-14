package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import android.view.View

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.FragmentCapsulesBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import ritwik.samples.spacex.ui.adapter.CapsulesAdapter

import ritwik.samples.spacex.utility.constant.POPULATE_CAPSULES

import sample.ritwik.common.ui.fragment.BaseFragment

/**
 * [BaseFragment] to show the List of Capsules used by SpaceX.
 *
 * @author Ritwik Jamuar
 */
class CapsulesFragment : BaseFragment<FragmentCapsulesBinding, MainModel, MainViewModel>() {

    /*---------------------------------- BaseFragment Callbacks ----------------------------------*/

    override fun layoutRes(): Int = R.layout.fragment_capsules

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

        POPULATE_CAPSULES -> {
            binding?.listCapsules?.adapter?.let { adapter ->
                (adapter as? CapsulesAdapter)?.replaceList(uiData.capsules) ?: Unit
            } ?: Unit
        }

        else -> Unit

    }

    override fun cleanUp() = binding?.let { dataBinding ->
        dataBinding.listCapsules.adapter = null
    } ?: Unit

    /*------------------------------------- Private Methods --------------------------------------*/

    /**
     * Sets-up the views under [binding].
     */
    private fun setUpView() = binding?.let { dataBinding ->
        viewModel?.let { vm ->
            with(dataBinding) {
                listCapsules.adapter = CapsulesAdapter(vm.capsuleListener)
            }
        } ?: Unit
    } ?: Unit

    /**
     * Requests the data through [viewModel].
     */
    private fun requestData() = viewModel?.fetchCapsules() ?: Unit

}
