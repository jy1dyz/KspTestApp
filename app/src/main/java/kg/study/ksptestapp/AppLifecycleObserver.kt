package kg.study.ksptestapp

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class AppLifecycleObserver: DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.w("TAG", "App in on start")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.w("TAG", "App in on stop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.w("TAG", "App in on destroy")
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.w("TAG", "App in on create")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.w("TAG", "App in on resume")
    }

}