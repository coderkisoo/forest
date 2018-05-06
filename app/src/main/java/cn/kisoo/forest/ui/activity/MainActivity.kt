package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.widget.DrawerLayout
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.model.UserAccountModel.HEAD_UPDATE
import cn.kisoo.forest.model.UserAccountModel.NAME_UPDATE
import cn.kisoo.forest.presenter.activity.MainActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.fragment.MainFragment
import cn.kisoo.forest.ui.fragment.SchoolTableFragment
import cn.kisoo.forest.ui.fragment.SettingFragment
import cn.kisoo.forest.ui.iview.activity.IMainActivityView
import com.jude.beam.bijection.RequiresPresenter
import de.hdodenhof.circleimageview.CircleImageView
import io.reactivex.Observable

/**
 * Created by kangqizhou on 2018/4/11.
 */
@RequiresPresenter(MainActivityPresenter::class)
class MainActivity : BaseActivity<MainActivityPresenter>(), View.OnClickListener, IMainActivityView, UserAccountModel.UserUpdateListener, NavigationView.OnNavigationItemSelectedListener {

    override fun layoutId(): Int = R.layout.activity_main

    var mCIVHead: CircleImageView? = null
    var mTVName: TextView? = null
    var mFlContent: FrameLayout? = null
    var mDlContainer: DrawerLayout? = null
    val mFragmentList = lazy { arrayListOf(MainFragment(), SchoolTableFragment(), SettingFragment()) }.value
    val mTitles = arrayListOf(R.string.main_page, R.string.school_timetables, R.string.setting)
    var mCurrentIndex = -1
    var mCurrentFragment: Fragment? = null
    var mNavigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initListeners()
        presenter.selectMainPage()
    }

    private fun initListeners() {
        UserAccountModel.registerListener(this)
    }


    private fun initViews() {
        mNavigationView = findViewById(R.id.nv_drawer)
        mFlContent = findViewById(R.id.fl_content)
        mDlContainer = findViewById(R.id.dl_container)
        val view = mNavigationView?.getHeaderView(0)
        view?.findViewById<View>(R.id.rl_headview)?.setOnClickListener(this)
        mNavigationView?.setNavigationItemSelectedListener(this)
        mCIVHead = view?.findViewById(R.id.civ_head)
        mTVName = view?.findViewById(R.id.tv_name)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_award, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun selectFragment(index: Int) {
        Observable.create<Int> { it -> it.onNext(index) }
                .filter { i -> i < mFragmentList.size && i >= 0 && i != mCurrentIndex }
                .map { i -> mFragmentList[i] }
                .map { fragment -> structTransaction(fragment) }
                .map { transaction -> hideCurrentFragment(transaction) }
                .map { transition -> transition.commitNowAllowingStateLoss() }
                .subscribe {
                    mCurrentFragment = mFragmentList[index]
                    mCurrentIndex = index
                    title = getString(mTitles[index])
                }
    }

    private fun hideCurrentFragment(transaction: FragmentTransaction): FragmentTransaction {
        mCurrentFragment?.let {
            transaction.hide(mCurrentFragment)
        }
        return transaction
    }

    private fun structTransaction(it: Fragment): FragmentTransaction {
        val transaction = supportFragmentManager.beginTransaction()
        if (it.isAdded) {
            transaction.show(it)
        } else {
            transaction.add(R.id.fl_content, it)
        }
        return transaction
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.rl_headview -> presenter.updateUser()
        }
    }

    override fun closeDrawer() {
        var isOpen = false
        mDlContainer?.let {
            isOpen = mDlContainer!!.isDrawerOpen(Gravity.START)
        }
        if (isOpen) {
            changeDrawerStatus()
        }
    }

    private fun changeDrawerStatus() {
        var isOpen = false
        mDlContainer?.let {
            isOpen = mDlContainer!!.isDrawerOpen(Gravity.START)
        }
        if (isOpen) {
            mDlContainer?.closeDrawer(Gravity.START)
        } else {
            mDlContainer?.openDrawer(Gravity.START)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> changeDrawerStatus()
            R.id.menu_award -> presenter.goAwardPage()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onUserStatusUpdate(status: Int) {
        when (status) {
            NAME_UPDATE -> presenter.updateName()
            HEAD_UPDATE -> presenter.updateHead()
        }
    }

    override fun updateHead(headSrc: Int) {
        mCIVHead?.setImageResource(headSrc)
    }

    override fun updateName(name: String) {
        mTVName?.text = name
    }

    override fun onDestroy() {
        super.onDestroy()
        UserAccountModel.unRegisterListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_main -> presenter.selectMainPage()
            R.id.menu_school_timetables -> presenter.selectSchoolTable()
            R.id.menu_setting -> presenter.selectSetting()
        }
        return false
    }

}
