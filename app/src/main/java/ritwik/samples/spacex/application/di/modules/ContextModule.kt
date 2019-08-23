package ritwik.samples.spacex.application.di.modules

import android.content.Context

import dagger.Module
import dagger.Provides

import ritwik.samples.spacex.application.di.scopes.AppScope
import ritwik.samples.spacex.application.di.scopes.ApplicationContext

/**<p>[Module] for providing the different instance of [Context] to [NetworkModule].</p>
 * <p>In Android Application, the whole application has two context:</p>
 * <ol>
 *     <li>Activity Context</li>
 *     <li>Application Context</li>
 * </ol>
 * @param context [Context] Context for initialization.
 * @author Ritwik Jamuar*/
@Module
class ContextModule ( private val context : Context ) {
	/**[Provides] Method for providing instance of Context.
	 * @return [Context] of Activity.*/
	@AppScope
	@Provides
	fun providesContext () : Context {
		return context
	}

	/**[Provides] Method for providing instance of Context.
	 * @return [Context] of Application.*/
	@ApplicationContext
	@Provides
	fun providesApplicationContext () : Context {
		return context.applicationContext
	}
}