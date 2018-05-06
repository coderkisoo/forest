package cn.kisoo.forest.ui

import android.content.Intent
import com.jude.beam.bijection.BeamFragment
import com.jude.beam.bijection.Presenter

abstract class BaseFragment<T : Presenter<*>> : BeamFragment<T>() {

    fun startActivity(clazz: Class<*>) {
        startActivity(Intent(activity, clazz))
    }

}