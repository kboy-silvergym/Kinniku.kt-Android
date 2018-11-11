package net.kboy.kinniku_kt.ui.speaker

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_speaker.*
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.viewmodel.SpeakerViewModel

class SpeakerFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProviders.of(activity!!).get(SpeakerViewModel::class.java)
    }

    private val speakerAdapter by lazy {
        SpeakerAdapter()
    }

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
                speakerAdapter.addSchedules(it)
            }
        })
    }
}
