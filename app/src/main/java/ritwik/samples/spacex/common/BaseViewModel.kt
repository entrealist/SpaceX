package ritwik.samples.spacex.common

import androidx.lifecycle.ViewModel

/**Base ViewModel that abstracts the common set-up for a [ViewModel].
 * @param Repository Data Provider of the implementing [ViewModel].
 * @author Ritwik Jamuar.*/
abstract class BaseViewModel<Repository: BaseRepository> (
    private val repository: Repository
) : ViewModel() {

    /*------------------------------------ ViewModel Callbacks -----------------------------------*/

    override fun onCleared() {

        super.onCleared()

        // Cancel all the Pending Jobs in Repository.
        // This is done in order to prevent future callbacks from any Data Providers
        // present in Repository.
        // If we get any future Callback, then the app will crash, since the listener to that
        // Callback no longer exists.
        repository.cancelAllJobs()

    }

    /*------------------------------------- Protected Methods ------------------------------------*/

    /**Provides the Repository of the implementing [ViewModel].
     * @return Instance of [Repository].*/
    protected fun getRepository(): Repository = repository

}