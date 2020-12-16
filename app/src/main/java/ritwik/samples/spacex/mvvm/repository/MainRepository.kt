package ritwik.samples.spacex.mvvm.repository

import com.squareup.moshi.Moshi

import ritwik.samples.spacex.components.network.RESTInterface
import ritwik.samples.spacex.data.network.*

import sample.ritwik.common.component.persistence.DataStorePreference

import sample.ritwik.common.mvvm.repository.BaseRepository

import sample.ritwik.common.utility.helper.ResourceUtils

import javax.inject.Inject

/**
 * Repository of [ritwik.samples.spacex.mvvm.viewModel.MainViewModel].
 *
 * @param restInterface Instance of [RESTInterface] to perform REST API Calls.
 * @param dataStorePreference Instance of [DataStorePreference] to perform storing/retrieving data
 *   from Persistent Storage.
 * @param moshi Instance of [Moshi] to serialize/de-serialize any Classes.
 * @param resourceUtils Instance of [ResourceUtils] to fetch the resources existing
 *   within this Application.
 * @author Ritwik Jamuar
 */
class MainRepository @Inject constructor(
    private val restInterface: RESTInterface,
    override val dataStorePreference: DataStorePreference,
    override val moshi: Moshi,
    override val resourceUtils: ResourceUtils
) : BaseRepository() {

    /**
     * Fetches the Upcoming Launches using [restInterface].
     *
     * @return [List] of [LaunchResponse] denoting the Upcoming Launches.
     */
    suspend fun getUpcomingLaunches(): List<LaunchResponse> = restInterface.getUpcomingLaunches()

    /**
     * Fetches the Completed Launches using [restInterface].
     *
     * @return [List] of [LaunchResponse] denoting the Completed Launches.
     */
    suspend fun getCompletedLaunches(): List<LaunchResponse> = restInterface.getPastLaunches()

    /**
     * Fetches the Rockets using [restInterface].
     *
     * @return [List] of [RocketResponse] denoting all the Rockets.
     */
    suspend fun getAllRockets(): List<RocketResponse> = restInterface.getAllRockets()

    /**
     * Fetches the Capsules using [restInterface].
     *
     * @return [List] of [CapsuleResponse] denoting all the Capsules.
     */
    suspend fun getAllCapsules(): List<CapsuleResponse> = restInterface.getAllCapsules()

    /**
     * Fetches the Cores using [restInterface].
     *
     * @return [List] of [CoreResponse] denoting all the Cores.
     */
    suspend fun getAllCores(): List<CoreResponse> = restInterface.getAllCores()

    /**
     * Fetches the information about the Company using [restInterface].
     *
     * @return Instance of [CompanyResponse] encapsulating the information about the Company.
     */
    suspend fun getInfoAboutCompany(): CompanyResponse = restInterface.getInfoAboutCompany()

}
