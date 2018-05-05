package cn.kisoo.forest.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.RegisterActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.IRegisterActivityView
import cn.kisoo.forest.util.HeadSelector
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(RegisterActivityPresenter::class)
class RegisterActivity : BaseActivity<RegisterActivityPresenter>(), View.OnClickListener, IRegisterActivityView {


    var mIVHead: ImageView? = null
    var mETName: EditText? = null
    var mETSchoolNum: EditText? = null
    var mETAccount: EditText? = null
    var mETPassword: EditText? = null
    var mETPassword2: EditText? = null
    var mTVGoLogin: TextView? = null
    var mBTNRegister: Button? = null
    var mCurrentDialog: AlertDialog? = null

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
        mETPassword2 = findViewById(R.id.et_password2)
        mTVGoLogin = findViewById(R.id.tv_go_login)
        mBTNRegister = findViewById(R.id.btn_register)
        mTVGoLogin?.setOnClickListener(this)
        mBTNRegister?.setOnClickListener(this)
        mIVHead?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_go_login -> presenter.goLogin()
            R.id.iv_head -> showHeadSelector()
            R.id.btn_register -> presenter.register(0,
                    mETName?.text.toString(),
                    mETSchoolNum?.text.toString(),
                    mETAccount?.text.toString(),
                    mETPassword?.text.toString(),
                    mETPassword2?.text.toString())
        }
    }

    private fun showHeadSelector() {
        HeadSelector.selectHead(this, object : HeadSelector.HeadSelector {
            override fun onHeadSelect(headType: Int) {
                presenter.selectHead(headType)
            }
        })
    }


    override fun getContext(): Context {
        return this
    }

    override fun setHead(headRes: Int) {
        mIVHead?.setImageResource(headRes)
    }

}