package net.kboy.kinniku_kt.schedule

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.view_list_aboutapp.view.*

class ScheduleViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
    val title: TextView = mView.label
    val detail: TextView = mView.label_detail
}