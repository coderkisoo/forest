package cn.kisoo.forest.model

import cn.kisoo.forest.R
import cn.kisoo.forest.util.ToastUtils

object UserAccountUpdateModel {

    interface UserUpdateListener {
        fun success()
        fun fail(info: String)
    }

    fun updatePassword(password1: String, password2: String, password3: String, listener: UserUpdateListener) {
        if (password2 != password3) {
            ToastUtils.shortToast(R.string.password_not_same)
            return
        }
    }

    fun updateName(name: String, listener: UserUpdateListener) {

    }

    fun updateSchoolNum(schoolNum: String, listener: UserUpdateListener) {

    }

    fun updateHead(headType: String, listener: UserUpdateListener) {

    }


}