package com.example.skillit

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoActivity : AppCompatActivity() {
    var mediaControlls : MediaController? = null
    var video_view : VideoView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.video_activity)
        val video_view = findViewById<VideoView>(R.id.video) as VideoView
        if(mediaControlls == null){
            mediaControlls = MediaController(this)
            mediaControlls!!.setAnchorView(this.video_view)
        }
        video_view!!.setMediaController(mediaControlls)
        video_view!!.setVideoURI(Uri.parse("android.resource://"
                                    + packageName+"/"+R.raw.video))
        video_view!!.requestFocus()
        video_view!!.start()
        

    }
}