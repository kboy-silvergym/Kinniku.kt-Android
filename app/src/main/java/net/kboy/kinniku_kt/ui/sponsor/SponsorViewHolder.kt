package net.kboy.kinniku_kt.ui.sponsor

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.list_item_sponsor.view.*

class SponsorViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
    var image: ImageView = mView.imageView
    val type: TextView = mView.typeLabel
    val title: TextView = mView.titleLabel
    val detail: TextView = mView.detailLabel
}