package cn.kisoo.forest.ui.iview.fragment

import cn.kisoo.forest.bean.Task

interface ITaskListFragmentView : IBaseFragmentView {
    fun refresh(refresh: Boolean)
    fun showDatas(task: Array<Task>)

}