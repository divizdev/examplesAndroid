package ru.divizdev.kamazometer.presentation.main.ui

import android.util.Log
import androidx.work.Worker
import java.util.concurrent.TimeUnit

class MyWorker : Worker() {

    override fun doWork(): Result {
        Log.d(TAG, "doWork: start")

        try {
            for (i in 0..0) {
                TimeUnit.SECONDS.sleep(10)
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: end")

        return Result.SUCCESS
    }

    companion object {

        internal val TAG = "workmng"
    }
}