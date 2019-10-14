package ru.divizdev.kamazometer.presentation.orderSearch.ui

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_order_search.*
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.osmdroid.bonuspack.routing.OSRMRoadManager
import org.osmdroid.bonuspack.routing.RoadManager
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.gridlines.LatLonGridlineOverlay.*
import ru.divizdev.kamazometer.R


class OrderSearchFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_order_search, container, false)
    }

    private val carPoint = GeoPoint(55.664023, 37.469701)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ctx = context
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        map.setTileSource(TileSourceFactory.MAPNIK)
        showSearchForm()
    }

    fun showSearchForm() {
        text_message.visibility = View.VISIBLE
        button_accept.visibility = View.GONE
        button_cancel.visibility = View.GONE
        textViewDateStart.visibility = View.GONE
        textViewDateEnd.visibility = View.GONE
        textViewIdOrder.visibility = View.GONE
        textViewSum.visibility = View.GONE
        textViewTimeStart.visibility = View.GONE
        textViewTimeEnd.visibility = View.GONE
        textView10.visibility = View.GONE
        progress_bar.isIndeterminate = true



        val mapController = map.controller
        mapController.setZoom(16.0)
        mapController.setCenter(carPoint)

        addMarker(carPoint.latitude, carPoint.longitude, R.drawable.ic_compass, 0.5f, 0.5f)

        launch {
            delay(5000)
            launch(UI) {
                if (map != null) {
                    onChoiceOrdering()
                }
            }
        }
    }

    var coSearch: Job? = null
    val startPoint = GeoPoint(55.719358, 37.708338)
    val endPoint = GeoPoint(56.159158, 40.411504)
    private fun onChoiceOrdering() {

        showOrder()

        coSearch = launch {
            for (i in 1..500) {
                delay(100)
                launch(UI) {
                    progress_bar?.progress = progress_bar?.progress?.minus(2) ?: 0
                }
            }
            progress_bar?.let {
                showSearchForm()
            }
        }
    }

    private fun showFindOrder() {
        progress_bar.isIndeterminate = true
    }

    private fun showOrder() {
        progress_bar.isIndeterminate = false
        progress_bar.max = 1000
        progress_bar.progress = 1000
        text_message.visibility = View.GONE
        button_accept.visibility = View.VISIBLE
        button_cancel.visibility = View.VISIBLE
        textViewDateStart.visibility = View.VISIBLE
        textViewDateEnd.visibility = View.VISIBLE
        textViewIdOrder.visibility = View.VISIBLE
        textViewSum.visibility = View.VISIBLE
        textViewTimeStart.visibility = View.VISIBLE
        textViewTimeEnd.visibility = View.VISIBLE
        textView10.visibility = View.VISIBLE


        val mapController = map.controller
        mapController.setZoom(8.5)
        mapController.setCenter(GeoPoint(55.887934, 38.893470))


        map.overlays.clear()
        val roadManager = OSRMRoadManager(context)

        val waypoints = ArrayList<GeoPoint>()


//        waypoints.add(carPoint)
        waypoints.add(startPoint)
        waypoints.add(endPoint)

        //enables this opt in feature
        Marker.ENABLE_TEXT_LABELS_WHEN_NO_IMAGE = true;
//        addMarker(55.667675, 37.464180, R.drawable.ic_target_start)
//        addMarker(55.663685, 37.464190, R.drawable.ic_finish_flag)
        addMarker(startPoint.latitude, startPoint.longitude, R.drawable.ic_target, 0.5f, 1f)
//        addMarker(55.665575, 37.464180, R.drawable.ic_home_blue)
        addMarker(endPoint.latitude, endPoint.longitude, R.drawable.ic_checkered_flag)
        addMarker(carPoint.latitude, carPoint.longitude, R.drawable.ic_compass, 0.5f, 0.5f)

        launch {

            val road = roadManager.getRoad(waypoints)
            val roadOverlay = RoadManager.buildRoadOverlay(road)
            roadOverlay.width = 12f

            launch(UI) {
                map.overlays.add(roadOverlay)
                map.invalidate();
            }
        }

        coSearch?.cancel()
        button_accept.setOnClickListener {
            showNavigator()
        }

        button_cancel.setOnClickListener {
            showSearchForm()
        }
    }

    private fun showNavigator() {
        header.visibility = View.VISIBLE
        footer.visibility = View.GONE

        map.overlays.clear()
        val roadManager = OSRMRoadManager(context)

        val waypoints = ArrayList<GeoPoint>()

        val mapController = map.controller
        mapController.setZoom(18.0)
        mapController.setCenter(carPoint)


        waypoints.add(carPoint)
        waypoints.add(startPoint)
        waypoints.add(endPoint)

        //enables this opt in feature
        Marker.ENABLE_TEXT_LABELS_WHEN_NO_IMAGE = true;
//        addMarker(55.667675, 37.464180, R.drawable.ic_target_start)
//        addMarker(55.663685, 37.464190, R.drawable.ic_finish_flag)
        addMarker(startPoint.latitude, startPoint.longitude, R.drawable.ic_target, 0.5f, 1f)
//        addMarker(55.665575, 37.464180, R.drawable.ic_home_blue)
        addMarker(endPoint.latitude, endPoint.longitude, R.drawable.ic_checkered_flag)
        addMarker(carPoint.latitude, carPoint.longitude, R.drawable.ic_compass, 0.5f, 0.5f)

        launch {

            val road = roadManager.getRoad(waypoints)
            val roadOverlay = RoadManager.buildRoadOverlay(road)
            roadOverlay.width = 17f

            launch(UI) {
                map.overlays.add(roadOverlay)
                map.invalidate();
            }
        }

    }

    fun addMarker(aLatitude: Double, aLongitude: Double, idIcon: Int, anchorU: Float = 0f, anchorV: Float = 1f) {
        val m = Marker(map)
        m.textLabelBackgroundColor = backgroundColor
        m.textLabelFontSize = fontSizeDp.toInt()
        m.textLabelForegroundColor = fontColor
        m.title = "hello world"
        //must set the icon to null last
        m.icon = resources.getDrawable(idIcon)
        m.position = GeoPoint(aLatitude, aLongitude)
        m.setAnchor(anchorU, anchorV)
        map.overlays.add(m)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

    }


    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }


}
