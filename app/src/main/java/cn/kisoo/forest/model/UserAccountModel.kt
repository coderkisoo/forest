package cn.kisoo.forest.model

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Looper
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

    private const val KEY_HEAD = "key_head"
    private const val KEY_UID = "key_uid"
    private const val KEY_USERNAME = "key_username"
    private const val KET_NAME = "key_name"
    private const val KEY_SCHOOL_NUM = "key_school_num"


    fun init(context: Context) {
        this.mContext = context
    }

    fun isLogin(): Boolean {
        val uid = UID()
        return uid != "0"
    }


    fun initUser(user: User) {
        val sharedPreferences = mContext?.getSharedPreferences(USER_SP, Context.MODE_PRIVATE)
        sharedPreferences?.edit {
            putInt(KEY_HEAD, Integer.valueOf(user.uPicture))
            putString(KEY_USERNAME, user.uUsername)
            putString(KEY_SCHOOL_NUM, user.uSchoolnumber)
            putString(KEY_UID, user.uId.toString())
        }
    }

    val set = HashSet<UserUpdateListener>()

    fun registerListener(listener: UserUpdateListener) {
        set.add(listener)
    }

    fun unRegisterListener(listener: UserUpdateListener) {
        set.remove(listener)
    }

    interface UserUpdateListener {
        fun onUserStatusUpdate(status: Int)
    }

    fun notifyUpdate(status: Int) {
        mHandler.post {
            set.forEach {
                it.onUserStatusUpdate(status)
            }
        }
    }

    val mHandler = Handler(Looper.getMainLooper())

    fun UID(): String {
        val sharedPreferences = mContext?.getSharedPreferences(USER_SP, Context.MODE_PRIVATE)
        return sharedPreferences!!.getString(KEY_UID, "-1")
    }

    fun currentHead(): Int {
        val sharedPreferences = mContext?.getSharedPreferences(USER_SP, Context.MODE_PRIVATE)
        return sharedPreferences!!.getInt(KEY_HEAD, 0)
    }

    fun currentName(): String {
        val sharedPreferences = mContext?.getSharedPreferences(USER_SP, Context.MODE_PRIVATE)
        return sharedPreferences!!.getString(KET_NAME, "桥寻")
    }

    fun currentSchoolNum(): String {
        val sharedPreferences = mContext?.getSharedPreferences(USER_SP, Context.MODE_PRIVATE)
        return sharedPreferences!!.getString(KEY_SCHOOL_NUM, "2014214038")
    }

    fun currentAccount(): String {
        val sharedPreferences = mContext?.getSharedPreferences(USER_SP, Context.MODE_PRIVATE)
        return sharedPreferences!!.getString(KEY_USERNAME, "coderkisoo")
    }

    fun logout() {
        val sharedPreferences = mContext?.getSharedPreferences(USER_SP, Context.MODE_PRIVATE)
        sharedPreferences?.edit {
            clear()
            putString(KEY_UID, "-1")
        }
    }


    const val PASSWORD_UPDATE = 0
    const val HEAD_UPDATE = 1
    const val NAME_UPDATE = 2
    const val SCHOOL_NUM_UPDATE = 3

}