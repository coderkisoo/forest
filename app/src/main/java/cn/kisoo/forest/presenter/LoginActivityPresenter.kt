package cn.kisoo.forest.presenter

import android.content.Intent
import cn.kisoo.forest.ui.activity.RegisterActivity
import cn.kisoo.forest.ui.iview.ILoginView
import com.jude.beam.bijection.Presenter

class LoginActivityPresenter : Presenter<ILoginView>() {

    fun goRegister() {
        val intent = Intent()
        intent.setClass(view.getContext(), RegisterActivity::class.java)
        view.getContext().startActivity(intent)
    }

}