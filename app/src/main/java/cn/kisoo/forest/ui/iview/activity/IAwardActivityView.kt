package cn.kisoo.forest.ui.iview.activity

import cn.kisoo.forest.bean.UserAchievement

interface IAwardActivityView {

    fun setRefreshing(isRefresh: Boolean)
    fun setAwards(list: List<UserAchievement>?)

}