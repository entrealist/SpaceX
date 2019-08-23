package ritwik.samples.spacex.application.di.modules

import android.content.Context

import com.jakewharton.picasso.OkHttp3Downloader

import com.squareup.picasso.Picasso

import dagger.Module
import dagger.Provides

import okhttp3.OkHttpClient

import ritwik.samples.spacex.application.di.scopes.AppScope
import ritwik.samples.spacex.application.di.scopes.ApplicationContext

/**[Module] for providing [Picasso].
 * @author Ritwik Jamuar*/
@Module ( includes = [ NetworkModule::class, ContextModule::class ] )
class PicassoModule {
	/**[Provides] Method for providing the instance of [Picasso],
	 * @param context [Context] of Application (as evident from [ApplicationContext]).
	 * @param downloader Instance of [OkHttp3Downloader].
	 * @return Instance of [Picasso].*/
	@AppScope
	@Provides
	fun providesPicasso (
		@ApplicationContext context : Context,
		downloader : OkHttp3Downloader
	) : Picasso {
		return Picasso
			.Builder ( context ) // Specify the context from which Picasso will be instantiated.
			.downloader ( downloader ) // Set the OkHttp3Downloader
			.build ()
	}

	/**[Provides] Method for providing the instance of [OkHttp3Downloader].
	 * @param client Instance of [OkHttpClient].
	 * @return Instance of [OkHttp3Downloader].*/
	@AppScope
	@Provides
	fun providesOkHttp3Downloader ( client : OkHttpClient ) : OkHttp3Downloader {
		return OkHttp3Downloader ( client )
	}
}