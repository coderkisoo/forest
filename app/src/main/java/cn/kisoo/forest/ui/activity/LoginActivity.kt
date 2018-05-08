package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.activity.LoginActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.activity.ILoginActivityView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(LoginActivityPresenter::class)
class LoginActivity : BaseActivity<LoginActivityPresenter>(), View.OnClickListener, ILoginActivityView {
    override fun layoutId(): Int = R.layout.activity_login

    var mTVRegister: TextView? = null
    var mETPassword: EditText? = null
    var mETAccount: EditText? = null
    var mBTNLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        mETAccount = findViewById(R.id.et_account)
        mETPassword = findViewById(R.id.et_password)
        mTVRegister = findViewById(R.id.tv_register)
        mTVRegister?.setOnClickListener(this)
        mBTNLogin?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_register -> presenter.goRegister()
            R.id.btn_login -> presenter.login(mETAccount?.text.toString(),mETPassword?.text.toString())
        }
    }

    override fun onBackPressed() {
        presenter.finishApp()
    }

}