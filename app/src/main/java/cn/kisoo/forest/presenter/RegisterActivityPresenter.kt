package cn.kisoo.forest.presenter

import android.content.Intent
import cn.kisoo.forest.R
import cn.kisoo.forest.ui.activity.LoginActivity
import cn.kisoo.forest.ui.iview.IRegisterView
import cn.kisoo.forest.util.ToastUtils
import com.jude.beam.bijection.Presenter

class RegisterActivityPresenter : Presenter<IRegisterView>() {
    fun goLogin() {
        val intent = Intent()
        intent.setClass(view.getContext(), LoginActivity::class.java)
        view.getContext().startActivity(intent)
    }

    fun register(headType: Int, name: String, schoolNum: String, account: String, password: String, password2: String) {
        if (password != password2) {
            ToastUtils.shortToast(R.string.pwd_not_same)
        }

    }

}