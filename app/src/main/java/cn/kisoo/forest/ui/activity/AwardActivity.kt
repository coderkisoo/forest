package cn.kisoo.forest.ui.activity

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.MenuItem
import android.widget.GridView
import cn.kisoo.forest.R
import cn.kisoo.forest.bean.UserAchievement
import cn.kisoo.forest.presenter.activity.AwardActivityPresenter
import cn.kisoo.forest.ui.BaseActivity
import cn.kisoo.forest.ui.adapter.AwardListAdapter
import cn.kisoo.forest.ui.iview.activity.IAwardActivityView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(AwardActivityPresenter::class)
class AwardActivity : BaseActivity<AwardActivityPresenter>(), IAwardActivityView, SwipeRefreshLayout.OnRefreshListener {

    override fun layoutId(): Int = R.layout.activity_award

    var mSRLRegresh: SwipeRefreshLayout? = null
    var mGVAwardList: GridView? = null
    val mAwardListAdapter = AwardListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initData()
    }

    private fun initData() {
        onRefresh()
    }

    private fun initViews() {
        mSRLRegresh = findViewById(R.id.srl_refresh)
        mGVAwardList = findViewById(R.id.gv_award_list)
        mSRLRegresh?.setColorSchemeResources(R.color.title_color, R.color.base_background, R.color.light_color, R.color.more_light_color)
        mSRLRegresh?.setOnRefreshListener(this)
        mGVAwardList?.adapter = mAwardListAdapter
        mGVAwardList?.onItemClickListener = mAwardListAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRefresh() {
        presenter.refreshAwards()
    }


    override fun setRefreshing(isRefresh: Boolean) {
        mSRLRegresh?.isRefreshing = isRefresh
    }

    override fun setAwards(list: List<UserAchievement>?) {
        list?.let {
            mAwardListAdapter.setData(it)
        }
    }

}