package ru.divizdev.rxexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private val TAG = "Thread"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testSchedulersTemplate()
    }

    fun testSchedulersTemplate() {

        val obs = Observable.create<String>{
            Log.d(TAG, "${logThread()}: Emmit")
            it.onNext("value")
//            it.onError(Throwable("Error"))
            it.onComplete()
        }


        Log.d(TAG, "--->Start main thread")
        obs.subscribe(getObserver())

//        Log.d(TAG, "--->Start subscribeOn")
//        obs.subscribeOn(Schedulers.io()).subscribe(getObserver())

//        Log.d(TAG, "--->Start subscribeOn + observeOn")
//        obs.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(getObserver())

        Log.d(TAG, "--->Start subscribeOn + observeOn + map")
        obs//.subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .observeOn(Schedulers.computation())
            .map{ Log.d(TAG, "${logThread()}: map ")
                                                "new $it" }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.single())
            .subscribe(getObserver())

    }

    private fun getObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
            }

//Every time onNext is called, print the value to Android Studio’s Logcat//

            override fun onNext(s: String) {
                Log.d(TAG, "${logThread()}: onNext: $s ")

            }

//Called if an exception is thrown//

            override fun onError(e: Throwable) {
                Log.d(TAG, "${logThread()}:  onError: " + e.message)
            }

//When onComplete is called, print the following to Logcat//

            override fun onComplete() {
                Log.d(TAG, "${logThread()}: onComplete")
                logThread()

            }
        }
    }


}


fun logThread(): String{
    return  Thread.currentThread().name


}