package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.RegisterActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(RegisterActivityPresenter::class)
class RegisterActivity : BaseActivity<RegisterActivityPresenter>() {

    var mIVHead: ImageView? = null
    var mETName: ImageView? = null
    var mETSchoolNum: EditText? = null
    var mETAccount: EditText? = null
    var mETPassword: EditText? = null
    var mTVGoLogin: TextView? = null
    var mBTNRegister: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initViews()
    }

    private fun initViews() {
        mIVHead = findViewById(R.id.iv_head)
        mETName = findViewById(R.id.et_name)
        mETSchoolNum = findViewById(R.id.et_school_num)
        mETAccount = findViewById(R.id.et_account)
        mETPassword = findViewById(R.id.et_password)
        mTVGoLogin = findViewById(R.id.tv_go_login)
        mBTNRegister = findViewById(R.id.btn_register)


    }

}