package ritwik.samples.spacex.application.di.modules

import dagger.Module
import dagger.Provides

import ritwik.samples.spacex.application.di.scopes.AppScope

import ritwik.samples.spacex.helpers.InterceptorHelper

/**[Module] for providing the instance of [InterceptorHelper].
 * @author Ritwik Jamuar.*/
@Module
class InterceptorModule {

	/**[Provides] Method for providing instance of [InterceptorHelper].
	 * @return Instance of [InterceptorHelper].*/
	@AppScope
	@Provides
	fun providesInterceptorHelper () : InterceptorHelper = InterceptorHelper.create ()

}