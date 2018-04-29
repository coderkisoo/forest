package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.LoseActivityPresenter
import cn.kisoo.forest.view.CircleWidget
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(LoseActivityPresenter::class)
class LoseActivity : ResultActivity<LoseActivityPresenter>(), View.OnClickListener {
    override fun onClick(v: View?) {

    }

    var mCwWidget: CircleWidget? = null
    var mBtnDoNext: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose)
        initViews()
    }

    private fun initViews() {
        mCwWidget = findViewById(R.id.cw_widget)
        mBtnDoNext = findViewById(R.id.btn_do_next)
        mBtnDoNext?.setOnClickListener(this)
        mCwWidget?.setProgress(mSuccessDuration / mTotalDuration)
        mCwWidget?.setCurPicture(if (mIfSuccess) R.mipmap.pic_center_success else R.mipmap.pic_center_died)
    }
}