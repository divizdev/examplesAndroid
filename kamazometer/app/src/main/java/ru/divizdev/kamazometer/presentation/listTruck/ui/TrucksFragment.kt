package ru.divizdev.kamazometer.presentation.listTruck.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_trucks.*
import ru.divizdev.kamazometer.R
import ru.divizdev.kamazometer.presentation.entities.getTrucks
import ru.divizdev.kamazometer.presentation.listTruck.adapter.ListTruckAdapter


class TrucksFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trucks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val linearLayout = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        trucks.layoutManager = linearLayout
        trucks.adapter = ListTruckAdapter(getTrucks())




        super.onViewCreated(view, savedInstanceState)


    }


}
