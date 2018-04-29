package cn.kisoo.forest.ui.activity

import android.os.Bundle
import cn.kisoo.forest.ui.BaseActivity
import com.jude.beam.bijection.Presenter

abstract class ResultActivity<T : Presenter<*>> : BaseActivity<T>() {

    var mTotalDuration = 1000
    var mSuccessDuration = 1000
    var mIfSuccess = false


    companion object {
        @JvmStatic
        val TOTAL_DURATION = "total_duration"//全部时间
        val SUCCESS_DURATION = "success_duration"//成功时间
        val IF_SUCCESS = "if_success"//是否成功
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mTotalDuration = intent.getIntExtra(TOTAL_DURATION, 1000)
        mSuccessDuration = intent.getIntExtra(SUCCESS_DURATION, 1000)
        mIfSuccess = intent.getBooleanExtra(IF_SUCCESS, false)
    }
}