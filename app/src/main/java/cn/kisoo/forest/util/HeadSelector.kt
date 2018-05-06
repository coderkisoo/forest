package cn.kisoo.forest.util

import android.app.Activity
import android.support.v7.app.AlertDialog
import android.widget.AdapterView
import android.widget.GridView
import cn.kisoo.forest.R
import cn.kisoo.forest.ui.window.HeadSelectorAdapter

object HeadSelectorUtil {

    val mHeadList = arrayOf(R.mipmap.head_1, R.mipmap.head_2, R.mipmap.head_3, R.mipmap.head_4,
            R.mipmap.head_5, R.mipmap.head_6, R.mipmap.head_7, R.mipmap.head_8)


    fun selectHead(activity: Activity, selector: HeadSelector) {
        var alerDialog: AlertDialog? = null
        val view = activity.layoutInflater.inflate(R.layout.head_selector, null)
        val gridView = view.findViewById(R.id.gv_head_list) as GridView
        gridView.adapter = HeadSelectorAdapter(mHeadList)
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            selector.onHeadSelect(position)
            alerDialog?.dismiss()
        }
        alerDialog = AlertDialog.Builder(activity)
                .setTitle(R.string.please_select_head)
                .setNegativeButton(R.string.cancel) { dialog, _ -> dialog.dismiss() }
                .setView(view)
                .create()
        alerDialog.show()
    }

    interface HeadSelector {
        fun onHeadSelect(headType: Int)
    }
}


