package net.kboy.kinniku_kt.ui.speaker

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_speaker.*
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.data.Speaker
import net.kboy.kinniku_kt.ui.MainActivity
import net.kboy.kinniku_kt.ui.WebViewFragment
import net.kboy.kinniku_kt.viewmodel.SpeakerViewModel

enum class SortType {
    ORDER, POINT
}

class SpeakerFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProviders.of(activity!!).get(SpeakerViewModel::class.java)
    }

    private val speakerAdapter by lazy {
        SpeakerAdapter({
            // twitter
            showTwitter(it)
        }, {
            // vote
            showVoteDialog(it)
        })
    }

    private var sortType: SortType = SortType.ORDER

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
                speakerAdapter.add(it, sortType)
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
        speakerAdapter.update(sortType)
        return true
    }

    private fun showTwitter(speaker: Speaker) {
        val url = "https://twitter.com/" + speaker.screenName
        val fragment =
            WebViewFragment.create(url)
        showFragment(fragment)
    }

    private fun showVoteDialog(speaker: Speaker){
        val items: Array<String> = arrayOf("デカイ！(3reps)", "肩メロン！(2reps)", "キレてる！(1reps)")
        var checkedItemIndex = 0
        AlertDialog
            .Builder(activity!!)
            .setTitle("${speaker.name}の筋肉は?")
            .setSingleChoiceItems(items, 0) { _, i ->
                checkedItemIndex = i
            }
            .setPositiveButton("OK") { _, _ ->
                vote(speaker, checkedItemIndex)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun vote(speaker: Speaker, index: Int){
        var addPoint = 1
        when (index) {
            0 -> {
                addPoint = 3
            }
            1 -> {
                addPoint = 2
            }
            2 -> {
                addPoint = 1
            }
        }
        // vote to firebase
        val newPoint = speaker.point + addPoint
        viewModel.vote(speaker, newPoint)

    }

    private fun showFragment(fragment: Fragment) {
        (activity as MainActivity).showFragment(fragment)
    }
}

