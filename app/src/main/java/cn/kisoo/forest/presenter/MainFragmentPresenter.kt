package cn.kisoo.forest.presenter

import android.content.Intent
import cn.kisoo.forest.ui.activity.TimeDownActivity
import cn.kisoo.forest.ui.iview.IMainFragmentView
import com.jude.beam.expansion.BeamBasePresenter
import com.orhanobut.logger.Logger

class MainFragmentPresenter : BeamBasePresenter<IMainFragmentView>() {

    private val START_DIRECTION = 10
    private val END_DIRECTION = 120

    private var mProgress: Int = 0

    public fun updateProgress(progress: Int){
        this.mProgress = progress
    }

    public fun getDirection(progress: Int): Int {
        val direction = END_DIRECTION - START_DIRECTION
        val unitDirection = direction / 5 //时间状态的数量
        val unitProgress: Float = 100F / unitDirection //时间状态单位
        return (progress / unitProgress).toInt() * 5 + 10
    }

    fun startTiming(intent: Intent) {
        val minutes = getDirection(mProgress)
        Logger.d("开始计时$minutes 分钟")
        intent.putExtra(TimeDownActivity.TIME_MINUTES,minutes)
        intent.putExtra(TimeDownActivity.PIC_TYPE,view.currentPic(mProgress))
        intent.putExtra(TimeDownActivity.PROGRESS,mProgress)
        startActivity(intent)
    }

}