package cn.kisoo.forest.ui.activity

import android.os.Bundle
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.activity.WhiteListActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.activity.IWhiteListActivityView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(WhiteListActivityPresenter::class)
class WhiteListActivity : BaseActivity<WhiteListActivityPresenter>(), IWhiteListActivityView {

    override fun layoutId(): Int = R.layout.activity_white_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}