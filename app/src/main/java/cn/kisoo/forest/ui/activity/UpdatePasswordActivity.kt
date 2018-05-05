package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.view.Menu
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.UpdatePasswordActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.IUpdatePasswordActivityView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(UpdatePasswordActivityPresenter::class)
class UpdatePasswordActivity : BaseActivity<UpdatePasswordActivityPresenter>(), IUpdatePasswordActivityView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_school_num)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_confirm, menu)
        return super.onCreateOptionsMenu(menu)
    }



}