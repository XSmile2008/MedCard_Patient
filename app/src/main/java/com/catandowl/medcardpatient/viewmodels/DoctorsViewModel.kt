package com.catandowl.medcardpatient.viewmodels

import android.databinding.ObservableArrayList
import android.util.Log
import com.catandowl.medcardpatient.consts.DOCTOR_ID
import com.catandowl.medcardpatient.entities.Doctor
import com.catandowl.medcardpatient.events.NavigationEvent
import com.catandowl.medcardpatient.fragments.DoctorDetailsFragment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

/**
 * Created by vladstarikov on 11/30/17.
 */
class DoctorsViewModel(firestore: FirebaseFirestore) : BaseViewModel() {

    companion object {
        val TAG: String = DoctorsViewModel::class.java.simpleName
    }

    private val doctors = ObservableArrayList<Doctor>()
    fun getDoctors(): List<Doctor> = doctors

    private var doctorsRegistration: ListenerRegistration?

    init {
        doctorsRegistration = firestore.collection("doctors").addSnapshotListener({ snapshot, e ->
            if (e == null) {
                doctors.clear()
                doctors.addAll(snapshot.documents.map { it.toObject(Doctor::class.java) })
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

    fun onItemClicked(doctor: Doctor) {
        navigation.postValue(NavigationEvent(DoctorDetailsFragment::class.java, mapOf(DOCTOR_ID to "asdfsadf")))
    }
}