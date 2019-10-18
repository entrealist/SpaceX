package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.Observer

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.pojo.rockets.Rocket

/**[androidx.fragment.app.Fragment] to showcase all the types of Rockets used by SpaceX..
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

	/*----------------------------------------- Observers ----------------------------------------*/

	/**[Observer] for observing changes in [List] of All [Rocket]s.*/
	private val allRocketsObserver = Observer < List < Rocket > > {
		// TODO : Populate the List of Rockets in the Adapter.
	}

	/*---------------------------------- BaseFragment Callbacks ----------------------------------*/

	override fun getLayoutRes () : Int = R.layout.fragment_vehicle

	override fun initializeViews ( view : View ) {
		// TODO : Add Code related to initialization of Views associated with this Fragment.
		attachObservers ()
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

	/*-------------------------------------- Private Methods -------------------------------------*/

	/**Attaches [Observer]s to this [androidx.fragment.app.Fragment].*/
	private fun attachObservers () {
		listener?.getVM ()?.allRocketsLiveData?.observe ( this, allRocketsObserver )
	}

	/*---------------------------------------- Interfaces ----------------------------------------*/

	/**Interface that acts as a Listener for [VehicleFragment] to whoever implements it.*/
	interface Listener : MainFragmentListener

}