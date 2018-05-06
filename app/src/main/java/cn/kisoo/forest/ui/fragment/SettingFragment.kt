package cn.kisoo.forest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RelativeLayout
import android.widget.Switch
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.fragment.SettingFragmentPresenter
import cn.kisoo.forest.ui.BaseFragment
import cn.kisoo.forest.ui.iview.fragment.ISettingFragmentView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(SettingFragmentPresenter::class)
class SettingFragment : BaseFragment<SettingFragmentPresenter>(), ISettingFragmentView, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    var mRootView: View? = null

    var mRLNotifyMe: RelativeLayout? = null
    var mSTNNotifyMe: Switch? = null
    var mRLKeepLight: RelativeLayout? = null
    var mSTNKeepLight: Switch? = null
    var mRLWhiteList: RelativeLayout? = null
    var mSTNWhiteList: Switch? = null
    var mRLSenseMore: RelativeLayout? = null
    var mSTNSenseMore: Switch? = null
    var mRLDestroyTask: RelativeLayout? = null
    var mSTNDestroyTask: Switch? = null
    var mTVRecovery: TextView? = null
    var mTVLogout: TextView? = null
    var mTVUpload: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(R.layout.fragment_setting, null)
        initViews()
        presenter.updateSettingPage()
        return mRootView
    }

    private fun initViews() {
        //提醒我
        mRLNotifyMe = mRootView?.findViewById(R.id.rl_notify_me)
        mRLNotifyMe?.setOnClickListener(this)
        mSTNNotifyMe = mRootView?.findViewById(R.id.stn_notify_me)
        mSTNNotifyMe?.setOnCheckedChangeListener(this)
        //保持屏幕亮
        mRLKeepLight = mRootView?.findViewById(R.id.rl_keep_light)
        mSTNKeepLight = mRootView?.findViewById(R.id.stn_keep_light)
        mRLKeepLight?.setOnClickListener(this)
        mSTNKeepLight?.setOnCheckedChangeListener(this)
        //白名单
        mRLWhiteList = mRootView?.findViewById(R.id.rl_white_list)
        mSTNWhiteList = mRootView?.findViewById(R.id.stn_white_list)
        mRLWhiteList?.setOnClickListener(this)
        mSTNWhiteList?.setOnCheckedChangeListener(this)
        //进阶观察
        mRLSenseMore = mRootView?.findViewById(R.id.rl_sens)
        mSTNSenseMore = mRootView?.findViewById(R.id.stn_sense_more)
        mRLSenseMore?.setOnClickListener(this)
        mSTNSenseMore?.setOnCheckedChangeListener(this)
        //退出清除任务
        mRLDestroyTask = mRootView?.findViewById(R.id.rl_destroy_task)
        mSTNDestroyTask = mRootView?.findViewById(R.id.stn_destroy_task)
        mRLDestroyTask?.setOnClickListener(this)
        mSTNDestroyTask?.setOnCheckedChangeListener(this)
        //恢复初始设置
        mTVRecovery = mRootView?.findViewById(R.id.tv_recovery)
        mTVRecovery?.setOnClickListener(this)
        //上传设置
        mTVUpload = mRootView?.findViewById(R.id.tv_upload_settings)
        mTVUpload?.setOnClickListener(this)
        //退出
        mTVLogout = mRootView?.findViewById(R.id.tv_logout)
        mTVLogout?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_recovery -> presenter.recovery()
            R.id.tv_logout -> presenter.logout()
            R.id.rl_white_list -> presenter.setWhiteList()
            R.id.tv_upload_settings -> presenter.uploadSettings()
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.stn_notify_me -> presenter.notifyMeChanged(isChecked)
            R.id.stn_keep_light -> presenter.keepLight(isChecked)
            R.id.stn_white_list -> presenter.openWhiteList(isChecked)
            R.id.stn_sense_more -> presenter.senseMore(isChecked)
            R.id.stn_destroy_task -> presenter.destroyTask(isChecked)
        }
    }

    override fun finish() {
        activity?.finish()
    }

    override fun notifyMe(open: Boolean) {
        mSTNNotifyMe?.isChecked = open
    }

    override fun keepLight(open: Boolean) {
        mSTNKeepLight?.isChecked = open
    }

    override fun openWhiteList(open: Boolean) {
        mSTNWhiteList?.isChecked = open
    }

    override fun senseMore(open: Boolean) {
        mSTNSenseMore?.isChecked = open
    }

    override fun destroyTask(open: Boolean) {
        mSTNDestroyTask?.isChecked = open
    }

}