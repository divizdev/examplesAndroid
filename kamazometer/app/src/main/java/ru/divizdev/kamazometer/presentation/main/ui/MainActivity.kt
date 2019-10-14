package ru.divizdev.kamazometer.presentation.main.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import androidx.work.PeriodicWorkRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import ru.divizdev.kamazometer.R
import ru.divizdev.kamazometer.presentation.chat.ChatFragment
import ru.divizdev.kamazometer.presentation.driver.DriverFragment
import ru.divizdev.kamazometer.presentation.history.ui.HistoryFragment
import ru.divizdev.kamazometer.presentation.listTruck.ui.TrucksFragment
import ru.divizdev.kamazometer.presentation.start.ui.StartFragment
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_start -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, StartFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_driver -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, DriverFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HistoryFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_message -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ChatFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_truck -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, TrucksFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        navigation.selectedItemId = R.id.navigation_start


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, StartFragment()).commit()
        }

        val myWorkRequest = PeriodicWorkRequest.Builder(MyWorker::class.java, 15, TimeUnit.MINUTES, 15, TimeUnit.MINUTES)
                .build()
    }
}


