package cn.kisoo.forest.presenter.activity

import android.content.Intent
import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.ui.activity.AwardActivity
import cn.kisoo.forest.ui.activity.UserActivity
import cn.kisoo.forest.ui.iview.activity.IMainActivityView
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

    fun goAwardPage() {
        val intent = Intent(view.getContext(), AwardActivity::class.java)
        view.getContext().startActivity(intent)
    }

    fun selectMainPage() {
        view.closeDrawer()
        view.selectFragment(0)
    }


    fun selectTaskList() {
        view.closeDrawer()
        view.selectFragment(1)
    }

    fun selectSchoolTable() {
        view.closeDrawer()
        view.selectFragment(2)
    }

    fun selectSetting() {
        view.closeDrawer()
        view.selectFragment(3)
    }


}