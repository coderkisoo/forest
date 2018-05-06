package cn.kisoo.forest.presenter.activity

import cn.kisoo.forest.ui.iview.activity.ILoseActivityView
import com.jude.beam.bijection.Presenter

class LoseActivityPresenter : Presenter<ILoseActivityView>() {
    fun finishLosePage() {
        view.finish()
    }

}