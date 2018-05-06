package cn.kisoo.forest.ui.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ImageView
import cn.kisoo.forest.R
import cn.kisoo.forest.bean.UserAchievement
import com.bumptech.glide.Glide

class AwardListAdapter : BaseAdapter(), AdapterView.OnItemClickListener {

    private val mAwardList = ArrayList<UserAchievement>()

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = View.inflate(parent.context, R.layout.item_award, null)
        val imageView = view.findViewById<ImageView>(R.id.iv_award)
        Glide.with(parent.context).load(mAwardList[position].achiPicture).into(imageView)
        return view
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int = mAwardList.size

    fun setData(list: List<UserAchievement>) {
        mAwardList.clear()
        mAwardList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {

    }
}