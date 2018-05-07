package cn.kisoo.forest.ui.fragment

import cn.kisoo.forest.presenter.fragment.TaskListFragmentPresenter
import cn.kisoo.forest.ui.BaseFragment
import cn.kisoo.forest.ui.iview.fragment.ITaskListFragmentView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(TaskListFragmentPresenter::class)
class TaskListFragment : BaseFragment<TaskListFragmentPresenter>(), ITaskListFragmentView {

}