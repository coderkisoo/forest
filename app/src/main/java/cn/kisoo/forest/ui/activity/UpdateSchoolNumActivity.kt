package cn.kisoo.forest.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.Menu
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.UpdateSchoolNumActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.IUpdateSchoolNumActivityView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(UpdateSchoolNumActivityPresenter::class)
class UpdateSchoolNumActivity : BaseActivity<UpdateSchoolNumActivityPresenter>(), IUpdateSchoolNumActivityView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_school_num)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_confirm, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun getContext(): Context {
        return this
    }

}