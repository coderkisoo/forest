package cn.kisoo.forest.ui.activity

import android.os.Bundle
import cn.kisoo.forest.presenter.RegisterActivityPresenter
import com.jude.beam.bijection.BeamAppCompatActivity
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(RegisterActivityPresenter::class)
class RegisterActivity : BeamAppCompatActivity<RegisterActivityPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}