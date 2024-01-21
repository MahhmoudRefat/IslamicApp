package com.example.islamicapp.ui.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.databinding.ItemChapterTitleBinding
import com.example.islamicapp.databinding.ItemHadeathTitleBinding
import com.example.islamicapp.model.Hadeth

class HadethRecyclerAdapter(private val hadethList: List<Hadeth>) :
    RecyclerView.Adapter<HadethRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding: ItemHadeathTitleBinding =
            ItemHadeathTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = hadethList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeth = hadethList[position]
        holder.itemBinding.title.text = hadeth.title

      onitemclicklistenr?.let {listener->
            holder.itemView.setOnClickListener {
                listener.OnItemClick(hadeth, position)
            }
        }

    }

    class ViewHolder(val itemBinding: ItemHadeathTitleBinding) : RecyclerView.ViewHolder(
        itemBinding.root
    )

    var onitemclicklistenr: OnItemClickListenr? = null

    fun interface OnItemClickListenr {
        fun OnItemClick(item: Hadeth, position: Int)
    }

}
