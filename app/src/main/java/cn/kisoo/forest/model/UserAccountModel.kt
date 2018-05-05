package cn.kisoo.forest.model

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.content.edit
import cn.kisoo.forest.bean.User

@SuppressLint("StaticFieldLeak")
/***
 * 用户
 */
object UserAccountModel {

    var mContext: Context? = null
    var user: User? = null
    const val USER_SP = "user_sp"

    const val KEY_HEAD = "key_head"
    const val KEY_USERNAME = "key_username"
    const val KEY_SALT = "key_salt"
    const val KEY_SCHOOL_NUM = "key_school_num"


    fun init(context: Context) {
        this.mContext = context
    }

    fun isLogin(): Boolean {
        return mContext?.getSharedPreferences(USER_SP, Context.MODE_PRIVATE)?.getString(KEY_SALT, null) != null
    }


    fun initUser(user: User) {
        val sharedPreferences = mContext?.getSharedPreferences(USER_SP, Context.MODE_PRIVATE)
        sharedPreferences?.edit {
            putInt(KEY_HEAD, Integer.valueOf(user.uPicture))
            putString(KEY_USERNAME, user.uUsername)
            putString(KEY_SALT, user.uPwdsalt)
            putString(KEY_SCHOOL_NUM, user.uSchoolnumber)
        }
    }
}