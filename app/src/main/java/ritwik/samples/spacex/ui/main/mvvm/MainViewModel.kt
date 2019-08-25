package ritwik.samples.spacex.ui.main.mvvm

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

import ritwik.samples.spacex.ui.main.MainActivity

/**ViewModel of [MainActivity].
 * @author Ritwik Jamuar.*/
class MainViewModel (
	private val model : MainModel,
	private val repository : MainRepository,
	private val observer : Observer < MainModel >
) : ViewModel () {
	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {
		/**Creates/Gets an instance of [MainViewModel].
		 * @param activity Instance of [MainActivity] : View of the [MainViewModel].
		 * @param factory Instance of [MainViewModelFactory] : Factory Provider of [MainViewModel].
		 * @return Instance of [MainViewModel] : ViewModel of [MainActivity].*/
		fun create ( activity : MainActivity, factory : MainViewModelFactory ) : MainViewModel {
			return ViewModelProviders.of ( activity, factory ).get ( MainViewModel::class.java )
		}
	}
}