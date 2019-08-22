package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import ritwik.samples.spacex.R

/**[Fragment] to showcase all the rocket launches of SpaceX.
 * @author Ritwik Jamuar*/
class LaunchesFragment : Fragment() {
	// Listeners.
	private var listener : Listener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {
		@JvmStatic
		fun newInstance () =
			LaunchesFragment ()
				.apply {
					arguments = Bundle ()
				}
	}

	/*------------------------------------ Fragment Callbacks ------------------------------------*/

	override fun onCreateView (
		inflater : LayoutInflater,
		container : ViewGroup?,
		savedInstanceState : Bundle?
	) : View? {
		// Inflate the layout for this fragment
		return inflater.inflate ( R.layout.fragment_launches, container, false )
	}

	override fun onAttach ( context : Context ) {
		super.onAttach ( context )
		if ( context is Listener ) {
			listener = context
		} else {
			throw RuntimeException ( "$context must implement Listener" )
		}
	}

	override fun onDetach () {
		super.onDetach ()
		listener = null
	}

	/*---------------------------------------- Interfaces ----------------------------------------*/

	// TODO : Add Implementation to get the Fragment Manager from Activity.
	interface Listener {}
}