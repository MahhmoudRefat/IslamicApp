package com.example.islamicapp.ui.home.quraan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.databinding.ItemChapterTitleBinding

class ChapterRecyclerAdapter(private val chapterList: List<String>):RecyclerView.Adapter<ChapterRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val viewBinding:ItemChapterTitleBinding =ItemChapterTitleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = chapterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val title = chapterList[position]
        holder.itemBinding.title.text = title
    }
    class ViewHolder(val itemBinding: ItemChapterTitleBinding):RecyclerView.ViewHolder(
        itemBinding.root
    ){

    }

}