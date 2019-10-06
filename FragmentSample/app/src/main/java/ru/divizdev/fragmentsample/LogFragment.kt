package ru.divizdev.fragmentsample

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

abstract class LogFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("lifecycle " + this.javaClass.name, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("lifecycle " + this.javaClass.name, "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        Log.i("lifecycle " + this.javaClass.name, "onAttach")
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i("lifecycle " + this.javaClass.name, "onActivityCreated")

        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        Log.i("lifecycle " + this.javaClass.name, "onResume")

        super.onResume()
    }

    override fun onPause() {
        Log.i("lifecycle " + this.javaClass.name, "onPause")
        super.onPause()
    }
}