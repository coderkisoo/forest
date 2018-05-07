package cn.kisoo.forest.presenter.fragment

import cn.kisoo.forest.bean.Task
import cn.kisoo.forest.model.TaskListModel
import cn.kisoo.forest.ui.iview.fragment.ITaskListFragmentView
import com.jude.beam.expansion.BeamBasePresenter

class TaskListFragmentPresenter : BeamBasePresenter<ITaskListFragmentView>() {

    fun requestTasks() {
        view.refresh(true)
        TaskListModel.fetchTask(object :TaskListModel.FetchTaskCallback{
            override fun onTaskFetch(task: List<Task>) {
                view.refresh(false)
                view.showDatas(task)
            }
        })
    }

}
