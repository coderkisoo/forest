package cn.kisoo.forest.presenter.activity

import android.content.Intent
import android.os.CountDownTimer
import cn.kisoo.forest.ui.activity.ResultActivity
import cn.kisoo.forest.ui.iview.activity.ITimeDownActivityView
import com.jude.beam.bijection.Presenter

class TimeDownActivityPresenter : Presenter<ITimeDownActivityView>() {

    var mTimeDownTimer: TimeDownTimer? = null

    fun timeDown(minute: Int, timeDownListener: TimeDownTimer.TimeDownListener) {
        mTimeDownTimer = TimeDownTimer(minute)
        mTimeDownTimer?.startTiming()
        mTimeDownTimer?.mTimeDownListener = timeDownListener
    }

    fun pauseTimeDown() {
        mTimeDownTimer?.pauseTimeDown()
    }

    fun createLoseIntent(intent: Intent) {
        intent.putExtra(ResultActivity.SUCCESS_DURATION, mTimeDownTimer?.mSuccessDuration)
        intent.putExtra(ResultActivity.TOTAL_DURATION, mTimeDownTimer?.mTotalMinute)
        intent.putExtra(ResultActivity.IF_SUCCESS, mTimeDownTimer?.mSuccess)
    }

    class TimeDownTimer(minute: Int) : CountDownTimer(minute * 60 * 1000L, 1000L) {

        var mTimeDownListener: TimeDownListener? = null
        var mSuccessDuration = 1000
        val mTotalMinute = minute
        var mSuccess = false

        interface TimeDownListener {
            fun onTick(minute: Int, mills: Int)
            fun onFinish()
        }

        //每一次倒计时
        override fun onTick(millisUntilFinished: Long) {
            val leftMinute = (millisUntilFinished / 1000 / 60).toInt()
            val leftMills = (millisUntilFinished / 1000 % 60).toInt()
            mSuccessDuration = mTotalMinute - leftMinute
            mTimeDownListener?.onTick(leftMinute, leftMills)
        }


        //倒计时完毕
        override fun onFinish() {
            mSuccess = true
            mTimeDownListener?.onFinish()
        }

        //取消倒计时
        fun cancelTiming() {
            cancel()
        }

        fun startTiming() {
            start()
        }

        fun pauseTimeDown() {
            pauseTimeDown()
        }

    }

}