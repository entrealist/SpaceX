package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import android.view.View

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.FragmentCapsulesBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

import ritwik.samples.spacex.ui.adapter.CapsulesAdapter

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

    override fun showLoading() = binding?.placeholderShimmerCapsule?.let { shimmer ->
        shimmer.visibility = View.VISIBLE
        shimmer.startShimmer()
    } ?: Unit

    override fun hideLoading() = binding?.placeholderShimmerCapsule?.let { shimmer ->
        shimmer.stopShimmer()
        shimmer.visibility = View.GONE
    } ?: Unit

    override fun onUIDataChanged(uiData: MainModel) = with(uiData) {
        if (isCapsulesPopulated()) {
            binding?.listCapsules?.adapter?.let { adapter ->
                (adapter as? CapsulesAdapter)?.replaceList(capsules) ?: Unit
            } ?: Unit
        }
    }

    override fun onAction(uiData: MainModel) = Unit

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
