package cn.kisoo.forest.util

import android.annotation.SuppressLint
import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast
import androidx.core.widget.toast

class ToastUtils {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null

        fun register(context: Context) {
            this.context = context
        }

        fun shortToast(@StringRes resId: Int) {
            context?.toast(resId)
        }

        fun longToast(@StringRes resId: Int) {
            context?.toast(resId, Toast.LENGTH_LONG)
        }
    }


}