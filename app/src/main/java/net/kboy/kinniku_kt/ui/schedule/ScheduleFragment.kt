package net.kboy.kinniku_kt.ui.schedule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule.view.*
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.data.Schedule


class ScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_schedule, container, false)
        val listView = view.list

        with(listView) {
            layoutManager = LinearLayoutManager(context)

            val mock = Schedule("19:00-19:20", "プロテインで乾杯", "まずはプロテインで乾杯しましょう")
            adapter = ScheduleAdapter(arrayOf(mock, mock, mock))
        }
        return view
    }
}
