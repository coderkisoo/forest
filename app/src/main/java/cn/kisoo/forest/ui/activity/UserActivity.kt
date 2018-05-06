package cn.kisoo.forest.ui.activity

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.model.UserAccountModel.HEAD_UPDATE
import cn.kisoo.forest.model.UserAccountModel.NAME_UPDATE
import cn.kisoo.forest.model.UserAccountModel.SCHOOL_NUM_UPDATE
import cn.kisoo.forest.presenter.UserActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.iview.IUserActivityView
import cn.kisoo.forest.util.HeadSelectorUtil
import com.jude.beam.bijection.RequiresPresenter


@RequiresPresenter(UserActivityPresenter::class)
class UserActivity : BaseActivity<UserActivityPresenter>(), View.OnClickListener, IUserActivityView, UserAccountModel.UserUpdateListener {

    private var mIVHead: RelativeLayout? = null
    private var mTVName: TextView? = null
    private var mTVSchoolNum: TextView? = null
    private var mTVAccount: TextView? = null
    private var mTVUpdatePassword: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initListeners()
    }

    override fun layoutId(): Int = R.layout.activity_user


    private fun initViews() {
        mIVHead = findViewById(R.id.iv_head)
        mTVName = findViewById(R.id.tv_name)
        mTVSchoolNum = findViewById(R.id.tv_school_num)
        mTVAccount = findViewById(R.id.tv_account)
        mTVUpdatePassword = findViewById(R.id.tv_password_update)

        presenter.updateName()
        presenter.updateAccount()
        presenter.updateHead()
        presenter.updateSchoolNum()
    }

    private fun initListeners() {
        mIVHead?.setOnClickListener(this)
        mTVName?.setOnClickListener(this)
        mTVAccount?.setOnClickListener(this)
        mTVSchoolNum?.setOnClickListener(this)
        mTVUpdatePassword?.setOnClickListener(this)
        UserAccountModel.registerListener(this)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.iv_head -> HeadSelectorUtil.selectHead(this, object : HeadSelectorUtil.HeadSelector {
                override fun onHeadSelect(headType: Int) {
                    presenter.selectHead(headType)
                }
            })
            R.id.tv_password_update -> presenter.goUpdatePassword()
            R.id.tv_school_num -> presenter.goUpdateSchoolNum()
            R.id.tv_name -> presenter.goUpdateName()
        }
    }

    override fun selectHead(headSrc: Int) {
        mIVHead?.setBackgroundResource(headSrc)
    }

    override fun updateAccount(currentAccount: String) {
        val spannableString = SpannableString(getString(R.string.account_is, currentAccount))
        val italicSpan = StyleSpan(Typeface.ITALIC)
        spannableString.setSpan(italicSpan, 3, spannableString.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        mTVAccount?.text = spannableString
    }

    override fun updateName(currentName: String) {
        val spannableString = SpannableString(getString(R.string.name_is, currentName))
        val italicSpan = StyleSpan(Typeface.ITALIC)
        spannableString.setSpan(italicSpan, 3, spannableString.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        mTVName?.text = spannableString
    }

    override fun updateSchoolNum(currentSchoolNum: String) {
        val spannableString = SpannableString(getString(R.string.school_num_is, currentSchoolNum))
        val italicSpan = StyleSpan(Typeface.ITALIC)
        spannableString.setSpan(italicSpan, 3, spannableString.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        mTVSchoolNum?.text = spannableString
    }

    override fun onDestroy() {
        super.onDestroy()
        UserAccountModel.unRegisterListener(this)
    }

    override fun onUserStatusUpdate(status: Int) {
        when (status) {
            HEAD_UPDATE -> presenter.updateHead()
            NAME_UPDATE -> presenter.updateName()
            SCHOOL_NUM_UPDATE -> presenter.updateSchoolNum()
        }
    }
}