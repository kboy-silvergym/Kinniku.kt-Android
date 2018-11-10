package net.kboy.kinniku_kt.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import net.kboy.kinniku_kt.data.Schedule
import net.kboy.kinniku_kt.repository.ScheduleRepository

class ScheduleViewModel: ViewModel() {
    private val repository = ScheduleRepository()
    val schedule: LiveData<List<Schedule>> = Transformations.map(repository.getSchedules()) { it }
}