package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.activity.UpdateSchoolNumActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.activity.IUpdateSchoolNumActivityView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(UpdateSchoolNumActivityPresenter::class)
class UpdateSchoolNumActivity : BaseActivity<UpdateSchoolNumActivityPresenter>(), IUpdateSchoolNumActivityView {
    override fun layoutId(): Int = R.layout.activity_update_school_num

    var mETSchoolNum: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        mETSchoolNum = findViewById(R.id.et_school_num)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_confirm, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.menu_confirm -> presenter.confirmSchoolNumUpdate(mETSchoolNum?.text.toString())
        }
        return super.onOptionsItemSelected(item)
    }


}