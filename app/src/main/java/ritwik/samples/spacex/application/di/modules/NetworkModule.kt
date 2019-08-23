package ritwik.samples.spacex.application.di.modules

import dagger.Module
import dagger.Provides

import okhttp3.Cache
import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor

import ritwik.samples.spacex.application.di.scopes.AppScope

/**[Module] for providing the instance of [OkHttpClient] and [Cache] to [RetrofitModule].
 * @author Ritwik Jamuar*/
@Module ( includes = [ ContextModule::class, CacheModule::class ] )
class NetworkModule {
	private val tag : String = "Network"

	/**[Provides] Method for providing instance of [HttpLoggingInterceptor].
	 * [HttpLoggingInterceptor] is to be used by [OkHttpClient] for HTTP Interception.
	 * @return Instance of [HttpLoggingInterceptor].*/
	@AppScope
	@Provides
	fun providesHTTPLoggingInterceptor () : HttpLoggingInterceptor {
		// Initialize the HTTP Logging Interceptor with Lambda Expression to print every log
		// messages in the Network
		val loggingInterceptor = HttpLoggingInterceptor {
			printLog ( it )
		}

		// Set the Level of Logging to BODY so that all the information about request and
		// response is shown.
		// TODO : Change the Logging Level to NONE at the time of application publishing to Play
		//  Store so that no network logs are shown in Logcat.
		loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

		return loggingInterceptor
	}

	/**[Provides] Method for providing instance of [OkHttpClient].
	 * [OkHttpClient] is to be used by [retrofit2.Retrofit] as it's HTTP Client.
	 * @param loggingInterceptor [HttpLoggingInterceptor] for HTTP Interception.
	 * @param cache [Cache] for storing Network Cache.
	 * @return Instance of [OkHttpClient].*/
	@AppScope
	@Provides
	fun providesOkHTTPClient (
		loggingInterceptor : HttpLoggingInterceptor,
		cache : Cache
	) : OkHttpClient {
		return OkHttpClient
			.Builder ()
			.addInterceptor ( loggingInterceptor ) // Set the HTTP Logging Interceptor.
			.cache ( cache ) // Set the Cache.
			.build ()
	}

	/**Prints the Log to Logcat.
	 * @param message [String] containing the message to be displayed.*/
	private fun printLog ( message : String? ) {
		android.util.Log.e ( tag, message )
	}
}