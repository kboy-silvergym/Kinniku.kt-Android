package net.kboy.kinniku_kt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import net.kboy.kinniku_kt.data.PersonalSponsor
import net.kboy.kinniku_kt.data.Sponsor

class SponsorRepository {
    private val db = FirebaseFirestore.getInstance()
    private val sponsors = MutableLiveData<List<Sponsor>>()
    private val personalSponsors = MutableLiveData<List<PersonalSponsor>>()

    fun getSponsors(): LiveData<List<Sponsor>> {
        db.collection("Sponcer")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val result = it.result

                    if (result != null)
                        sponsors.value = result.toObjects(Sponsor::class.java)
                }
            }
        return sponsors
    }

    fun getPersonalSponsors(): LiveData<List<PersonalSponsor>> {
        db.collection("PersonalSponcer")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val result = it.result

                    if (result != null)
                        personalSponsors.value = result.toObjects(PersonalSponsor::class.java)
                }
            }
        return personalSponsors
    }
}