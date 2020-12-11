package ritwik.samples.spacex.ui.activity

import android.content.Intent

import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity

import ritwik.samples.spacex.R

class LauncherActivity : AppCompatActivity () {
	// Other Components
	private var mHandler : Handler? = null
	private val mDELAY : Long = 2000

	private val mRunnable : Runnable = Runnable {
		if ( ! isFinishing ) {
			startMainActivity ()
		}
	}

	override fun onCreate ( savedInstanceState : Bundle? ) {
		setTheme ( R.style.AppTheme )
		super.onCreate ( savedInstanceState )
		setContentView ( R.layout.activity_launcher )
		initialize ()
	}

	private fun initialize () {
		mHandler = Handler ()
		mHandler!!.postDelayed ( mRunnable, mDELAY )
	}

	private fun startMainActivity () {
		val intent = Intent ( applicationContext, MainActivity::class.java )
		startActivity ( intent )
		finish ()
	}
}