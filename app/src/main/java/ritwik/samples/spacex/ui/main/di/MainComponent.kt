package ritwik.samples.spacex.ui.main.di

import dagger.Component

import ritwik.samples.spacex.ui.main.MainActivity

/**[Component] for providing [ritwik.samples.spacex.ui.main.mvvm.MainViewModel] to [MainActivity].
 * @author Ritwik Jamuar*/
@Component ( modules = [ MainModule::class ] )
@MainScope
interface MainComponent {
	/**Injects the [MainActivity] onto [MainModule] for dependency fulfillment.
	 * @param activity Instance of [MainActivity]*/
	fun injectActivity ( activity : MainActivity )
}