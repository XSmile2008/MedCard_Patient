package com.catandowl.medcardpatient.fragments

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catandowl.medcardpatient.R
import com.catandowl.medcardpatient.databinding.FragmentDoctorsBinding
import com.catandowl.medcardpatient.viewmodels.DoctorsViewModel

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
    }
}