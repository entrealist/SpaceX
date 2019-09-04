package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import ritwik.samples.spacex.R

/**[Fragment] to showcase all the types of Rockets used by SpaceX..
 * @author Ritwik Jamuar.*/
class VehicleFragment : Fragment () {
	// Listeners.
	private var listener : Listener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {
		/**Factory method to create a new instance of [VehicleFragment].
		 * @return A new instance of [VehicleFragment].*/
		@JvmStatic
		fun newInstance () =
			VehicleFragment ()
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
		val view : View = inflater.inflate ( R.layout.fragment_vehicle, container, false )
		initializeViews ( view )
		return view
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

	/*------------------------------------- Private Methods --------------------------------------*/

	/**Instantiate the [View]s associated with this fragment.
	 * @param view Instance of [View] to get the instance of composite views.*/
	private fun initializeViews ( view : View ) {
		// TODO : Add Code related to initialization of Views associated with this Fragment.
	}

	/*---------------------------------------- Interfaces ----------------------------------------*/

	/**Interface that acts as a Listener for [VehicleFragment] to whoever implements it.*/
	interface Listener {
		/**Gets the [FragmentManager] from [android.app.Activity].
		 * @return Instance of [FragmentManager] from the parent [android.app.Activity].*/
		fun getFMFromActivity () : FragmentManager
	}
}
