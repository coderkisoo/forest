package cn.kisoo.forest.ui.window

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView
import cn.kisoo.forest.R
import cn.kisoo.forest.util.DpConvertUtil

class HeadSelectorAdapter(headArrays: Array<Int>) : BaseAdapter() {

    val mHeads = headArrays

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = View.inflate(parent.context, R.layout.item_head_selector, null)
        val param = AbsListView.LayoutParams(DpConvertUtil.dip2px(parent.context,80f),DpConvertUtil.dip2px(parent.context,80f))
        view.layoutParams = param
        val imageView = view.findViewById<ImageView>(R.id.iv_head)
        imageView.setImageResource(mHeads[position])
        return view
    }

    override fun getItem(position: Int): Any = mHeads[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = mHeads.size

}