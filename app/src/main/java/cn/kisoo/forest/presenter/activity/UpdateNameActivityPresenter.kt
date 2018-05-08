package cn.kisoo.forest.presenter.activity

import cn.kisoo.forest.model.RetrofitModel
import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.ui.iview.activity.IUpdateNameActivityView
import cn.kisoo.forest.util.ProgressDialogUtil
import com.jude.beam.bijection.Presenter

class UpdateNameActivityPresenter : Presenter<IUpdateNameActivityView>() {

    fun confirmNameUpdate(name: String) {

        ProgressDialogUtil.showProgressDialog(view.getContext(), "提示：", "正在修改昵称...")
        RetrofitModel.uploadName(name, object : UserAccountModel.UserInfoUpdateListener {
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