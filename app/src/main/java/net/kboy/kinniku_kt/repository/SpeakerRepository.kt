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
            .addSnapshotListener { snapshot, e ->

                if (snapshot != null) {
                    speakers.value = snapshot.toObjects(Speaker::class.java)
                }
            }
        return speakers
    }
}