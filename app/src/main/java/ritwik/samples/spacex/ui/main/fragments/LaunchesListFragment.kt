package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import ritwik.samples.spacex.R

/**[Fragment] to show the list of launches of SpaceX.
 * @author Ritwik Jamuar.*/
class LaunchesListFragment : Fragment () {
	// Listener.
	private var listener : Listener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {
		@JvmStatic
		fun newInstance () =
			LaunchesListFragment ()
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
		return inflater.inflate ( R.layout.fragment_launches_list, container, false )
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

	interface Listener {}
}