package cn.kisoo.forest.presenter.fragment

import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.model.UserSettingModel
import cn.kisoo.forest.model.UserSettingModel.KEY_DESTROY_TASK
import cn.kisoo.forest.model.UserSettingModel.KEY_KEEP_LIGHT
import cn.kisoo.forest.model.UserSettingModel.KEY_NOTIFY_ME
import cn.kisoo.forest.model.UserSettingModel.KEY_OPEN_WHITE_LIST
import cn.kisoo.forest.model.UserSettingModel.KEY_SENSE_MORE
import cn.kisoo.forest.ui.activity.LoginActivity
import cn.kisoo.forest.ui.iview.fragment.ISettingFragmentView
import com.jude.beam.expansion.BeamBasePresenter

class SettingFragmentPresenter : BeamBasePresenter<ISettingFragmentView>() {
    fun notifyMeChanged(checked: Boolean) {
        UserSettingModel.updateSettings(KEY_NOTIFY_ME, checked)
    }

    fun logout() {
        UserAccountModel.logout()
        view.finish()
        view.startActivity(LoginActivity::class.java)
    }

    fun recovery() {


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
        UserSettingModel.uploadSettings()
    }

}