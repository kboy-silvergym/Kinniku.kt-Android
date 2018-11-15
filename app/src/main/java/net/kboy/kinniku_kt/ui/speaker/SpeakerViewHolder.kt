package net.kboy.kinniku_kt.ui.speaker

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.list_item_speaker.view.*

class SpeakerViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
    var image: ImageView = mView.imageView
    val name: TextView = mView.nameLabel
    val screenNameButton: Button = mView.screenNameLabel
    val voteButton: ImageButton = mView.voteButton
    val title: TextView = mView.titleLabel
    val reps: TextView = mView.repsLabel
}