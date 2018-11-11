package net.kboy.kinniku_kt.ui.sponsor

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.list_item_personal_sponsor.view.*

class PersonalSponsorViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
    var image: ImageView = mView.imageView
    val screenName: TextView = mView.screenNameLabel
}