package com.example.videoview


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videoview.databinding.ActivityChapterItemsBinding

class ChapterAdapter(var chapterList: ArrayList<dataModel>, var context: Context) :
    RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>() {
    class ChapterViewHolder(var binding: ActivityChapterItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        return ChapterViewHolder(
            ActivityChapterItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = chapterList.size
    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        var dataList = chapterList[position]
        holder.binding.textViewCH.text = dataList.name

    }


}