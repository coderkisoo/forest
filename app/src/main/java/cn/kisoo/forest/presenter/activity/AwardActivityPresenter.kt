package cn.kisoo.forest.presenter.activity

import cn.kisoo.forest.bean.UserAchiVO
import cn.kisoo.forest.model.AwardListModel
import cn.kisoo.forest.ui.iview.activity.IAwardActivityView
import cn.kisoo.forest.util.ToastUtils
import com.jude.beam.expansion.BeamBasePresenter

class AwardActivityPresenter : BeamBasePresenter<IAwardActivityView>() {

    fun refreshAwards() {
        view.setRefreshing(true)
        if (AwardListModel.hasLoadAwardList()) {
            view.setAwards(AwardListModel.getAwardListFromLocal())
            view.setRefreshing(false)
        } else {
            AwardListModel.updateAwardList(object : AwardListModel.AwardObtainListener {
                override fun onFail(info: String) {
                    view.setRefreshing(false)
                    ToastUtils.shortToast(info)
                }

                override fun onAwardObtain(userAchiVO: UserAchiVO) {
                    view.setAwards(userAchiVO.achievements)
                    view.setRefreshing(false)
                }

            })
        }
    }

}