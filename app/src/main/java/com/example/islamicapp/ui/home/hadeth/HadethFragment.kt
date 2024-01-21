package com.example.islamicapp.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamicapp.databinding.FragmentHadethBinding
import com.example.islamicapp.model.Hadeth
import com.example.islamicapp.ui.Constant
import com.example.islamicapp.ui.hadethdetails.HadethDetailsAvtivity

class HadethFragment : Fragment() {
    lateinit var viewBinding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        readhadethFile()
    }

    fun readhadethFile() {
        val hadethlist = mutableListOf<Hadeth>()
        val inputestreem = context?.assets?.open("ahadeeth.txt")
        val filecontent = inputestreem?.bufferedReader().use { it?.readText() }
        val allahadeth = filecontent?.trim()?.split("#")
        allahadeth?.forEach { hadeth ->
            val lines = hadeth.trim().split("\n")

            val title = lines[0]
            val newList = lines.toMutableList().apply {
                removeAt(0)
            }
            val content = newList.joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethlist.add(hadeth)
        }
        showHadethList(hadethlist)
    }

    private fun showHadethList(hadethlist: MutableList<Hadeth>) {
        val adapter = HadethRecyclerAdapter(hadethlist)
        adapter.onitemclicklistenr = HadethRecyclerAdapter.OnItemClickListenr { item, position ->
            startHadethDetailsScreen(item)
        }
        viewBinding.hadethRecycler.adapter = adapter
    }

    private fun startHadethDetailsScreen(hadeth: Hadeth) {
        val intent = Intent(activity, HadethDetailsAvtivity::class.java)
        intent.putExtra(Constant.HadethExtra,hadeth)
        startActivity(intent)
    }
}