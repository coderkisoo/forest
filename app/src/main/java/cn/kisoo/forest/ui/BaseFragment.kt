package cn.kisoo.forest.ui

import android.content.Intent
import android.support.v4.app.FragmentActivity
import com.jude.beam.bijection.BeamFragment
import com.jude.beam.bijection.Presenter

abstract class BaseFragment<T : Presenter<*>> : BeamFragment<T>() {

    fun startActivity(clazz: Class<*>) {
        startActivity(Intent(activity, clazz))
    }

    fun context(): FragmentActivity? {
        return activity
    }

}