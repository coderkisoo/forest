package cn.kisoo.forest.presenter.activity

import android.content.Intent
import cn.kisoo.forest.model.TaskListModel
import cn.kisoo.forest.model.TimeDownTimer
import cn.kisoo.forest.ui.activity.ResultActivity
import cn.kisoo.forest.ui.activity.ResultShowActivity
import cn.kisoo.forest.ui.iview.activity.ITimeDownActivityView
import com.jude.beam.bijection.Presenter

class TimeDownActivityPresenter : Presenter<ITimeDownActivityView>(), TimeDownTimer.OnCancelListener {


    var mTimeDownTimer: TimeDownTimer? = null

    fun timeDown(minute: Int, timeDownListener: TimeDownTimer.TimeDownListener) {
        mTimeDownTimer = TimeDownTimer(minute)
        mTimeDownTimer?.startTiming()
        mTimeDownTimer?.mTimeDownListener = timeDownListener
        TaskListModel.addTask(minute)
    }

    fun pauseTimeDown() {
        mTimeDownTimer?.pauseTimeDown()
    }

    fun resultPage() {
        val intent = Intent()
        intent.setClass(view.getContext(), ResultShowActivity::class.java)
        intent.putExtra(ResultActivity.SUCCESS_DURATION, mTimeDownTimer?.mSuccessDuration)
        intent.putExtra(ResultActivity.TOTAL_DURATION, mTimeDownTimer?.mTotalMinute)
        intent.putExtra(ResultActivity.IF_SUCCESS, mTimeDownTimer?.mSuccess)
        view.startActivity(intent)
    }

    fun shutDownCurrentTask() {
        mTimeDownTimer?.cancelTiming()
        TaskListModel.failAllTask()
        resultPage()
    }

    override fun onCancelEventReceive() {
        shutDownCurrentTask()
    }

}