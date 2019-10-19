package ritwik.samples.spacex.application.di.modules

import dagger.Module
import dagger.Provides

import retrofit2.Retrofit

import ritwik.samples.spacex.application.database.RESTServices

import ritwik.samples.spacex.application.di.scopes.AppScope

/**[Module] for providing instance of [RESTServices].
 * @author Ritwik Jamuar*/
@Module (
	includes = [
		RetrofitModule::class
	]
) class RESTModule {

	/**[Provides] Method for providing instance of [RESTServices].
	 * @param retrofit [Retrofit] Instance configured in [RetrofitModule].
	 * @return Instance of [RESTServices].]*/
	@AppScope
	@Provides
	fun providesRESTServices ( retrofit : Retrofit ) : RESTServices =
		retrofit.create ( RESTServices::class.java )

}