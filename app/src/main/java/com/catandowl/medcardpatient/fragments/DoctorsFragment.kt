package com.catandowl.medcardpatient.fragments

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catandowl.medcardpatient.BR
import com.catandowl.medcardpatient.R
import com.catandowl.medcardpatient.databinding.FragmentDoctorsBinding
import com.catandowl.medcardpatient.databinding.ItemDoctorBinding
import com.catandowl.medcardpatient.entities.Doctor
import com.catandowl.medcardpatient.viewmodels.DoctorsViewModel
import com.github.nitrico.lastadapter.Holder
import com.github.nitrico.lastadapter.ItemType
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
        list_doctors.layoutManager = LinearLayoutManager(context)
        list_doctors.addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                        .apply { setDrawable(ContextCompat.getDrawable(context, R.drawable.divider_empty_8dp)) }
        )

        LastAdapter(viewModel.getDoctors(), BR.doctor)
                .map<Doctor>(object : ItemType<ItemDoctorBinding>(R.layout.item_doctor) {
                    override fun onCreate(holder: Holder<ItemDoctorBinding>) {
                        super.onCreate(holder)
                        holder.binding.root.setOnClickListener {
                            toastUtils.showToast("Click: ${holder.binding.doctor}")
                        }
                    }
                }).into(list_doctors)
    }
}