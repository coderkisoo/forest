package cn.kisoo.forest.presenter.activity

import cn.kisoo.forest.ui.iview.activity.IUpdatePasswordActivityView
import com.jude.beam.bijection.Presenter

class UpdatePasswordActivityPresenter : Presenter<IUpdatePasswordActivityView>() {

    /***
     * @param password1 原密码
     * @param password2 新密码
     * @param password3 确认密码
     */
    fun confirmUpdatePassword(password1: String, password2: String, password3: String) {

    }

}