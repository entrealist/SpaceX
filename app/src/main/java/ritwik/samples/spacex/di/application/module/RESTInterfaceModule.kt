package ritwik.samples.spacex.di.application.module

import dagger.Module
import dagger.Provides

import retrofit2.Retrofit

import ritwik.samples.spacex.components.network.RESTInterface

import sample.ritwik.common.di.AppScope

/**
 * [Module] for providing [RESTInterface].
 *
 * @author Ritwik Jamuar
 */
@Module
class RESTInterfaceModule {

    /**
     * Provides the instance of [RESTInterface].
     *
     * @param retrofit Instance of [Retrofit] from [sample.ritwik.common.di.module.RetrofitModule].
     * @return New Instance of [RESTInterface].
     */
    @AppScope
    @Provides
    fun providesRESTInterface(retrofit: Retrofit): RESTInterface =
        retrofit.create(RESTInterface::class.java)

}
