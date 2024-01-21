package com.example.islamicapp.ui.hadethdetails

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.islamicapp.R
import com.example.islamicapp.model.Hadeth
import com.example.islamicapp.ui.Constant

class HadethDetailsAvtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details_avtivity)

        val hadeth = intent.parcelable<Hadeth>(Constant.HadethExtra)
        hadeth?.let{

        }

    }
}
inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
    Build.VERSION.SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}