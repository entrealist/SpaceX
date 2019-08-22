package ritwik.samples.spacex.ui.main

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.FragmentManager

import ritwik.samples.spacex.R

import ritwik.samples.spacex.ui.main.fragments.LaunchesFragment

class MainActivity
	: AppCompatActivity (),
	LaunchesFragment.Listener {

	/*----------------------------------- Activity Callbacks -------------------------------------*/

	override fun onCreate ( savedInstanceState : Bundle? ) {
		super.onCreate ( savedInstanceState )
		setContentView ( R.layout.activity_main )
	}

	/*---------------------------- LaunchesFragment.Listener Callbacks ---------------------------*/

	override fun getFMFromActivity () : FragmentManager {
		return supportFragmentManager
	}
}