package cn.kisoo.forest.ui.iview.activity

import android.content.Context
import android.content.Intent

interface IBaseActivityView {
    fun getContext(): Context
    fun startActivity(intent: Intent)
    fun finish()


}