package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseFragment

/**[Fragment] to showcase all the types of Rockets used by SpaceX..
 * @author Ritwik Jamuar.*/
class VehicleFragment : BaseFragment () {
	// Listeners.
	private var listener : Listener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {

		/**Factory method to create a new instance of [VehicleFragment].
		 * @return A new instance of [VehicleFragment].*/
		@JvmStatic
		fun create () = VehicleFragment ()

	}

	/*---------------------------------- BaseFragment Callbacks ----------------------------------*/

	override fun getLayoutRes () : Int = R.layout.fragment_vehicle

	override fun initializeViews ( view : View ) {
		// TODO : Add Code related to initialization of Views associated with this Fragment.
	}

	override fun setListener ( context : Context ) {
		if ( context is Listener ) {
			listener = context
		} else {
			throw RuntimeException ( "$context must implement Listener" )
		}
	}

	override fun cleanUp () {
		listener = null
	}

	override fun tag () : String = VehicleFragment::class.java.simpleName

	override fun isDataBinding () : Boolean = false

	override fun applyBinding (
		inflater : LayoutInflater,
		container : ViewGroup?,
		savedInstanceState : Bundle? )
		: View? = null

	/*---------------------------------------- Interfaces ----------------------------------------*/

	/**Interface that acts as a Listener for [VehicleFragment] to whoever implements it.*/
	interface Listener {
		/**Gets the [FragmentManager] from [android.app.Activity].
		 * @return Instance of [FragmentManager] from the parent [android.app.Activity].*/
		fun getFMFromActivity () : FragmentManager
	}
}
