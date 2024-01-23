package com.example.islamicapp.ui.home.sebha

import android.R.attr.angle
import android.R.attr.pivotX
import android.R.attr.pivotY
import android.graphics.Matrix
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.islamicapp.databinding.FragmentSebhaBinding
import com.example.islamicapp.ui.Constant


class SebhaFragment : Fragment() {
    lateinit var viewBinding: FragmentSebhaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSebhaBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var temp = 0
        viewBinding.sebhaClickCard.setOnClickListener(View.OnClickListener {
            Constant.clicked_number += 1
            viewBinding.tasbehNumber.text = Constant.clicked_number.toString()
            if (Constant.clicked_number == 34) {
                Constant.clicked_number = 0
                temp += 1
                viewBinding.tasbehNumber.text = Constant.clicked_number.toString()
            }
            when (temp) {
                0 -> {
                    viewBinding.tvZekrWord.text = Constant.zekr_list.elementAt(0).toString()
                }
                1 -> {
                    viewBinding.tvZekrWord.text = Constant.zekr_list.elementAt(1).toString()
                }
                2 -> {
                    viewBinding.tvZekrWord.text = Constant.zekr_list.elementAt(2).toString()
                }
                3 -> {
                    viewBinding.tvZekrWord.text = Constant.zekr_list.elementAt(3).toString()
                }
                else -> {
                    temp = 0
                }
            }
            viewBinding.sebha.rotation = viewBinding.sebha.rotation + 5F

        })

    }

}

/*
               for (i in Constant.zekr_list.indices) {
                    viewBinding.tvZekrWord.text = Constant.zekr_list.elementAt(i).toString()
                }*/
/*  for (i in 0..Constant.zekr_list.size) {
      viewBinding.tvZekrWord.text = Constant.zekr_list.elementAt(i).toString()
  }*/