package ritwik.samples.spacex.ui.main.mvvm

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**Factory provider of [MainViewModel].
 * @author Ritwik Jamuar.*/
class MainViewModelFactory (
	private val repository : MainRepository,
	private val observer : Observer < MainModel >
) : ViewModelProvider.NewInstanceFactory () {
	/*--------------------- ViewModelProvider.NewInstanceFactory () Callbacks --------------------*/

	@Suppress ( "UNCHECKED_CAST" )
	override fun < T : ViewModel? > create (modelClass : Class < T > ) : T {
		return MainViewModel (
			// Provide the instance of ViewModel from here.
			MainModel ( null ),
			repository = this.repository,
			observer = this.observer ) as T
	}
}