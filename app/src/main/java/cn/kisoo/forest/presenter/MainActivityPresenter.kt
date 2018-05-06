package cn.kisoo.forest.presenter

import android.content.Intent
import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.ui.activity.UserActivity
import cn.kisoo.forest.ui.iview.IMainActivityView
import cn.kisoo.forest.util.HeadSelectorUtil
import com.jude.beam.bijection.Presenter


class MainActivityPresenter : Presenter<IMainActivityView>() {

    fun updateUser() {
        val intent = Intent(view.getContext(), UserActivity::class.java)
        view.getContext().startActivity(intent)
    }

    fun updateName() {
        view.updateName(UserAccountModel.currentName())
    }

    fun updateHead() {
        view.updateHead(HeadSelectorUtil.mHeadList[UserAccountModel.currentHead()])
    }

}