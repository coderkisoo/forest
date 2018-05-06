package cn.kisoo.forest.ui.iview

import android.support.annotation.DrawableRes

interface IMainActivityView : IBaseActivityView {
    fun updateHead(@DrawableRes headSrc: Int)

    fun updateName(name:String)

}