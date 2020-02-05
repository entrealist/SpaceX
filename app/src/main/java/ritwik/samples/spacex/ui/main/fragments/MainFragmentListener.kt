package ritwik.samples.spacex.ui.main.fragments

import androidx.fragment.app.FragmentManager
import com.squareup.picasso.Picasso

import ritwik.samples.spacex.ui.main.mvvm.MainViewModel

/**Base Interface to be implemented by the Fragment's interface Listener, which will eventually
 * be implemented in [ritwik.samples.spacex.ui.main.MainActivity].
 * @author Ritwik Jamuar.*/
interface MainFragmentListener {

	/**Tells the implementing [android.app.Activity] to provide it's [androidx.lifecycle.ViewModel].
	 * @return Reference of [MainViewModel].*/
	fun getVM () : MainViewModel

	/**Tells the implementing [android.app.Activity] to provide it's [FragmentManager].
	 * @return Reference of [FragmentManager].*/
	fun getFMFromActivity () : FragmentManager

	/**Provides [Picasso] from attaching [android.app.Activity].
	 * @return Instance of [Picasso].*/
	fun getPicasso(): Picasso

}