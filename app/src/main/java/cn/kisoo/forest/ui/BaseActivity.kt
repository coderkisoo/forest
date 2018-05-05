package cn.kisoo.forest.ui

import android.content.Context
import android.os.Bundle
import android.view.Window
import com.jude.beam.bijection.Presenter
import com.jude.beam.expansion.BeamBaseActivity

abstract class BaseActivity<T : Presenter<*>> : BeamBaseActivity<T>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
    }


    fun getContext(): Context {
        return this
    }
}