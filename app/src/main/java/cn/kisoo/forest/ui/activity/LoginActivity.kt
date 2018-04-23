package cn.kisoo.forest.ui.activity

import android.os.Bundle
import cn.kisoo.forest.presenter.LoginActivityPresenter
import com.jude.beam.bijection.BeamAppCompatActivity
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(LoginActivityPresenter::class)
class LoginActivity : BeamAppCompatActivity<LoginActivityPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}