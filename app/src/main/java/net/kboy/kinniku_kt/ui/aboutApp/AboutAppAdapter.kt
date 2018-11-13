package net.kboy.kinniku_kt.ui.aboutApp


import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.kboy.kinniku_kt.R

class AboutAppAdapter(
    private val mValues: Array<String>,
    private val mListener: (Int) -> Unit
) : RecyclerView.Adapter<AboutAppViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val index = v.tag as Int
            mListener(index)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutAppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_aboutapp, parent, false)
        return AboutAppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AboutAppViewHolder, position: Int) {
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
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size
}
