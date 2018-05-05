package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.LoginActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.ILoginActivityView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(LoginActivityPresenter::class)
class LoginActivity : BaseActivity<LoginActivityPresenter>(), View.OnClickListener, ILoginActivityView {


    var mTVRegister: TextView? = null
    var mETPassword: EditText? = null
    var mETAccount: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
    }

    private fun initViews() {
        mETAccount = findViewById(R.id.et_account)
        mETPassword = findViewById(R.id.et_password)
        mTVRegister = findViewById(R.id.tv_register)
        mTVRegister?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_register -> presenter.goRegister()
        }
    }

}