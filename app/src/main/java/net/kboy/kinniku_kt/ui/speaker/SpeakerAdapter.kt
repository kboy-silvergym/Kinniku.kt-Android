package net.kboy.kinniku_kt.ui.speaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.data.Speaker

class SpeakerAdapter(
    private val screenNameListener: (Speaker) -> Unit,
    private val voteListener: (Speaker) -> Unit
) : RecyclerView.Adapter<SpeakerViewHolder>() {
    private var items: MutableList<Speaker> = mutableListOf()

    fun add(speaker: List<Speaker>, sortType: SortType) {
        val sorted = sort(speaker, sortType)
        items.clear()
        items.addAll(sorted)
        notifyDataSetChanged()
    }

    fun update(sortType: SortType) {
        add(items, sortType)
    }

    private fun sort(speakers: List<Speaker>, sortType: SortType):  List<Speaker> {
        return speakers.sortedBy {
            when (sortType) {
                SortType.ORDER -> {
                    it.order.toInt()
                }
                SortType.POINT -> {
                    - it.point.toInt()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_speaker, parent, false)
        return SpeakerViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpeakerViewHolder, position: Int) {
        val speaker = items[position]
        holder.name.text = speaker.name
        holder.screenNameButton.text = "@" + speaker.screenName
        holder.title.text = speaker.title
        holder.reps.text = speaker.point + "reps"

        Picasso.get()
            .load(speaker.imgURL)
            .into(holder.image)

        with(holder.screenNameButton) {
            setOnClickListener {
                screenNameListener(speaker)
            }
        }
        with(holder.voteButton) {
            setOnClickListener {
                voteListener(speaker)
            }
        }
    }

    override fun getItemCount(): Int = items.size
}