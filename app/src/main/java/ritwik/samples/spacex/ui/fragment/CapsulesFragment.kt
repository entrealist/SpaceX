package ritwik.samples.spacex.ui.fragment

import android.os.Bundle

import ritwik.samples.spacex.R

import ritwik.samples.spacex.databinding.FragmentCapsulesBinding

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.viewModel.MainViewModel

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

    override fun initializeViews() = Unit

    override fun showLoading() = Unit

    override fun hideLoading() = Unit

    override fun onUIDataChanged(uiData: MainModel) = Unit

    override fun onAction(uiData: MainModel) = Unit

    override fun cleanUp() = Unit

}
