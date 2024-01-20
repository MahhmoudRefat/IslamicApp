package com.example.islamicapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islamicapp.R
import com.example.islamicapp.databinding.ActivityMainBinding
import com.example.islamicapp.ui.home.hadeth.HadethFragment
import com.example.islamicapp.ui.home.quraan.QuraanFragment
import com.example.islamicapp.ui.home.radio.RadioFragment
import com.example.islamicapp.ui.home.sebha.SebhaFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initview()
    }

    private fun initview() {
        viewBinding.content.bottomNav.setOnItemSelectedListener { item ->
           val fragment :Fragment= when (item.itemId) {
                R.id.navigation_quraan -> {
                   QuraanFragment()
                }
                R.id.navigation_hadeth -> {
                    HadethFragment()
                }
                R.id.navigation_radio -> {
                    RadioFragment()
                }
                R.id.navigation_sebha -> {
                    SebhaFragment()
                }
               else ->{
                   QuraanFragment()
               }

            }
            pushFragment(fragment)
            true
        }
        viewBinding.content.bottomNav.selectedItemId=R.id.navigation_quraan
    }
private fun pushFragment(fragment: Fragment){
    supportFragmentManager
        .beginTransaction()
        .replace(R.id.fragment_container,fragment).commit()
}
}