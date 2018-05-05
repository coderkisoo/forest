package cn.kisoo.forest.ui.iview

import android.content.Context
import android.support.annotation.DrawableRes

interface IRegisterActivityView:IBaseActivityView{
    fun setHead(@DrawableRes headRes: Int)

}