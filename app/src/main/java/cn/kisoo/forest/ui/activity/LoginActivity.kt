package cn.kisoo.forest.ui.activity

import android.os.Bundle
import cn.kisoo.forest.presenter.LoginActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(LoginActivityPresenter::class)
class LoginActivity : BaseActivity<LoginActivityPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}