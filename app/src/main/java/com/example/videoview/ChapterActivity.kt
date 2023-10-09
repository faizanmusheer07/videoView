package com.example.videoview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.videoview.databinding.ActivityChapterBinding

class ChapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChapterBinding
    private lateinit var chapterAdapter: ChapterAdapter
    var listtheChapter = arrayListOf<dataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listtheChapter = ArrayList()


        listtheChapter.add(dataModel("chapter1: Food: Where Does it Come From"))
        listtheChapter.add(dataModel("chapter2: Components of Food"))
        listtheChapter.add(dataModel("chapter3: Fibre to Fabric"))
        listtheChapter.add(dataModel("chapter4: Sorting Materials into Groups"))
        listtheChapter.add(dataModel("chapter5: Separation of Substances"))
        listtheChapter.add(dataModel("chapter6: Changes around Us"))
        listtheChapter.add(dataModel("chapter7: Changes around Life"))



        binding.chapterrecyclerlist.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        chapterAdapter = ChapterAdapter(listtheChapter, this)
        binding.chapterrecyclerlist.adapter = chapterAdapter
    }
}