package cn.kisoo.forest.ui.iview.activity

import android.support.annotation.DrawableRes

interface IRegisterActivityView: IBaseActivityView {
    fun setHead(@DrawableRes headRes: Int)

}