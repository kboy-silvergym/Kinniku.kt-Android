package net.kboy.kinniku_kt.ui.speaker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.data.Speaker

class SpeakerAdapter : RecyclerView.Adapter<SpeakerViewHolder>() {
    private var items: MutableList<Speaker> = mutableListOf()

    fun addSchedules(speaker: List<Speaker>) {
        items.clear()
        items.addAll(speaker)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_speaker, parent, false)
        return SpeakerViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpeakerViewHolder, position: Int) {
        val speaker = items[position]
        holder.name.text = speaker.name
        holder.screenName.text = speaker.screenName
        holder.title.text = speaker.title
        holder.reps.text = speaker.point + "reps"
    }

    override fun getItemCount(): Int = items.size
}