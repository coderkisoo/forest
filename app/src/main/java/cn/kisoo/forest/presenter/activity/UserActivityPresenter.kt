package cn.kisoo.forest.presenter.activity

import android.content.Intent
import cn.kisoo.forest.model.RetrofitModel
import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.ui.activity.UpdateNameActivity
import cn.kisoo.forest.ui.activity.UpdatePasswordActivity
import cn.kisoo.forest.ui.activity.UpdateSchoolNumActivity
import cn.kisoo.forest.ui.iview.activity.IUserActivityView
import cn.kisoo.forest.util.HeadSelectorUtil
import cn.kisoo.forest.util.ProgressDialogUtil
import com.jude.beam.bijection.Presenter
import com.orhanobut.logger.Logger

class UserActivityPresenter : Presenter<IUserActivityView>() {
    fun selectHead(headType: Int) {
        ProgressDialogUtil.showProgressDialog(view.getContext(), "提示：", "正在修改中，请稍后")
        Logger.d("headSelect $headType")
        RetrofitModel.uploadHead(headType, object : UserAccountModel.UserInfoUpdateListener {
            override fun success() {
                selectHead(UserAccountModel.currentHead())
                ProgressDialogUtil.dismissDialog()
            }

            override fun fail() {
                ProgressDialogUtil.dismissDialog()
            }

        })
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