package ritwik.samples.spacex.ui.main.fragments

import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ritwik.samples.spacex.R

/**
 * [Fragment] that shows information about the company 'SpaceX'.
 * @author Ritwik Jamuar.
 */
class TheCompanyFragment : Fragment() {

	override fun onCreateView(
		inflater : LayoutInflater, container : ViewGroup?,
		savedInstanceState : Bundle?
	) : View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_the_company, container, false)
	}

}