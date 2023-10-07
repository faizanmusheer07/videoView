package com.example.videoview

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    private lateinit var playPauseButton: Button
    private lateinit var seekBar: SeekBar
    private lateinit var handler: Handler

    private var isPlaying = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoView = findViewById(R.id.videoView)
        playPauseButton = findViewById(R.id.playPauseButton)
        seekBar = findViewById(R.id.seekBar)
        handler = Handler()

        val buttonOpenPDF = findViewById<Button>(R.id.buttonOpenPDF)

        val videoPath = "android.resource://" + packageName + "/" + R.raw.glaciares
        videoView.setVideoURI(Uri.parse(videoPath))

        videoView.setOnPreparedListener(object : MediaPlayer.OnPreparedListener {
            override fun onPrepared(mp: MediaPlayer) {
                seekBar.max = videoView.duration

                playPauseButton.setOnClickListener(View.OnClickListener {
                    if (videoView.isPlaying) {
                        videoView.pause()
                        playPauseButton.text = "Play"
                    } else {
                        videoView.start()
                        playPauseButton.text = "Pause"
                    }
                })

                videoView.setOnCompletionListener(MediaPlayer.OnCompletionListener {
                    playPauseButton.text = "Play"
                })

                startSeekBarUpdate()
            }
        })
        buttonOpenPDF.setOnClickListener {
            val pdfUri = Uri.parse("sample_book.pdf") // Replace with the actual PDF file path or URL
            val intent = Intent(this, pdfViewer::class.java)
            intent.putExtra("pdfUri", pdfUri.toString())
            startActivity(intent)
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    videoView.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }

    private fun startSeekBarUpdate() {
        runOnUiThread(object : Runnable {
            override fun run() {
                if (videoView != null) {
                    val currentPosition = videoView.currentPosition
                    seekBar.progress = currentPosition
                }
                handler.postDelayed(this, 1000)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

}