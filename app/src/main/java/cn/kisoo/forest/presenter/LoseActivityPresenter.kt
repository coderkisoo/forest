package cn.kisoo.forest.presenter

import cn.kisoo.forest.ui.iview.ILoseActivityView
import com.jude.beam.bijection.Presenter

class LoseActivityPresenter : Presenter<ILoseActivityView>() {
    fun finishLosePage() {
        view.finish()
    }

}