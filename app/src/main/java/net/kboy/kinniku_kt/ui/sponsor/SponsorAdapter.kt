package net.kboy.kinniku_kt.ui.sponsor

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.data.Sponsor

class SponsorAdapter : RecyclerView.Adapter<SponsorViewHolder>() {
    private var items: MutableList<Sponsor> = mutableListOf()

    fun add(sponsor: List<Sponsor>) {
        items.clear()
        items.addAll(sponsor)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SponsorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_sponsor, parent, false)
        return SponsorViewHolder(view)
    }

    override fun onBindViewHolder(holder: SponsorViewHolder, position: Int) {
        val sponsor = items[position]
        holder.type.text = sponsor.type
        holder.title.text = sponsor.name
        holder.detail.text = sponsor.description

        Picasso.get()
            .load(sponsor.imgURL)
            .into(holder.image)
    }

    override fun getItemCount(): Int = items.size
}