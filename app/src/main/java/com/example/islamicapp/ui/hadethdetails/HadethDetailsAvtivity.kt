package com.example.islamicapp.ui.hadethdetails

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.islamicapp.R
import com.example.islamicapp.databinding.ActivityHadethDetailsAvtivityBinding
import com.example.islamicapp.model.Hadeth
import com.example.islamicapp.ui.Constant

class HadethDetailsAvtivity : AppCompatActivity() {
    lateinit var viewBindin: ActivityHadethDetailsAvtivityBinding
     var hadeth: Hadeth ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBindin = ActivityHadethDetailsAvtivityBinding.inflate(layoutInflater)
        setContentView(viewBindin.root)
        getHadith()
        initviews()

    }

    private fun initviews() {
        viewBindin.tvTitle.text = hadeth?.title
        viewBindin.content.hadethcontent.text=hadeth?.content

     /*   setSupportActionBar(viewBindin.toolBar)
        setTitle(null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)*/
    }


    private fun getHadith() {
         hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constant.HadethExtra, Hadeth::class.java)
        } else {
            intent.getParcelableExtra(Constant.HadethExtra)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
