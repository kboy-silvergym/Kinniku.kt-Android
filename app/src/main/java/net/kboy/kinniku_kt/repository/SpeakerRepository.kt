package net.kboy.kinniku_kt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import net.kboy.kinniku_kt.data.Speaker

class SpeakerRepository {
    private val db = FirebaseFirestore.getInstance()
    private val speakers = MutableLiveData<List<Speaker>>()

    fun getSpeakers(): LiveData<List<Speaker>> {
        db.collection("Speaker")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val result = it.result

                    if (result != null)
                        speakers.value = result.toObjects(Speaker::class.java)
                }
            }
        return speakers
    }
}