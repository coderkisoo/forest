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
    private var mHasPage = false

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        mHasPage = layoutId() != 0
        if (mHasPage) {
            setContentView(layoutId())
            mTlTitle = findViewById(R.id.tl_title)
            setSupportActionBar(mTlTitle)
        }
    }

    open fun layoutId(): Int {
        return 0
    }


    fun getContext(): Context {
        return this
    }
}