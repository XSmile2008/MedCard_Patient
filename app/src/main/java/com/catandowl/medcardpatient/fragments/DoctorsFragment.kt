package com.catandowl.medcardpatient.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catandowl.medcardpatient.BR
import com.catandowl.medcardpatient.R
import com.catandowl.medcardpatient.databinding.FragmentDoctorsBinding
import com.catandowl.medcardpatient.entities.Doctor
import com.catandowl.medcardpatient.viewmodels.DoctorsViewModel
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.fragment_doctors.*

/**
 * Created by vladstarikov on 11/30/17
 */
class DoctorsFragment : BaseFragment() {

    private lateinit var viewModel: DoctorsViewModel
    private lateinit var binding: FragmentDoctorsBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DoctorsViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_doctors, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val doctorsList = ObservableArrayList<Doctor>()
        viewModel.getDoctors().observe(this, Observer { doctors ->
            doctorsList.clear()
            if (doctors != null) {
                doctorsList.addAll(doctors)
            }
        })
        list_doctors.layoutManager = LinearLayoutManager(context)
        LastAdapter(doctorsList, BR.doctor)
                .map<Doctor>(R.layout.item_doctor)
                .into(list_doctors)
    }
}