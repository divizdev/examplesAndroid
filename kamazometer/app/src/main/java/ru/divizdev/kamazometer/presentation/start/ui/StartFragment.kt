package ru.divizdev.kamazometer.presentation.start.ui

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_start.*
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.gridlines.LatLonGridlineOverlay
import ru.divizdev.kamazometer.R
import ru.divizdev.kamazometer.presentation.entities.getTrucks
import ru.divizdev.kamazometer.presentation.listTruck.adapter.ListTruckAdapter
import ru.divizdev.kamazometer.presentation.orderSearch.ui.OrderSearchFragment


class StartFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    private val carPoint = GeoPoint(55.662016, 37.469518)
    fun addMarker(aLatitude: Double, aLongitude: Double, idIcon: Int, anchorU: Float = 0f, anchorV: Float = 1f) {
        val m = Marker(map)
        m.textLabelBackgroundColor = LatLonGridlineOverlay.backgroundColor
        m.textLabelFontSize = LatLonGridlineOverlay.fontSizeDp.toInt()
        m.textLabelForegroundColor = LatLonGridlineOverlay.fontColor
        m.title = "hello world"
        //must set the icon to null last
        m.icon = resources.getDrawable(idIcon)
        m.position = GeoPoint(aLatitude, aLongitude)
        m.setAnchor(anchorU, anchorV)
        map.overlays.add(m)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val linearLayout = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        list_truck.layoutManager = linearLayout
        list_truck.adapter = ListTruckAdapter(getTrucks())
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(list_truck)

        button_start.setOnClickListener {
            //            Toast.makeText(context, "Мы начали искать для Вас заказ", Toast.LENGTH_LONG).show()
            fragmentManager!!.beginTransaction().replace(R.id.fragment_container, OrderSearchFragment()).commit()
        }


        val ctx = context
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        map.setTileSource(TileSourceFactory.MAPNIK)
        val mapController = map.controller
        mapController.setZoom(16.0)
        mapController.setCenter(carPoint)

        addMarker(carPoint.latitude, carPoint.longitude, R.drawable.ic_compass, 0.5f, 0.5f)

        super.onViewCreated(view, savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

    }


}
