package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.UpdateNameActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.IUpdateNameActivityView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(UpdateNameActivityPresenter::class)
class UpdateNameActivity : BaseActivity<UpdateNameActivityPresenter>(), IUpdateNameActivityView {

    var mETName: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_name)
        initViews()
    }

    private fun initViews() {
        mETName = findViewById(R.id.et_name)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_confirm, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.menu_confirm -> presenter.confirmNameUpdate(mETName?.text.toString())
        }
        return super.onOptionsItemSelected(item)
    }

}