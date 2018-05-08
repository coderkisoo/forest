package cn.kisoo.forest.ui.activity

import android.content.Intent
import android.os.Bundle
import cn.kisoo.forest.constant.RequestCode
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

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        when(intent.getStringExtra(RequestCode.REQUEST_CODE)){
            RequestCode.CLOSE_APP -> presenter.closeApp()
            RequestCode.MAIN_PAGE -> presenter.goFirstPage()
        }
    }
}