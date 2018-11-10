package net.kboy.kinniku_kt.ui.aboutApp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.list_item_aboutapp.view.*

class AboutAppViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
    val title: TextView = mView.label
    val detail: TextView = mView.label_detail
}