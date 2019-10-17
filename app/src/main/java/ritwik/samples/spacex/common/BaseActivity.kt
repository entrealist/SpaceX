package ritwik.samples.spacex.common

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

/**Base [android.app.Activity] for abstracting common methods and automating their calls.
 * @author Ritwik Jamuar.*/
abstract class BaseActivity : AppCompatActivity () {

	/*------------------------------------ Activity Callbacks ------------------------------------*/

	override fun onCreate ( savedInstanceState : Bundle? ) {
		super.onCreate ( savedInstanceState )
		setContentView ( getLayoutRes () )
		inject ()
		initialize ()
	}

	override fun onDestroy () {
		super.onDestroy ()
		cleanUp ()
	}

	/*------------------------------------- Abstract Methods -------------------------------------*/

	/**Tells the implementing [android.app.Activity] to execute Dependency Injection.*/
	abstract fun inject ()

	/**Tells the implementing [android.app.Activity] to initialize its components.*/
	abstract fun initialize ()

	/**Fetches Resource ID of extending [android.app.Activity].
	 * Extending [android.app.Activity] should provide the Layout Resource ID.
	 * @return [Int] containing Layout Resource ID.*/
	abstract fun getLayoutRes () : Int

	/**Tells the implementing [android.app.Activity] to perform objects nullification for Garbage
	 * Collection.*/
	abstract fun cleanUp ()

}