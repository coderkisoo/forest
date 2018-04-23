package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.view.Window
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.TimeDownActivityPresenter
import cn.kisoo.forest.view.CircleWidget
import com.jude.beam.bijection.BeamAppCompatActivity
import com.jude.beam.bijection.RequiresPresenter
import com.orhanobut.logger.Logger

@RequiresPresenter(TimeDownActivityPresenter::class)
class TimeDownActivity : BeamAppCompatActivity<TimeDownActivityPresenter>(), TimeDownActivityPresenter.TimeDownTimer.TimeDownListener {

    companion object {
        @JvmStatic
        public val TIME_MINUTES = "TIME_MINUTES"
        public val PIC_TYPE = "PIC_TYPE"
        public val PROGRESS = "PROGRESS"
    }

    var mTv_direction: TextView? = null
    var mCwWidget: CircleWidget? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_time_down)
        initViews()
        startTiming()
    }

    private fun startTiming() {
        val minutes = intent.getIntExtra(TIME_MINUTES, 10)
        presenter.timeDown(minutes, this)
    }

    private fun initViews() {
        mTv_direction = findViewById(R.id.tv_direction) as TextView
        mCwWidget = findViewById(R.id.cw_widget) as CircleWidget
        val pictureType = intent.getIntExtra(PIC_TYPE, R.mipmap.pic_center_13_percent)
        val progress = intent.getIntExtra(PROGRESS, 0)
        mCwWidget?.setProgress(progress)
        mCwWidget?.setCurPicture(pictureType)
    }

    override fun onTick(minute: Int, mills: Int) {
        mTv_direction?.setText("$minute:$mills")
        Logger.d("$minute:$mills")
    }

    override fun onFinish() {
        Logger.d("onFinish")
    }

}