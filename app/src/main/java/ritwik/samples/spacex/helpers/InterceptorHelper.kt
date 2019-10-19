package ritwik.samples.spacex.helpers

import okhttp3.CacheControl
import okhttp3.Interceptor

import okhttp3.logging.HttpLoggingInterceptor

import ritwik.samples.spacex.BuildConfig

import ritwik.samples.spacex.utilities.printLog

import java.util.concurrent.TimeUnit

/**Helper Class to encapsulate the varieties of [Interceptor] to be used by [okhttp3.OkHttpClient].
 * @author Ritwik Jamuar.*/
class InterceptorHelper {

	// Constants.
	private val tag = InterceptorHelper::class.java.simpleName

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {

		/**Use this Factory method to create the instance of this class.
		 * @return New Instance of [InterceptorHelper].*/
		fun create () : InterceptorHelper {
			return InterceptorHelper ()
		}

	}

	/*--------------------------------------- Interceptors ---------------------------------------*/

	/**[Interceptor] for handling Online Requests with Cache Options.*/
	private val cacheInterceptor = Interceptor {

		chain ->
		var request = chain.request ()

		// Add Cache Control.
		val cacheControl : CacheControl =
			CacheControl
				.Builder ()
				.maxAge ( 5, TimeUnit.MINUTES ) // Set Maximum Age for Cache.
				.maxStale ( 5, TimeUnit.MINUTES ) // Set Maximum Stale Age for Cache.
				.build ()

		// Modify Request with Cache Control.
		request = request.newBuilder ().cacheControl ( cacheControl ).build ()

		// Proceed with the Request.
		chain.proceed ( request )

	}

	/*-------------------------------------- Public Methods --------------------------------------*/

	/**Provides the Instance of Cache Interceptor.
	 * @return Instance of [cacheInterceptor].*/
	fun getCacheInterceptor () : Interceptor { return cacheInterceptor }

	/**Provides instance of [HttpLoggingInterceptor].
	 * [HttpLoggingInterceptor] is to be used by [okhttp3.OkHttpClient] for HTTP Interception.
	 * @return Instance of [HttpLoggingInterceptor].*/
	fun getLoggingInterceptor () : HttpLoggingInterceptor {

		// Initialize the HTTP Logging Interceptor with Lambda Expression
		// to print every log messages in the Network
		val loggingInterceptor = HttpLoggingInterceptor {
			printLog ( tag, it )
		}

		// Set the Level of Logging to BODY so that all the information about request and
		// response is shown.
		loggingInterceptor.level = when {
			BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
			else -> HttpLoggingInterceptor.Level.NONE
		}

		return loggingInterceptor

	}

}