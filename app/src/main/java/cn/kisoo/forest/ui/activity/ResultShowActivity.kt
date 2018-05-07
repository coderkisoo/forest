package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.activity.ResultShowActivityPresenter
import cn.kisoo.forest.ui.iview.activity.IResultShowActivityView
import cn.kisoo.forest.view.CircleWidget
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(ResultShowActivityPresenter::class)
class ResultShowActivity : ResultActivity<ResultShowActivityPresenter>(), View.OnClickListener, IResultShowActivityView {
    override fun layoutId(): Int = R.layout.activity_lose

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_do_next -> finish()
        }
    }

    var mCwWidget: CircleWidget? = null
    var mBtnDoNext: Button? = null
    var mTvPercent: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        presenter.uploadTasks()
    }

    private fun initViews() {
        mCwWidget = findViewById(R.id.cw_widget)
        mBtnDoNext = findViewById(R.id.btn_do_next)
        mTvPercent = findViewById(R.id.tv_percent)
        mTvPercent?.text = resources.getString(R.string.success_percent).format(mSuccessDuration / mTotalDuration)
        mBtnDoNext?.setOnClickListener(this)
        mCwWidget?.setProgress(mSuccessDuration / mTotalDuration)
        mCwWidget?.setCurPicture(if (mIfSuccess) R.mipmap.pic_center_success else R.mipmap.pic_center_died)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> presenter.finishLosePage()
        }
        return super.onOptionsItemSelected(item)
    }

}