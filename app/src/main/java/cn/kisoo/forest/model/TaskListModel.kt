package cn.kisoo.forest.model

import cn.kisoo.forest.bean.Task
import io.realm.Realm
import java.util.*

object TaskListModel {

    fun addTask(minute: Int) {
        Realm.getDefaultInstance().executeTransaction {
            val task = it.createObject(Task::class.java, System.currentTimeMillis().toInt())
            task.tStarttime = Date()
            task.tLength = minute
            task.uId = UserAccountModel.UID()
            task.isSuccess = -1
        }
    }

    fun successRecentTask(){
        Realm.getDefaultInstance().executeTransaction {
            val task = it.where(Task::class.java)
                    .equalTo("uId", UserAccountModel.UID())
                    .equalTo("isSuccess", -1)
                    .findFirst()
            task.isSuccess = 1
        }
    }


    fun successRecentTask(minute: Int){
        Realm.getDefaultInstance().executeTransaction {
            val task = it.where(Task::class.java)
                    .equalTo("uId", UserAccountModel.UID())
                    .equalTo("isSuccess", -1)
                    .findFirst()

        }
    }

    fun failAllTask() {
        Realm.getDefaultInstance().executeTransaction {
            val results = it.where(Task::class.java)
                    .equalTo("uId", UserAccountModel.UID())
                    .equalTo("isSuccess", -1)
                    .findAll()
            results.forEach {
                it.isSuccess = 0
            }
        }
    }


    fun fetchTask(fetchTaskCallback: FetchTaskCallback) {
        Realm.getDefaultInstance().executeTransaction {
            val results = it.where(Task::class.java)
                    .equalTo("uId", UserAccountModel.UID())
                    .equalTo("hasUpload", false)
                    .notEqualTo("isSuccess", "-1")
                    .findAll()
            if (results.isNotEmpty()) {
                fetchTaskCallback.onTaskFetch(results)
            }
        }
    }

    interface FetchTaskCallback {
        fun onTaskFetch(task: List<Task>)
    }

}