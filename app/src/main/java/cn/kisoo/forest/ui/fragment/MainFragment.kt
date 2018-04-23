package cn.kisoo.forest.ui.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.MainFragmentPresenter
import cn.kisoo.forest.ui.activity.TimeDownActivity
import cn.kisoo.forest.ui.iview.IMainFragmentView
import cn.kisoo.forest.view.CircleWidget
import com.jude.beam.bijection.BeamFragment
import com.jude.beam.bijection.RequiresPresenter
import com.orhanobut.logger.Logger

@RequiresPresenter(MainFragmentPresenter::class)
class MainFragment : BeamFragment<MainFragmentPresenter>(), CircleWidget.ProgressListener, View.OnClickListener, IMainFragmentView {


    var mRootView: View? = null
    var mCw_widget: CircleWidget? = null
    var mTv_direction: TextView? = null
    var mBtn_start: Button? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initViews(inflater, container)
        return mRootView
    }

    private fun initViews(inflater: LayoutInflater?, container: ViewGroup?) {
        mRootView = inflater?.inflate(R.layout.fragment_main, container, false)
        mCw_widget = mRootView?.findViewById(R.id.cw_widget)
        mTv_direction = mRootView?.findViewById(R.id.tv_direction)
        mBtn_start = mRootView?.findViewById(R.id.btn_start)
        mCw_widget?.setProgressListener(this)
        mBtn_start?.setOnClickListener(this)
        onProgress(50)
    }

    @SuppressLint("SetTextI18n")
    override fun onProgress(progress: Int) {
        Logger.d(progress)
        presenter.updateProgress(progress)
        mTv_direction?.text = "${presenter.getDirection(progress)} ${getText(R.string.minute)}"
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_start -> presenter.startTiming(Intent(activity, TimeDownActivity::class.java))
        }
    }

    override fun currentPic(progress: Int): Int {
        if (progress <= 13) {
            return R.mipmap.pic_center_13_percent
        } else if (progress <= 40) {
            return R.mipmap.pic_center_40_percent
        } else if (progress <= 75) {
            return R.mipmap.pic_center_75_percent
        } else {
            return R.mipmap.pic_center_100_percent
        }
    }

}