package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.core.widget.toast
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.MainActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.fragment.MainFragment
import com.jude.beam.bijection.RequiresPresenter
import io.reactivex.Observable

/**
 * Created by kangqizhou on 2018/4/11.
 */
@RequiresPresenter(MainActivityPresenter::class)
class MainActivity : BaseActivity<MainActivityPresenter>(), View.OnClickListener {

    var mFlContent: FrameLayout? = null
    var mTlTitle: Toolbar? = null
    var mDlContainer: DrawerLayout? = null
    val list = lazy { arrayListOf(MainFragment()) }.value
    var mCurrentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        selectFragment(0)
    }


    private fun initViews() {
        mFlContent = findViewById(R.id.fl_content)
        mDlContainer = findViewById(R.id.dl_container)
        mTlTitle = findViewById(R.id.tl_title)
        setSupportActionBar(mTlTitle)
        title = ""
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_award,menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun selectFragment(index: Int) {
        Observable.create<Int> { it -> it.onNext(index) }
                .filter { i -> i < list.size && i >= 0 }
                .map { i -> list[i] }
                .map { fragment -> structTransaction(fragment) }
                .map { transaction ->
                    hideCurrentFragment(transaction)
                }
                .doOnComplete { mCurrentFragment = list[index] }
                .subscribe({ transition -> transition?.commitNowAllowingStateLoss() })
    }

    private fun hideCurrentFragment(transaction: FragmentTransaction): FragmentTransaction {
        mCurrentFragment?.let {
            transaction.hide(mCurrentFragment)
        }
        return transaction
    }

    private fun structTransaction(it: MainFragment): FragmentTransaction {
        val transaction = supportFragmentManager.beginTransaction()
        if (it.isAdded) {
            transaction.show(it)
        } else {
            transaction.add(R.id.fl_content, it)
        }
        return transaction
    }

    override fun onClick(view: View) {

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
            R.id.menu_award -> showAward()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showAward() {
        toast("award")
    }
}
