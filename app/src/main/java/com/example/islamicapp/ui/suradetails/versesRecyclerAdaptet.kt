package com.example.islamicapp.ui.suradetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.databinding.ItemChapterTitleBinding
import com.example.islamicapp.databinding.ItemVerseBinding

class versesRecyclerAdaptet(private val verses: List<String>) :
    RecyclerView.Adapter<versesRecyclerAdaptet.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding: ItemVerseBinding =
            ItemVerseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = verses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = verses[position]
        holder.itemBinding.content.text = title

/*        onitemclicklistenr?.let {listener->
            holder.itemView.setOnClickListener {
                listener.OnItemClick(title, position)
            }
        }*/

    }

    class ViewHolder(val itemBinding: ItemVerseBinding) : RecyclerView.ViewHolder(
        itemBinding.root
    )

    var onitemclicklistenr: OnItemClickListenr? = null

    fun interface OnItemClickListenr {
        fun OnItemClick(item: String, position: Int)
    }


}