package ritwik.samples.spacex.mvvm.viewModel

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.repository.MainRepository

import sample.ritwik.common.mvvm.viewModel.BaseViewModel

import javax.inject.Inject

/**
 * ViewModel of [ritwik.samples.spacex.ui.activity.MainActivity].
 *
 * @param repository Instance of [MainRepository] for [repository].
 * @param model Instance of [MainModel] for [model].
 * @author Ritwik Jamuar
 */
class MainViewModel @Inject constructor(
    override val repository: MainRepository,
    override val model: MainModel
) : BaseViewModel<MainRepository, MainModel>() {

    /*--------------------------------- BaseViewModel Callbacks ----------------------------------*/

    override fun initializeLiveData() = Unit

    override fun initializeVariables() = Unit

    override fun onSessionExpired() = Unit

}
