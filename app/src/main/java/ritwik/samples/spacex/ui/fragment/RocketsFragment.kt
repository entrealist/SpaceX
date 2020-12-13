package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.FragmentRocketsBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel
import ritwik.samples.spacex.ui.adapter.RocketsAdapter

import sample.ritwik.common.ui.fragment.BaseFragment

/**
 * [BaseFragment] to show the List of Vehicles used by SpaceX.
 *
 * @author Ritwik Jamuar
 */
class RocketsFragment : BaseFragment<FragmentRocketsBinding, MainModel, MainViewModel>() {

    /*---------------------------------- BaseFragment Callbacks ----------------------------------*/

    override fun layoutRes(): Int = R.layout.fragment_rockets

    override fun extractArguments(arguments: Bundle) = Unit

    override fun initializeViews() = Unit

    override fun showLoading() = Unit

    override fun hideLoading() = Unit

    override fun onUIDataChanged(uiData: MainModel) = Unit

    override fun onAction(uiData: MainModel) = Unit

    override fun cleanUp() = binding?.let { dataBinding ->
        dataBinding.listRocket.adapter = null
    } ?: Unit

    /*------------------------------------- Private Methods --------------------------------------*/

    /**
     * Sets-up the views under [binding].
     */
    private fun setUpView() = binding?.let { dataBinding ->
        viewModel?.let { vm ->
            imageLoader?.let { picasso ->
                with(dataBinding) {
                    listRocket.adapter = RocketsAdapter(
                        picasso,
                        vm.rocketListener
                    )
                }
            } ?: Unit
        } ?: Unit
    } ?: Unit

}
