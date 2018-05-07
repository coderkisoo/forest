package cn.kisoo.forest.presenter.activity

import android.content.Intent
import cn.kisoo.forest.bean.Task
import cn.kisoo.forest.model.RetrofitModel
import cn.kisoo.forest.model.TaskListModel
import cn.kisoo.forest.model.UserAccountModel
import cn.kisoo.forest.ui.activity.LoginActivity
import cn.kisoo.forest.ui.activity.MainActivity
import cn.kisoo.forest.ui.iview.activity.IAdsActivityView
import com.jude.beam.bijection.Presenter

class AdsActivityPresenter : Presenter<IAdsActivityView>() {

    //handle tasks
    fun handleTask() {
        if (UserAccountModel.isLogin()) {
            TaskListModel.failAllTask()
            TaskListModel.uploadTask(object : TaskListModel.FetchTaskCallback {
                override fun onTaskFetch(task: List<Task>) {
                    RetrofitModel.uploadTasks(task)
                }
            })
        }
    }

    fun goFirstPage() {
        val intent = Intent()
        if (UserAccountModel.isLogin()) {
            intent.setClass(view.getContext(), MainActivity::class.java)
        } else {
            intent.setClass(view.getContext(), LoginActivity::class.java)
        }
        view.startActivity(intent)
    }

    fun closeApp() {
        view.finish()
    }

}