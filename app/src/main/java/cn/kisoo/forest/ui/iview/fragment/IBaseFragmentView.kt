package cn.kisoo.forest.ui.iview.fragment

import android.support.v4.app.FragmentActivity

interface IBaseFragmentView {
    fun startActivity(clazz: Class<*>)
    fun context(): FragmentActivity?
}