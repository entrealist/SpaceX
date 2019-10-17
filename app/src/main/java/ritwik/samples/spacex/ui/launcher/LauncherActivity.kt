package ritwik.samples.spacex.ui.launcher

import android.content.Intent

import android.os.Handler

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseActivity

import ritwik.samples.spacex.ui.main.MainActivity

/**[Long] value specifying the delay in opening another [android.app.Activity].*/
const val mDELAY : Long = 2000

/**[android.app.Activity] to show Launcher Screen.
 * @author Ritwik Jamuar.*/
class LauncherActivity : BaseActivity () {

	// Handlers.
	private var handler : Handler? = null

	/*----------------------------------------- Runnables ----------------------------------------*/

	private val mRunnable : Runnable = Runnable {
		if ( ! isFinishing ) {
			startMainActivity ()
		}
	}

	/*---------------------------------- BaseActivity Callbacks ----------------------------------*/

	override fun inject () {}

	override fun initialize () {
		handler = Handler ()
		handler?.postDelayed ( mRunnable, mDELAY )
	}

	override fun getLayoutRes () : Int { return R.layout.activity_launcher }

	override fun cleanUp () {
		handler = null
	}

	/*------------------------------------- Private Methods --------------------------------------*/

	/**Starts the [MainActivity] and [finish] this [android.app.Activity].*/
	private fun startMainActivity () {
		val intent = Intent ( applicationContext, MainActivity::class.java )
		startActivity ( intent )
		finish ()
	}

}