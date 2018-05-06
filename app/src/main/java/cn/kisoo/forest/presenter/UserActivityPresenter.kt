package cn.kisoo.forest.presenter

import android.content.Intent
import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.ui.activity.UpdateNameActivity
import cn.kisoo.forest.ui.activity.UpdatePasswordActivity
import cn.kisoo.forest.ui.activity.UpdateSchoolNumActivity
import cn.kisoo.forest.ui.iview.IUserActivityView
import cn.kisoo.forest.util.HeadSelectorUtil
import com.jude.beam.bijection.Presenter
import com.orhanobut.logger.Logger

class UserActivityPresenter : Presenter<IUserActivityView>() {
    fun selectHead(headType: Int) {
        Logger.d("headSelect $headType")
        view.selectHead(HeadSelectorUtil.mHeadList[headType])
    }

    fun goUpdatePassword() {
        view.getContext().startActivity(Intent(view.getContext(), UpdatePasswordActivity::class.java))
    }

    fun goUpdateSchoolNum() {
        view.getContext().startActivity(Intent(view.getContext(), UpdateSchoolNumActivity::class.java))
    }

    fun goUpdateName() {
        view.getContext().startActivity(Intent(view.getContext(), UpdateNameActivity::class.java))
    }

    fun updateName() {
        view.updateName(UserAccountModel.currentName())
    }

    fun updateHead() {
        view.selectHead(HeadSelectorUtil.mHeadList[UserAccountModel.currentHead()])
    }

    fun updateSchoolNum() {
        view.updateSchoolNum(UserAccountModel.currentSchoolNum())
    }

    fun updateAccount() {
        view.updateAccount(UserAccountModel.currentAccount())
    }

}