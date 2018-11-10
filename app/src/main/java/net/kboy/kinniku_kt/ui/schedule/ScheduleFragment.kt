package net.kboy.kinniku_kt.ui.schedule

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule.*
import net.kboy.kinniku_kt.R

class ScheduleFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProviders.of(activity!!).get(ScheduleViewModel::class.java)
    }

    private val scheduleAdapter by lazy {
        ScheduleAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_schedule, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.layoutManager = LinearLayoutManager(context)
        list.adapter = scheduleAdapter

        viewModel.schedule.observe(this, Observer {
            it?.let {
                scheduleAdapter.addSchedules(it)
            }
        })
    }
}
