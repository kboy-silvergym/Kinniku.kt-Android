package net.kboy.kinniku_kt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import net.kboy.kinniku_kt.data.Speaker
import net.kboy.kinniku_kt.repository.SpeakerRepository

class SpeakerViewModel : ViewModel() {
    private val repository = SpeakerRepository()
    val speakers: LiveData<List<Speaker>> = Transformations.map(repository.getSpeakers()) { it }

    fun vote(speaker: Speaker, point: Int){
        repository.vote(speaker, point)
    }
}