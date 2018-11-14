package net.kboy.kinniku_kt.ui.speaker

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_speaker.*
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.viewmodel.SpeakerViewModel

enum class SortType {
    ORDER, POINT
}

class SpeakerFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProviders.of(activity!!).get(SpeakerViewModel::class.java)
    }

    private val speakerAdapter by lazy {
        SpeakerAdapter()
    }

    var sortType: SortType = SortType.POINT

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speaker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.layoutManager = LinearLayoutManager(context)
        list.adapter = speakerAdapter

        viewModel.speakers.observe(this, Observer {
            it?.let {
                val sorted = it.sortedBy {
                    when (sortType) {
                        SortType.ORDER -> {
                            it.order.toInt()
                        }
                        SortType.POINT -> {
                            - it.point.toInt()
                        }
                    }
                }
                speakerAdapter.add(sorted)
            }
        })

        // メニューつける
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.sort_order -> {
                sortType = SortType.ORDER
            }
            R.id.sort_point -> {
                sortType = SortType.POINT
            }
        }
        speakerAdapter.notifyDataSetChanged()
        return true
    }

}

