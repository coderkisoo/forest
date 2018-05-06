package cn.kisoo.forest.util

import android.content.Context
import android.view.View
import android.widget.TextView
import cn.kisoo.forest.R

object DialogTitle {
    fun getTitleView(context: Context, textRes: Int): View {
        val view = View.inflate(context, R.layout.dialog_title, null)
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        tvTitle.setText(textRes)
        return view
    }
}