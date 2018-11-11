package net.kboy.kinniku_kt.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import net.kboy.kinniku_kt.data.Speaker
import net.kboy.kinniku_kt.repository.SpeakerRepository

class SpeakerViewModel : ViewModel() {
    private val repository = SpeakerRepository()
    val speakers: LiveData<List<Speaker>> = Transformations.map(repository.getSpeakers()) { it }
}