package ritwik.samples.spacex.application.di.modules

import dagger.Module
import dagger.Provides

import okhttp3.Cache
import okhttp3.OkHttpClient

import ritwik.samples.spacex.application.di.scopes.AppScope

import ritwik.samples.spacex.helpers.InterceptorHelper

/**[Module] for providing the instance of [OkHttpClient] and [Cache] to [RetrofitModule].
 * @author Ritwik Jamuar*/
@Module (
	includes = [
		CacheModule::class,
		InterceptorModule::class
	]
) class NetworkModule {

	/**[Provides] Method for providing instance of [OkHttpClient].
	 * [OkHttpClient] is to be used by [retrofit2.Retrofit] as it's HTTP Client.
	 * @param interceptorHelper [InterceptorHelper] that provides different Network Interceptors.
	 * @param cache [Cache] for storing Network Cache.
	 * @return Instance of [OkHttpClient].*/
	@AppScope
	@Provides
	fun providesOkHTTPClient (
		interceptorHelper : InterceptorHelper,
		cache : Cache
	) : OkHttpClient =
		OkHttpClient
			.Builder ()
			.addInterceptor ( interceptorHelper.getLoggingInterceptor () ) // Set the HTTP Logging Interceptor.
			.addNetworkInterceptor ( interceptorHelper.getCacheInterceptor () )
			.cache ( cache ) // Set the Cache.
			.build ()

}