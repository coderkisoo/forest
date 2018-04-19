package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.widget.DrawerLayout
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import android.widget.ImageView
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.MainActivityPresenter
import cn.kisoo.forest.ui.fragment.MainFragment
import com.jude.beam.bijection.BeamAppCompatActivity
import com.jude.beam.bijection.RequiresPresenter
import rx.Observable

/**
 * Created by kangqizhou on 2018/4/11.
 */
@RequiresPresenter(MainActivityPresenter::class)
class MainActivity : BeamAppCompatActivity<MainActivityPresenter>(), View.OnClickListener {

    var mFl_content: FrameLayout? = null
    var mIv_award: ImageView? = null
    var mIv_option: ImageView? = null
    var mDl_container: DrawerLayout? = null
    val list = lazy { arrayListOf(MainFragment()) }.value
    var mCurrentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        initViews()
        selectFragment(0)
    }


    private fun initViews() {
        mFl_content = findViewById(R.id.fl_content) as FrameLayout?
        mIv_award = findViewById(R.id.iv_award) as ImageView?
        mIv_option = findViewById(R.id.iv_option) as ImageView?
        mDl_container = findViewById(R.id.dl_container) as DrawerLayout?
        mIv_option?.setOnClickListener(this)
    }

    private fun selectFragment(index: Int) {
        Observable.create<Int> { it -> it.onNext(index) }
                .filter { i -> i < list.size && i >= 0 }
                .map { i -> list[i] }
                .map { fragment -> structTransaction(fragment) }
                .map { transaction ->
                    hideCurrentFragment(transaction)
                }
                .doOnCompleted { mCurrentFragment = list[index] }
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
        when (view.id) {
            R.id.iv_option -> changeDrawerStatus()
//            R.id.iv_award ->
        }
    }

    private fun changeDrawerStatus() {
        var isOpen = false
        mDl_container?.let {
            isOpen = mDl_container!!.isDrawerOpen(Gravity.START)
        }
        if (isOpen) {
            mDl_container?.closeDrawer(Gravity.START)
        } else {
            mDl_container?.openDrawer(Gravity.START)
        }
    }
}
