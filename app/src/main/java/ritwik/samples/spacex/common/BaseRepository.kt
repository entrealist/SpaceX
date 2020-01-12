package ritwik.samples.spacex.common

import kotlinx.coroutines.Job

import ritwik.samples.spacex.application.database.RESTServices

/**Base Repository that abstracts the common set-up of a Repository.
 * @author Ritwik Jamuar.*/
abstract class BaseRepository(
    private val restServices: RESTServices
) {

    // Job.
    private val completableJob : Job = Job()

    /*-------------------------------------- Public Methods --------------------------------------*/

    /**Cancels any pending [Job].*/
    fun cancelAllJobs() {
        completableJob.cancel()
    }

    /*------------------------------------- Protected Methods ------------------------------------*/

    /**Provides the Retrofit's REST Client Interface.
     * @return Instance of [RESTServices].*/
    protected fun getRESTServices() = restServices

    /**Provides the Completable Job that implementing Repository can use it.
     * @return Instance of [Job].*/
    protected fun getJob() = completableJob

}