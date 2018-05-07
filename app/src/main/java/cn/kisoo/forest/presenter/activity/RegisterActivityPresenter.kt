package cn.kisoo.forest.presenter.activity

import android.content.Intent
import cn.kisoo.forest.R
import cn.kisoo.forest.constant.RequestCode
import cn.kisoo.forest.model.RetrofitModel
import cn.kisoo.forest.ui.activity.AdsActivity
import cn.kisoo.forest.ui.activity.LoginActivity
import cn.kisoo.forest.ui.iview.activity.IRegisterActivityView
import cn.kisoo.forest.util.HeadSelectorUtil
import cn.kisoo.forest.util.ProgressDialogUtil
import cn.kisoo.forest.util.ToastUtils
import com.jude.beam.bijection.Presenter

class RegisterActivityPresenter : Presenter<IRegisterActivityView>() {

    var mCurrentHead = 0

    fun goLogin() {
        val intent = Intent()
        intent.setClass(view.getContext(), LoginActivity::class.java)
        view.getContext().startActivity(intent)
    }

    fun register(headType: Int, name: String, schoolNum: String, account: String, password: String, password2: String) {
        if (password != password2) {
            ToastUtils.shortToast(R.string.pwd_not_same)
            return
        }
        if (name.isEmpty()){
            ToastUtils.shortToast("昵称不能为空")
            return
        }
        if (account.isEmpty()){
            ToastUtils.shortToast("账号不能为空")
            return
        }
        if (password.isEmpty()){
            ToastUtils.shortToast("密码不能为空")
            return
        }
        if (schoolNum.isEmpty()){
            ToastUtils.shortToast("学号不能为空")
            return
        }
        ProgressDialogUtil.showProgressDialog(view.getContext(), "提示：", "正在注册中，请稍后")

        RetrofitModel.register(account, name, headType.toString(), password, schoolNum, object : RegisterListener {
            override fun onSuccess() {
                RetrofitModel.login(account, password, object : LoginActivityPresenter.LoginListener {
                    override fun success() {
                        ProgressDialogUtil.dismissDialog()
                        val intent = Intent(view.getContext(), AdsActivity::class.java)
                        intent.putExtra(RequestCode.REQUEST_CODE,RequestCode.MAIN_PAGE)
                        view.startActivity(intent)
                    }

                    override fun fail() {
                        ProgressDialogUtil.dismissDialog()
                    }

                })
            }

            override fun onFail() {
                ProgressDialogUtil.dismissDialog()
            }
        })

    }

    interface RegisterListener {
        fun onSuccess()
        fun onFail()
    }

    fun selectHead(position: Int) {
        mCurrentHead = position
        view.setHead(HeadSelectorUtil.mHeadList[position])
    }


}