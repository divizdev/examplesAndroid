package ru.divizdev.fragmentsample

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, firstFragment, "FIRST_FRAGMENT")
            .commit()


    }


}
