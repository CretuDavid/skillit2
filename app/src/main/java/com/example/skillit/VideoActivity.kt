package com.example.skillit

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.skillit.databinding.VideoCellBinding

class VideoActivity : AppCompatActivity() {
    var mediaControlls : MediaController? = null
    var video_view : VideoView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.video_activity)
        val videoView = findViewById<VideoView>(R.id.video)
        if(mediaControlls == null){
            mediaControlls = MediaController(this)
            mediaControlls!!.setAnchorView(this.video_view)
        }
        videoView.setMediaController(mediaControlls)
        videoView.setVideoURI(Uri.parse("android.resource://"
                                    + packageName+"/"+R.raw.cleste))
        videoView.requestFocus()
        videoView.start()

        videoView.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video Completed", Toast.LENGTH_LONG).show()
        }
        videoView.setOnErrorListener { mp, what, extra ->
            Toast.makeText(applicationContext, "An Error Occurred ", Toast.LENGTH_LONG).show()
            false
        }

    }
}