package ritwik.samples.spacex.application.di.modules

import dagger.Module
import dagger.Provides

import okhttp3.OkHttpClient

import retrofit2.Retrofit

import retrofit2.converter.moshi.MoshiConverterFactory

import ritwik.samples.spacex.BuildConfig

import ritwik.samples.spacex.application.di.scopes.AppScope

/**[Module] for providing instance of [Retrofit] to [RESTModule].
 * @author Ritwik Jamuar*/
@Module (
	includes = [
		NetworkModule::class
	]
) class RetrofitModule {

	/**[Provides] Method for providing instance of [Retrofit].
	 * @param client [OkHttpClient] Instance configured in [NetworkModule].
	 * @return Instance of [Retrofit]*/
	@AppScope
	@Provides
	fun providesRetrofit ( client : OkHttpClient ) : Retrofit =
		Retrofit
			.Builder ()
			.addConverterFactory ( MoshiConverterFactory.create () ) // Set the JSON Converter Factory.
			.client( client ) // Set the OkHttpClient.
			.baseUrl ( BuildConfig.BASE_URL ) // Set the Base URL.
			.build ()

}