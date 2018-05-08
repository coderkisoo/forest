package cn.kisoo.forest.ui.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import cn.kisoo.forest.R
import cn.kisoo.forest.bean.Task
import java.util.*

class TaskListAdapter : BaseAdapter() {

    val mTasks = ArrayList<Task>()

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val task = mTasks[position]
        val view = convertView ?: View.inflate(parent.context, R.layout.item_task, null)
        var holder = view.tag as ViewHolder?
        if (holder == null) {
            holder = ViewHolder(view)
            view.tag = holder
        }
        holder.iv_result.setImageResource(if (task.isSuccess == 1.toByte()) R.mipmap.pic_center_success else R.mipmap.pic_center_died)
        holder.iv_success.setImageResource(if (task.isSuccess == 1.toByte()) R.mipmap.target_success else R.mipmap.target_fail)
        holder.tv_length.text = "完成时长：${task.tSuccessLength}分钟"
        holder.tv_target.text = "目标时长：${task.tLength}分钟"
        if (task.tStarttime != null) {
            val calendar = Calendar.getInstance()
            val timeMills = task.tStarttime?.toLong()
            if (timeMills != null) {
                calendar.timeInMillis = timeMills
                holder.tv_date.text = "${calendar.get(Calendar.YEAR)}年${calendar.get(Calendar.MONTH) + 1}月${calendar.get(Calendar.DAY_OF_MONTH)}日"
                holder.tv_time.text = "起始时间：${calendar.get(Calendar.HOUR_OF_DAY)}:${calendar.get(Calendar.MINUTE)}"
            }
        }
        return view
    }

    override fun getItem(position: Int): Any = mTasks[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = mTasks.size

    class ViewHolder(view: View) {
        val iv_result = view.findViewById<ImageView>(R.id.iv_result)
        val iv_success = view.findViewById<ImageView>(R.id.iv_success)
        val tv_length = view.findViewById<TextView>(R.id.tv_length)
        val tv_target = view.findViewById<TextView>(R.id.tv_target)
        val tv_time = view.findViewById<TextView>(R.id.tv_time)
        val tv_date = view.findViewById<TextView>(R.id.tv_date)
    }

    fun setData(tasks: List<Task>) {
        mTasks.clear()
        mTasks.addAll(tasks)
        mTasks.sortWith(Comparator { task1, task2 -> (task2.tStarttime!!.toLong() - task1.tStarttime!!.toLong()).toInt() })
        notifyDataSetChanged()
    }

}