package com.example.videoview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.videoview.databinding.ActivityChapterItemsBinding

class ChapterItems : AppCompatActivity() {
    private lateinit var binding : ActivityChapterItemsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}