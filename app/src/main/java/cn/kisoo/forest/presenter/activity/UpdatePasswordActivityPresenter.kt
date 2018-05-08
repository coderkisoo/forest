package cn.kisoo.forest.presenter.activity

import cn.kisoo.forest.model.RetrofitModel
import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.ui.iview.activity.IUpdatePasswordActivityView
import cn.kisoo.forest.util.ProgressDialogUtil
import cn.kisoo.forest.util.ToastUtils
import com.jude.beam.bijection.Presenter

class UpdatePasswordActivityPresenter : Presenter<IUpdatePasswordActivityView>() {

    /***
     * @param password2 新密码
     * @param password3 确认密码
     */
    fun confirmUpdatePassword(password2: String, password3: String) {
        if (password2 != password3) {
            ToastUtils.shortToast("两次输入密码不一致")
            return
        }
        ProgressDialogUtil.showProgressDialog(view.getContext(), "提示：", "正在修改密码...")
        RetrofitModel.updatePassword(password2, object : UserAccountModel.UserInfoUpdateListener {
            override fun success() {
                ProgressDialogUtil.dismissDialog()
                view.finish()
            }

            override fun fail() {
                ProgressDialogUtil.dismissDialog()
            }

        })
    }

}