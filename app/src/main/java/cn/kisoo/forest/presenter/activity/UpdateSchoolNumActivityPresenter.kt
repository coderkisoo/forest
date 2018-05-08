package cn.kisoo.forest.presenter.activity

import cn.kisoo.forest.model.RetrofitModel
import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.ui.iview.activity.IUpdateSchoolNumActivityView
import cn.kisoo.forest.util.ProgressDialogUtil
import com.jude.beam.bijection.Presenter

class UpdateSchoolNumActivityPresenter : Presenter<IUpdateSchoolNumActivityView>() {

    fun confirmSchoolNumUpdate(schoolNum: String) {
        ProgressDialogUtil.showProgressDialog(view.getContext(), "提示：", "正在修改学号...")
        RetrofitModel.uploadSchoolNum(schoolNum, object : UserAccountModel.UserInfoUpdateListener {
            override fun success() {
                ProgressDialogUtil.dismissDialog()
                view.finish()
            }

            override fun fail() {
                ProgressDialogUtil.dismissDialog()
            }

        })
    }

}