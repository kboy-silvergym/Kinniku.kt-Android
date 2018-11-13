package net.kboy.kinniku_kt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import net.kboy.kinniku_kt.data.Schedule
import net.kboy.kinniku_kt.repository.ScheduleRepository

class ScheduleViewModel: ViewModel() {
    private val repository = ScheduleRepository()
    val schedule: LiveData<List<Schedule>> = Transformations.map(repository.getSchedules()) { it }
}