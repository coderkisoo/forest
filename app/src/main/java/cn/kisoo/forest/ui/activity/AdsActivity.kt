package cn.kisoo.forest.ui.activity

import android.os.Bundle
import cn.kisoo.forest.presenter.activity.AdsActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.activity.IAdsActivityView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(AdsActivityPresenter::class)
class AdsActivity : BaseActivity<AdsActivityPresenter>(), IAdsActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.handleTask()
        presenter.goFirstPage()
    }
}