package net.kboy.kinniku_kt.schedule

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import net.kboy.kinniku_kt.R

class ScheduleAdapter(
    private val mValues: Array<String>
) : RecyclerView.Adapter<ScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_list_aboutapp, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val item = mValues[position]
        holder.title.text = item

        when (position) {
            1 -> {
                holder.detail.text = "1.0"
            }
            else -> {
                holder.detail.text = ""
            }
        }

        with(holder.mView) {
            tag = position
        }
    }

    override fun getItemCount(): Int = mValues.size
}