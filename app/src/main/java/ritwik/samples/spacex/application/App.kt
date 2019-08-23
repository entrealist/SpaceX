package ritwik.samples.spacex.application

import android.app.Activity
import android.app.Application

import ritwik.samples.spacex.application.di.AppComponent
import ritwik.samples.spacex.application.di.DaggerAppComponent

import ritwik.samples.spacex.application.di.modules.ContextModule

class App : Application () {
	// Components.
	private lateinit var appComponent : AppComponent

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {
		lateinit var instance: App private set

		fun getInstance ( activity : Activity ) : App {
			return activity.application as App
		}
	}

	/*----------------------------------- Application Callbacks ----------------------------------*/

	override fun onCreate () {
		super.onCreate ()
		instance = this
		initializeAppComponent ()
	}

	/*-------------------------------------- Private Methods -------------------------------------*/

	private fun initializeAppComponent () {
		appComponent = DaggerAppComponent
			.builder ()
			.contextModule ( ContextModule ( this ) )
			.build ()
	}

	/*-------------------------------------- Public Methods --------------------------------------*/

	fun getAppComponent () : AppComponent {
		return appComponent
	}

}