package cn.kisoo.forest.ui.iview

import android.content.Context
import android.support.annotation.DrawableRes

interface IRegisterView{
    fun getContext(): Context
    fun setHead(@DrawableRes headRes: Int)

}