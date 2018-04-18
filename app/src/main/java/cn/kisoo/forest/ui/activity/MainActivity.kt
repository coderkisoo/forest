package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.Window
import android.widget.FrameLayout
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.MainPresenter
import cn.kisoo.forest.ui.fragment.MainFragment
import com.jude.beam.bijection.BeamAppCompatActivity
import rx.Observable

/**
 * Created by kangqizhou on 2018/4/11.
 */
class MainActivity : BeamAppCompatActivity<MainPresenter>() {

    var mFl_content: FrameLayout? = null
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
}
