package cn.kisoo.forest.presenter.activity

import android.content.Intent
import cn.kisoo.forest.ui.activity.RegisterActivity
import cn.kisoo.forest.ui.iview.activity.ILoginActivityView
import com.jude.beam.bijection.Presenter

class LoginActivityPresenter : Presenter<ILoginActivityView>() {

    fun goRegister() {
        val intent = Intent()
        intent.setClass(view.getContext(), RegisterActivity::class.java)
        view.getContext().startActivity(intent)
    }

}