package com.example.islamicapp.ui.suradetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.islamicapp.R
import com.example.islamicapp.databinding.ActivityChapterDetailsBinding
import com.example.islamicapp.ui.Constant

class ChapterDetailsActivity : AppCompatActivity() {
    var chapterindex: Int = 0
    lateinit var chaptertitle: String
    lateinit var viewBinding: ActivityChapterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolBar)
        chapterindex = intent.getIntExtra(Constant.chapter_index, 0)
        chaptertitle = intent.getStringExtra(Constant.chapter_title) ?: ""
        initViews()
        readSuraFile()
    }

    private fun readSuraFile() {
        val inputStream = assets.open("$chapterindex.txt")
        val filecontent = inputStream.bufferedReader().use { it.readText() }
        val line = filecontent.trim().split("\n")
        initRecyclerView(line)
    }

    private fun initRecyclerView(verses: List<String>) {
        val adapter = versesRecyclerAdaptet(verses)
        viewBinding.content.rvRecyclerVerses.adapter = adapter
    }

    private fun initViews() {
        viewBinding.tvTitle.text = chaptertitle

        setTitle(null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}