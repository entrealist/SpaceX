package ritwik.samples.spacex.mvvm.repository

import com.squareup.moshi.Moshi

import ritwik.samples.spacex.components.network.RESTInterface

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
) : BaseRepository()
