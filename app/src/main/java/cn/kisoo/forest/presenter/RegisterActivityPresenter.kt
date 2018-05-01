package cn.kisoo.forest.presenter

import android.content.Intent
import cn.kisoo.forest.ui.activity.LoginActivity
import cn.kisoo.forest.ui.iview.IRegisterView
import com.jude.beam.bijection.Presenter

class RegisterActivityPresenter : Presenter<IRegisterView>() {
    fun goLogin() {
        val intent = Intent()
        intent.setClass(view.getContext(), LoginActivity::class.java)
        view.getContext().startActivity(intent)
    }

}