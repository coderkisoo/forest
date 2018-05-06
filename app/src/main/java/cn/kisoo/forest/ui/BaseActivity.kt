package cn.kisoo.forest.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Window
import cn.kisoo.forest.R
import com.jude.beam.bijection.Presenter
import com.jude.beam.expansion.BeamBaseActivity

abstract class BaseActivity<T : Presenter<*>> : BeamBaseActivity<T>() {

    private var mTlTitle: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        mTlTitle = findViewById(R.id.tl_title)
        setSupportActionBar(mTlTitle)
    }

    abstract fun layoutId(): Int


    fun getContext(): Context {
        return this
    }
}