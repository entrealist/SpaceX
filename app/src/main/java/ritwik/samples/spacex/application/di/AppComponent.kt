package ritwik.samples.spacex.application.di

import com.squareup.picasso.Picasso

import dagger.Component

import ritwik.samples.spacex.application.database.RESTServices

import ritwik.samples.spacex.application.di.modules.PicassoModule
import ritwik.samples.spacex.application.di.modules.RESTModule

import ritwik.samples.spacex.application.di.scopes.AppScope

/**[Component] for providing the common libraries that will be used throughout the application.
 * @author Ritwik Jamuar*/
@AppScope
@Component (
	modules = [
		RESTModule::class,
		PicassoModule::class
	]
) interface AppComponent {

	/**Provides the instance of [RESTServices].
	 * @return Instance of [RESTServices]*/
	fun getRESTServices () : RESTServices

	/**Provides the instance of [Picasso].
	 * @return Instance of [Picasso]*/
	fun getPicasso () : Picasso

}