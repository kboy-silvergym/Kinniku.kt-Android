package net.kboy.kinniku_kt.ui.sponsor

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.data.PersonalSponsor
import net.kboy.kinniku_kt.data.Sponsor

class SponsorAdapter(
    private val sponsorListener: (Sponsor) -> Unit,
    private val personalListener: (PersonalSponsor) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var sponsors: MutableList<Sponsor> = mutableListOf()
    private var personalSponsors: MutableList<PersonalSponsor> = mutableListOf()

    fun addSponsor(sponsor: List<Sponsor>) {
        sponsors.clear()
        sponsors.addAll(sponsor)
        notifyDataSetChanged()
    }

    fun addPersonalSponsor(personalSponsor: List<PersonalSponsor>) {
        personalSponsors.clear()
        personalSponsors.addAll(personalSponsor)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        if (position != sponsors.size) {
            return 0
        }
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_sponsor, parent, false)
            return SponsorViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_personal_sponsor, parent, false)
        return PersonalSponsorViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SponsorViewHolder) {
            val sponsor = sponsors[position]
            holder.type.text = sponsor.type
            holder.title.text = sponsor.name
            holder.detail.text = sponsor.description

            Picasso.get()
                .load(sponsor.imgURL)
                .into(holder.image)

            with(holder.mView) {
                setOnClickListener {
                    sponsorListener(sponsor)
                }
            }
        } else if (holder is PersonalSponsorViewHolder) {
            val count = position - sponsors.size
            val personalSponsor = personalSponsors[count]
            holder.screenName.text = personalSponsor.screenName

            Picasso.get()
                .load(personalSponsor.imgURL)
                .into(holder.image)

            with(holder.mView) {
                setOnClickListener {
                    personalListener(personalSponsor)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return sponsors.size + personalSponsors.size
    }
}