package cn.kisoo.forest.presenter

import android.content.Intent
import cn.kisoo.forest.ui.activity.UserActivity
import cn.kisoo.forest.ui.iview.IMainActivityView
import com.jude.beam.bijection.Presenter


class MainActivityPresenter : Presenter<IMainActivityView>() {

    fun updateUser() {
        val intent = Intent(view.getContext(), UserActivity::class.java)
        view.getContext().startActivity(intent)
    }

}