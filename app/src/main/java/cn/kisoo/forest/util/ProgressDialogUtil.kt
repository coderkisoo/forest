package cn.kisoo.forest.util

import android.app.ProgressDialog
import android.content.Context

object ProgressDialogUtil {

    var progressDialog: ProgressDialog? = null

    fun showProgressDialog(context: Context, title: String, message: String) {
        dismissDialog()
        progressDialog = ProgressDialog.show(context, title, message)
    }

    fun dismissDialog() {
        progressDialog?.let {
            if (it.isShowing) {
                it.dismiss()
            }
        }
    }
}