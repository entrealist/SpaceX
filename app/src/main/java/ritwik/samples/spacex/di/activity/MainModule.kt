package ritwik.samples.spacex.di.activity

import com.squareup.moshi.Moshi

import dagger.Module
import dagger.Provides

import ritwik.samples.spacex.components.network.RESTInterface

import ritwik.samples.spacex.mvvm.model.MainModel

import ritwik.samples.spacex.mvvm.repository.MainRepository

import sample.ritwik.common.component.persistence.DataStorePreference

import sample.ritwik.common.utility.helper.ResourceUtils

/**
 * [Module] of [ritwik.samples.spacex.ui.activity.MainActivity].
 *
 *
 * The purpose of creating a [Module] for [ritwik.samples.spacex.ui.activity.MainActivity]
 * is to provide it's dependants, which in our case is these three things:
 * 1. [sample.ritwik.common.mvvm.viewModel.VMFactory].
 * 2. [sample.ritwik.common.utility.helper.NetworkUtils].
 * 3. [com.squareup.picasso.Picasso]
 *
 * Now out of these three, [sample.ritwik.common.utility.helper.NetworkUtils] is provided from
 * [sample.ritwik.common.di.module.CommonModule] and [com.squareup.picasso.Picasso] is provided from
 * [sample.ritwik.common.di.module.PicassoModule].
 *
 *
 * But, [sample.ritwik.common.mvvm.viewModel.VMFactory] is unique for every [android.app.Activity].
 *
 *
 * From the current architecture, every sub-class of
 * [sample.ritwik.common.mvvm.viewModel.BaseViewModel] needs to have following:
 * 1. Instance of sub-class that extends [sample.ritwik.common.mvvm.repository.BaseRepository].
 * 2. Instance of sub-class that extends [sample.ritwik.common.mvvm.model.BaseModel].
 *
 *
 * This is why we create [Module] annotated Module Class for every [android.app.Activity].
 * The purpose of this Class is to facilitate the providing of above dependencies of
 * [sample.ritwik.common.mvvm.viewModel.BaseViewModel].
 *
 * @author Ritwik Jamuar
 */
@Module
class MainModule {

    /**
     * Provides the Repository of [ritwik.samples.spacex.mvvm.viewModel.MainViewModel].
     *
     * @param restInterface Instance of [RESTInterface] fulfilled from
     *   [ritwik.samples.spacex.di.application.module.RESTInterfaceModule].
     * @param dataStorePreference Instance of [DataStorePreference] fulfilled from
     *   [sample.ritwik.common.di.module.PersistenceModule].
     * @param moshi Instance of [Moshi] fulfilled from
     *   [sample.ritwik.common.di.module.MoshiModule].
     * @param resourceUtils Instance of [ResourceUtils] fulfilled from
     *   [sample.ritwik.common.di.module.CommonModule].
     * @return New Instance of [MainRepository].
     */
    @Provides
    fun providesRepository(
        restInterface: RESTInterface,
        dataStorePreference: DataStorePreference,
        moshi: Moshi,
        resourceUtils: ResourceUtils,
    ): MainRepository = MainRepository(restInterface, dataStorePreference, moshi, resourceUtils)

    /**
     * Provides the Model of [ritwik.samples.spacex.mvvm.viewModel.MainViewModel].
     *
     * @return New Instance of [MainModel].
     */
    @Provides
    fun providesModel(): MainModel = MainModel()

}
