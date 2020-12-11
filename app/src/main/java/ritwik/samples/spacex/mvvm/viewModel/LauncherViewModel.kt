package ritwik.samples.spacex.mvvm.viewModel

import ritwik.samples.spacex.mvvm.model.LauncherModel

import ritwik.samples.spacex.mvvm.repository.LauncherRepository

import sample.ritwik.common.mvvm.viewModel.BaseViewModel

import javax.inject.Inject

/**
 * ViewModel of [ritwik.samples.spacex.ui.activity.LauncherActivity].
 *
 * @param repository Instance of [LauncherRepository] for [repository].
 * @param model Instance of [LauncherModel] for [model].
 * @author Ritwik Jamuar
 */
class LauncherViewModel @Inject constructor(
    override val repository: LauncherRepository,
    override val model: LauncherModel
) : BaseViewModel<LauncherRepository, LauncherModel>() {

    /*--------------------------------- BaseViewModel Callbacks ----------------------------------*/

    override fun initializeLiveData() = Unit

    override fun initializeVariables() = Unit

    override fun onSessionExpired() = Unit

}
