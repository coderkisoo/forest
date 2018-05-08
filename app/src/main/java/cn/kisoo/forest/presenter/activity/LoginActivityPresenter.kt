package cn.kisoo.forest.presenter.activity

import android.content.Intent
import cn.kisoo.forest.constant.RequestCode
import cn.kisoo.forest.model.RetrofitModel
import cn.kisoo.forest.ui.activity.AdsActivity
import cn.kisoo.forest.ui.activity.RegisterActivity
import cn.kisoo.forest.ui.iview.activity.ILoginActivityView
import cn.kisoo.forest.util.ProgressDialogUtil
import com.jude.beam.bijection.Presenter

class LoginActivityPresenter : Presenter<ILoginActivityView>() {

    fun goRegister() {
        val intent = Intent()
        intent.setClass(view.getContext(), RegisterActivity::class.java)
        view.getContext().startActivity(intent)
    }

    fun login(account: String, password: String) {
        ProgressDialogUtil.showProgressDialog(view.getContext(), "提示：", "正在登录中，请稍后...")
        RetrofitModel.login(account, password, object : LoginListener {
            override fun success() {
                ProgressDialogUtil.dismissDialog()
                val intent = Intent(view.getContext(), AdsActivity::class.java)
                intent.putExtra(RequestCode.REQUEST_CODE, RequestCode.MAIN_PAGE)
                view.startActivity(intent)
            }

            override fun fail() {
                ProgressDialogUtil.dismissDialog()
            }
        })
    }

    fun finishApp() {
        val intent = Intent(view.getContext(), AdsActivity::class.java)
        intent.putExtra(RequestCode.REQUEST_CODE, RequestCode.CLOSE_APP)
        view.startActivity(intent)
    }

    interface LoginListener {
        fun success()
        fun fail()
    }

}