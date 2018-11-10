package net.kboy.kinniku_kt.ui.schedule

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.list_item_schedule.view.*

class ScheduleViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
    var time: TextView = mView.timeLabel
    val title: TextView = mView.titleLabel
    val detail: TextView = mView.detailLabel
}