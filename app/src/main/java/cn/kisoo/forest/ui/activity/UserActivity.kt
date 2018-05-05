package cn.kisoo.forest.ui.activity

import android.os.Bundle
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.UserActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(UserActivityPresenter::class)
class UserActivity : BaseActivity<UserActivityPresenter>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
    }
}