package net.kboy.kinniku_kt.ui.schedule

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import net.kboy.kinniku_kt.data.Schedule

class ScheduleRepository {
    private val items = mutableListOf(
        Schedule("19:00-19:20", "プロテインで乾杯", "まずはプロテインで乾杯しましょう"),
        Schedule("19:20-19:30", "プロテインで乾杯", "まずはプロテインで乾杯しましょう"),
        Schedule("19:30-19:50", "プロテインで乾杯", "まずはプロテインで乾杯しましょう")
    )
    private val schedules = MutableLiveData<List<Schedule>>()

    fun getSchedules(): LiveData<List<Schedule>> {
        schedules.value = items
        return schedules
    }
}