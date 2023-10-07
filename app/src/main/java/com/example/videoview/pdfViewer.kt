package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView

class pdfViewer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)
        val pdfView = findViewById<PDFView>(R.id.pdfView)
        val pdfUriString = intent.getStringExtra("pdfUri")

        if (pdfUriString != null) {
            val pdfUri = Uri.parse(pdfUriString)
            pdfView.fromAsset("sample_book.pdf")
                .defaultPage(0)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .load()
        }
    }
}