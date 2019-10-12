package ru.divizdev.fragmentsample

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_second.*


class LastFragment : LogFragment() {

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_last, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_next.setOnClickListener {
            Log.i("lifecycle " + this.javaClass.name, "---button_next")
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, FirstFragment(), "FIRST_FRAGMENT")
                ?.addToBackStack("")
                ?.commit()
        }
        button_back.setOnClickListener {
            Log.i("lifecycle " + this.javaClass.name, "---button_back")
            fragmentManager?.popBackStack()
        }
        button_go_to_first.setOnClickListener {
            Log.i("lifecycle " + this.javaClass.name, "---button_go_to_first")
            val findFragmentByTag = fragmentManager?.findFragmentByTag("FIRST_FRAGMENT")
            if (findFragmentByTag != null) {
                fragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fragment_container, findFragmentByTag)
                    ?.addToBackStack("")
                    ?.commit()
            }
        }

    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            LastFragment()
    }
}
