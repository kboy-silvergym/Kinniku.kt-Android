package net.kboy.kinniku_kt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import net.kboy.kinniku_kt.data.PersonalSponsor
import net.kboy.kinniku_kt.data.Sponsor
import net.kboy.kinniku_kt.repository.SponsorRepository

class SponsorViewModel : ViewModel() {
    private val repository = SponsorRepository()
    val sponsors: LiveData<List<Sponsor>> = Transformations.map(repository.getSponsors()) { it }
    val personalSponsors: LiveData<List<PersonalSponsor>> = Transformations.map(repository.getPersonalSponsors()) { it }
}