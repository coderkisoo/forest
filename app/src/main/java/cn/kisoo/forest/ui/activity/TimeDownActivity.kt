package cn.kisoo.forest.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.toast
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.activity.TimeDownActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.activity.ITimeDownActivityView
import cn.kisoo.forest.view.CircleWidget
import com.jude.beam.bijection.RequiresPresenter
import com.orhanobut.logger.Logger

@RequiresPresenter(TimeDownActivityPresenter::class)
class TimeDownActivity : BaseActivity<TimeDownActivityPresenter>(), TimeDownActivityPresenter.TimeDownTimer.TimeDownListener, View.OnClickListener, ITimeDownActivityView {
    override fun layoutId(): Int = R.layout.activity_time_down

    companion object {
        @JvmStatic
        val TIME_MINUTES = "TIME_MINUTES"
        val PIC_TYPE = "PIC_TYPE"
        val PROGRESS = "PROGRESS"
    }

    var mTv_direction: TextView? = null
    var mCwWidget: CircleWidget? = null
    var mBtnCancel: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        mBtnCancel = findViewById(R.id.btn_cancel) as Button
        val pictureType = intent.getIntExtra(PIC_TYPE, R.mipmap.pic_center_13_percent)
        val progress = intent.getIntExtra(PROGRESS, 0)
        mCwWidget?.setProgress(progress)
        mCwWidget?.setCurPicture(pictureType)
        mBtnCancel?.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onTick(minute: Int, mills: Int) {
        mTv_direction?.text = "$minute:$mills"
        Logger.d("$minute:$mills")
    }

    override fun onFinish() {
        Logger.d("onFinish")
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_cancel -> {
                toast(R.string.cancel_result, Toast.LENGTH_SHORT)
                AlertDialog
                        .Builder(this)
                        .setTitle(R.string.hint)
                        .setMessage(R.string.cancel_timedown_dialog_message)
                        .setPositiveButton(R.string.text_positive) { dialog, _ ->
                            dialog.dismiss()
                            val intent = Intent()
                            intent.setClass(this, LoseActivity::class.java)
                            presenter.createLoseIntent(intent)
                            finish()
                            startActivity(intent)
                        }
                        .setNegativeButton(R.string.text_cancel) { dialog, _ -> dialog.dismiss() }
                        .show()
            }
        }

    }


}