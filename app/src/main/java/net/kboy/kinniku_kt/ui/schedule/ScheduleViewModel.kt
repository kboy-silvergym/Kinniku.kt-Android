package net.kboy.kinniku_kt.ui.schedule

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import net.kboy.kinniku_kt.data.Schedule

class ScheduleViewModel(private val repository: ScheduleRepository = ScheduleRepository()): ViewModel() {
    val schedule: LiveData<List<Schedule>> = Transformations.map(repository.getSchedules()) { it }
}