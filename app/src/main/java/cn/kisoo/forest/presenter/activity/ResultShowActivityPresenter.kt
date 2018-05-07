package cn.kisoo.forest.presenter.activity

import cn.kisoo.forest.bean.Task
import cn.kisoo.forest.model.RetrofitModel
import cn.kisoo.forest.model.TaskListModel
import cn.kisoo.forest.ui.iview.activity.IResultShowActivityView
import com.jude.beam.bijection.Presenter

class ResultShowActivityPresenter : Presenter<IResultShowActivityView>() {
    fun finishLosePage() {
        view.finish()
    }

    //上传任务
    fun uploadTasks() {
        TaskListModel.fetchTask(object : TaskListModel.FetchTaskCallback {
            override fun onTaskFetch(task: List<Task>) {
                RetrofitModel.uploadTasks(task)
            }
        })
    }

}