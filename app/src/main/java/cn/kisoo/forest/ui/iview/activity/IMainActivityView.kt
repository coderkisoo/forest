package cn.kisoo.forest.ui.iview.activity

import android.support.annotation.DrawableRes

interface IMainActivityView : IBaseActivityView {
    fun updateHead(@DrawableRes headSrc: Int)

    fun updateName(name:String)

}