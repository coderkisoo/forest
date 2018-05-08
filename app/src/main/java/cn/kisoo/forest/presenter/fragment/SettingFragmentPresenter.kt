package cn.kisoo.forest.presenter.fragment

import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.model.UserSettingModel
import cn.kisoo.forest.model.UserSettingModel.KEY_DESTROY_TASK
import cn.kisoo.forest.model.UserSettingModel.KEY_KEEP_LIGHT
import cn.kisoo.forest.model.UserSettingModel.KEY_NOTIFY_ME
import cn.kisoo.forest.model.UserSettingModel.KEY_OPEN_WHITE_LIST
import cn.kisoo.forest.model.UserSettingModel.KEY_SENSE_MORE
import cn.kisoo.forest.ui.activity.AdsActivity
import cn.kisoo.forest.ui.iview.fragment.ISettingFragmentView
import cn.kisoo.forest.util.ProgressDialogUtil
import cn.kisoo.forest.util.ToastUtils
import com.jude.beam.expansion.BeamBasePresenter

class SettingFragmentPresenter : BeamBasePresenter<ISettingFragmentView>() {
    fun notifyMeChanged(checked: Boolean) {
        UserSettingModel.updateSettings(KEY_NOTIFY_ME, checked)
    }

    fun logout() {
        UserAccountModel.logout()
        UserSettingModel.clearData()
        view.finish()
        view.startActivity(AdsActivity::class.java)
    }

    fun recovery() {
        UserSettingModel.recoverySettings()
        updateSettingPage()
    }

    fun updateSettingPage() {
        view.notifyMe(UserSettingModel.currentSettings().notifyMe)
        view.keepLight(UserSettingModel.currentSettings().keepLight)
        view.openWhiteList(UserSettingModel.currentSettings().openWhiteList)
        view.senseMore(UserSettingModel.currentSettings().senseMore)
        view.destroyTask(UserSettingModel.currentSettings().destroyTask)
    }

    fun setWhiteList() {

    }

    fun keepLight(checked: Boolean) {
        UserSettingModel.updateSettings(KEY_KEEP_LIGHT, checked)
    }

    fun openWhiteList(checked: Boolean) {
        UserSettingModel.updateSettings(KEY_OPEN_WHITE_LIST, checked)
    }

    fun senseMore(checked: Boolean) {
        UserSettingModel.updateSettings(KEY_SENSE_MORE, checked)
    }

    fun destroyTask(checked: Boolean) {
        UserSettingModel.updateSettings(KEY_DESTROY_TASK, checked)
    }

    fun uploadSettings() {
        ProgressDialogUtil.showProgressDialog(view.context(), "提示：", "正在上传中，请稍后。。。")
        UserSettingModel.uploadSettings(object : UserAccountModel.UserInfoUpdateListener {
            override fun success() {
                ProgressDialogUtil.dismissDialog()
                ToastUtils.shortToast("上传成功")
            }

            override fun fail() {
                ProgressDialogUtil.dismissDialog()
            }
        })
    }

}