package ritwik.samples.spacex.mvvm.viewModel

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import ritwik.samples.spacex.mvvm.model.LauncherModel

import ritwik.samples.spacex.mvvm.repository.LauncherRepository

import ritwik.samples.spacex.utility.constant.NAVIGATE_TO_MAIN

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

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**
     * Handles the starting stage of the activity.
     */
    fun onStarted() {
        mainThreadScope.launch { // Launch the Main Thread Co-Routine.
            delay(3000) // Make a delay of 3 seconds.
            notifyActionOnUI(NAVIGATE_TO_MAIN) // Notify the UI to navigate to MainActivity.
        }
    }

}
