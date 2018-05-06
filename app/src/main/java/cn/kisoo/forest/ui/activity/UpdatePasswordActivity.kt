package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.UpdatePasswordActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.IUpdatePasswordActivityView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(UpdatePasswordActivityPresenter::class)
class UpdatePasswordActivity : BaseActivity<UpdatePasswordActivityPresenter>(), IUpdatePasswordActivityView {
    override fun layoutId(): Int = R.layout.activity_update_password

    var mETPassword1: EditText? = null
    var mETPassword2: EditText? = null
    var mETPassword3: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        mETPassword1 = findViewById(R.id.et_password1)
        mETPassword2 = findViewById(R.id.et_password2)
        mETPassword3 = findViewById(R.id.et_password3)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_confirm, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.menu_confirm -> presenter.confirmUpdatePassword(mETPassword1?.text.toString(), mETPassword2?.text.toString(), mETPassword3?.text.toString())
        }
        return super.onOptionsItemSelected(item)
    }

}