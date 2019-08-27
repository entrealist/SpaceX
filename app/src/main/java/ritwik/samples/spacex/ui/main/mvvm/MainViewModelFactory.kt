package ritwik.samples.spacex.ui.main.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**Factory provider of [MainViewModel].
 * @author Ritwik Jamuar.*/
class MainViewModelFactory (
	private val repository : MainRepository
) : ViewModelProvider.NewInstanceFactory () {
	/*--------------------- ViewModelProvider.NewInstanceFactory () Callbacks --------------------*/

	@Suppress ( "UNCHECKED_CAST" )
	override fun < T : ViewModel? > create ( modelClass : Class < T > ) : T {
		// Provide the instance of ViewModel from here.,
		return MainViewModel (
			repository = this.repository
		) as T
	}
}