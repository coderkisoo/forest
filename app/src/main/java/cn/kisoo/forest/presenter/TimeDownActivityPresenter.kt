package cn.kisoo.forest.presenter

import android.os.CountDownTimer
import cn.kisoo.forest.ui.iview.ITimeDownActivityView
import com.jude.beam.bijection.Presenter

class TimeDownActivityPresenter : Presenter<ITimeDownActivityView>() {

    var mTimeDownTimer: TimeDownTimer? = null

    fun timeDown(minute: Int, timeDownListener: TimeDownTimer.TimeDownListener) {
        mTimeDownTimer = TimeDownTimer(minute)
        mTimeDownTimer?.startTiming()
        mTimeDownTimer?.mTimeDownListener = timeDownListener
    }

    class TimeDownTimer(minute: Int) : CountDownTimer(minute * 60 * 1000L, 1000L) {

        var mTimeDownListener: TimeDownListener? = null

        interface TimeDownListener {
            fun onTick(minute: Int, mills: Int)
            fun onFinish()
        }

        //每一次倒计时
        override fun onTick(millisUntilFinished: Long) {
            val leftMinute = (millisUntilFinished / 1000 / 60).toInt()
            val leftMills = (millisUntilFinished / 1000 % 60).toInt()
            mTimeDownListener?.onTick(leftMinute, leftMills)
        }

        //倒计时完毕
        override fun onFinish() {
            mTimeDownListener?.onFinish()
        }

        //取消倒计时
        fun cancelTiming() {
            cancel()
        }

        fun startTiming() {
            start()
        }

    }

}