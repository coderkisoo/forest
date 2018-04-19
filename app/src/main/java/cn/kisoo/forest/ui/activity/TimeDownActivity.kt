package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.view.Window
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.TimeDownActivityPresenter
import com.jude.beam.bijection.BeamAppCompatActivity
import com.jude.beam.bijection.RequiresPresenter
import com.orhanobut.logger.Logger

@RequiresPresenter(TimeDownActivityPresenter::class)
class TimeDownActivity : BeamAppCompatActivity<TimeDownActivityPresenter>(), TimeDownActivityPresenter.TimeDownTimer.TimeDownListener {

    companion object {
        @JvmStatic
        public val TIME_MINUTES = "TIME_MINUTES"
    }
    var mTv_direction: TextView? = null

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
    }

    override fun onTick(minute: Int, mills: Int) {
        mTv_direction?.setText("$minute:$mills")
        Logger.d("$minute:$mills")
    }

    override fun onFinish() {
        Logger.d("onFinish")
    }

}