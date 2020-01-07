package ritwik.samples.spacex.ui.main.fragments.adapters

import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ritwik.samples.spacex.R

/**
 * A simple [Fragment] subclass.
 */
class CapsulesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_capsules, container, false)
    }

}