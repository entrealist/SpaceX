package ritwik.samples.spacex.application.di.modules

import android.content.Context

import dagger.Module
import dagger.Provides

import okhttp3.Cache

import ritwik.samples.spacex.application.di.scopes.ApplicationContext

import java.io.File

/**[Module] for providing instance of [Cache] to [NetworkModule].
 * @author Ritwik Jamuar.*/
@Module
class CacheModule {
	/**[Provides] Method for providing the instance of [Cache].
	 * @param file [File] provided [providesCacheFile] which serves as [Cache] [File].
	 * @return Instance of [Cache].*/
	@Provides
	fun providesCache ( file : File ) : Cache {
		return Cache (
			file, // Specify the Cache File.
			10 * 1000 * 1000 // Specify the Maximum Size of the File.
		)
	}

	/**[Provides] Method for providing the instance of [File] that serves as Cache File.
	 * @param context [Context] of Application (as specified by [ApplicationContext]) to access
	 * the Cache Directory.
	 * @return Instance of [File].*/
	@Provides
	fun providesCacheFile ( @ApplicationContext context : Context ) : File {
		return File ( context.cacheDir, "okHTTPCache" )
	}
}