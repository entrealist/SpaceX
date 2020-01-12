package ritwik.samples.spacex.ui.main.di

import androidx.lifecycle.ViewModelProviders

import dagger.Module
import dagger.Provides

import ritwik.samples.spacex.application.App

import ritwik.samples.spacex.application.database.RESTServices

import ritwik.samples.spacex.ui.main.MainActivity

import ritwik.samples.spacex.ui.main.mvvm.MainRepository
import ritwik.samples.spacex.ui.main.mvvm.MainViewModel
import ritwik.samples.spacex.ui.main.mvvm.MainViewModelFactory

/*
    DEPENDENCY GRAPH :

      MainActivity
            |
      MainViewModel
            |
   MainViewModelFactory
            |
      MainRepository
            |
       RESTServices
 */

/**[Module] for providing [MainViewModel] to [MainActivity].
 * @author Ritwik Jamuar*/
@Module
class MainModule (
	private val activity : MainActivity
) {
	/*-------------------------------- MainActivity Dependencies ---------------------------------*/

	@Provides
	@MainScope
	fun providesMainViewModel ( factory : MainViewModelFactory ) : MainViewModel {
		return ViewModelProviders.of(activity, factory).get(MainViewModel::class.java)
	}

	/*--------------------------------- MainViewModel Dependencies -------------------------------*/

	@Provides
	@MainScope
	fun providesMainViewModelFactory (
		repository : MainRepository
	) : MainViewModelFactory {
		return MainViewModelFactory ( repository = repository )
	}

	/*----------------------------- MainViewModelFactory Dependencies ----------------------------*/

	@Provides
	@MainScope
	fun providesMainRepository (
		restServices : RESTServices
	) : MainRepository {
		return MainRepository.create ( restServices )
	}

	/*-------------------------------- MainRepository Dependencies -------------------------------*/

	@Provides
	@MainScope
	fun providesRESTServices () : RESTServices {
		return App.getInstance ( activity ).getAppComponent ().getRESTServices ()
	}
}