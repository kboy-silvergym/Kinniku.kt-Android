package net.kboy.kinniku_kt.ui.schedule

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule.*
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.viewmodel.ScheduleViewModel

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
