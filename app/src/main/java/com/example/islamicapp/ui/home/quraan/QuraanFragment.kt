package com.example.islamicapp.ui.home.quraan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamicapp.databinding.FragmentQuraanBinding

class QuraanFragment :Fragment(){
lateinit var viewBinding:FragmentQuraanBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding=FragmentQuraanBinding.inflate(inflater,container,false)
        return  viewBinding.root
    }
}