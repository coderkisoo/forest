package cn.kisoo.forest.ui.iview.activity

import android.support.annotation.DrawableRes

interface IUserActivityView : IBaseActivityView {
    fun selectHead(@DrawableRes headSrc: Int)
    fun updateName(currentName: String)
    fun updateSchoolNum(currentSchoolNum: String)
    fun updateAccount(currentAccount:String)

}