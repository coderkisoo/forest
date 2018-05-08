package cn.kisoo.forest.ui.fragment

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import cn.kisoo.forest.R
import cn.kisoo.forest.bean.Task
import cn.kisoo.forest.presenter.fragment.TaskListFragmentPresenter
import cn.kisoo.forest.ui.BaseFragment
import cn.kisoo.forest.ui.adapter.TaskListAdapter
import cn.kisoo.forest.ui.iview.fragment.ITaskListFragmentView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(TaskListFragmentPresenter::class)
class TaskListFragment : BaseFragment<TaskListFragmentPresenter>(), ITaskListFragmentView {

    var mRootView: View? = null
    var lv_tasks: ListView? = null
    var srl_refresh: SwipeRefreshLayout? = null
    val mTaskListAdapter = TaskListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(R.layout.fragment_tasks, null)
        initViews()
        return mRootView
    }

    private fun initViews() {
        lv_tasks = mRootView?.findViewById(R.id.lv_tasks)
        srl_refresh = mRootView?.findViewById(R.id.srl_refresh)
        lv_tasks?.adapter = mTaskListAdapter
        presenter.requestTasks()
    }

    override fun refresh(refresh: Boolean) {
        srl_refresh?.isRefreshing = refresh
    }

    override fun showDatas(task: Array<Task>) {
        mTaskListAdapter.setData(task)
    }

}