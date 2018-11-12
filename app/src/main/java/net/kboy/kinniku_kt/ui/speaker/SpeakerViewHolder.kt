package net.kboy.kinniku_kt.ui.speaker

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.list_item_speaker.view.*

class SpeakerViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
    var image: ImageView = mView.imageView
    val name: TextView = mView.nameLabel
    val screenName: TextView = mView.screenNameLabel
    val title: TextView = mView.titleLabel
    val reps: TextView = mView.repsLabel
}