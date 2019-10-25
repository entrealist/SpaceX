package ritwik.samples.spacex.ui.main.fragments

import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.Observer

import androidx.recyclerview.widget.RecyclerView

import ritwik.samples.spacex.R

import ritwik.samples.spacex.common.BaseFragment

import ritwik.samples.spacex.components.adapters.CapsuleListAdapter

import ritwik.samples.spacex.pojo.capsules.Capsule

/**[androidx.fragment.app.Fragment] to show the list of all the Capsules used by SpaceX.
 * @author Ritwik Jamuar.*/
class CapsuleListFragment : BaseFragment () {

	// Views.
	private var recyclerView : RecyclerView? = null

	// Adapters.
	private var adapter : CapsuleListAdapter? = null

	// Listeners.
	private var listener : Listener? = null

	/*------------------------------------- Companion Object -------------------------------------*/

	companion object {

		/**Factory method to create a new instance of [CapsuleListFragment].
		 * @return A new instance of [CapsuleListFragment].*/
		@JvmStatic
		fun create () = CapsuleListFragment ()

	}

	/*----------------------------------------- Observers ----------------------------------------*/

	private val allCapsulesObserver = Observer < List < Capsule > > {
		adapter?.replaceCapsuleList ( it )
	}

	/*---------------------------------- BaseFragment Callbacks ----------------------------------*/

	override fun getLayoutRes () : Int = R.layout.fragment_capsule_list

	override fun initializeViews ( view : View ) {
		initializeRecyclerView ( view )
		attachObservers ()
		getCapsules ()
	}

	override fun setListener ( context : Context) {
		if ( context is Listener ) {
			listener = context
		} else {
			throw RuntimeException ( "$context must implement Listener" )
		}
	}

	override fun cleanUp () {
		listener = null
		recyclerView = null
		adapter = null
	}

	override fun tag () : String = CapsuleListFragment::class.java.simpleName

	override fun isDataBinding () : Boolean = false

	override fun applyBinding (
		inflater : LayoutInflater,
		container : ViewGroup?,
		savedInstanceState : Bundle?
	) : View? = null

	/*-------------------------------------- Private Methods -------------------------------------*/

	private fun initializeRecyclerView ( view : View ) {
		recyclerView = view.findViewById ( R.id.fragment_capsule_list_recycler_view )

		listener?.let { listener ->
			adapter = CapsuleListAdapter ( listener.getVM () )
		}

		recyclerView?.adapter = adapter
	}

	private fun attachObservers () {
		listener?.getVM ()?.allCapsulesLiveData?.observe (this, allCapsulesObserver )
	}

	private fun getCapsules () {
		listener?.getVM ()?.getCapsules ()
	}

	/*---------------------------------------- Interfaces ----------------------------------------*/

	/**Interface that acts as a Listener for [CapsuleListFragment] to whoever implements it.*/
	interface Listener : MainFragmentListener

}