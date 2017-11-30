package com.catandowl.medcardpatient.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.catandowl.medcardpatient.entities.Doctor
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

/**
 * Created by vladstarikov on 11/30/17.
 */
class DoctorsViewModel(firestore: FirebaseFirestore) : BaseViewModel() {

    companion object {
        val TAG: String = DoctorsViewModel::class.java.simpleName
    }

    private val doctors = MutableLiveData<List<Doctor>>()
    fun getDoctors(): LiveData<List<Doctor>> = doctors

    private var doctorsRegistration: ListenerRegistration?

    init {
        doctorsRegistration = firestore.collection("doctors").addSnapshotListener({ snapshot, e ->
            if (e == null) {
                try {
                    doctors.postValue(snapshot.documents.map { it.toObject(Doctor::class.java) })
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                Log.d(TAG, snapshot?.documents?.toString())
            } else {
                Log.w(TAG, e)
            }
        })
    }

    override fun onCleared() {
        doctorsRegistration?.remove()
        super.onCleared()
    }
}