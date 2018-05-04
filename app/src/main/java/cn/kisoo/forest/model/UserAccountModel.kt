package cn.kisoo.forest.model

import android.annotation.SuppressLint
import android.content.Context
import cn.kisoo.forest.bean.User

@SuppressLint("StaticFieldLeak")
/***
 * 用户
 */
object UserAccountModel {

    var mContext: Context? = null

    fun init(context: Context) {
        this.mContext = context
    }

    fun initUser(user: User) {

    }
}