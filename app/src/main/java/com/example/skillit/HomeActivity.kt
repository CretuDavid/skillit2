package com.example.skillit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.home_activity)
        val explore_button = findViewById<CardView>(R.id.explore_button) as CardView
        val profile_button = findViewById<CardView>(R.id.profile_button) as CardView
        val home_button = findViewById<CardView>(R.id.home_button) as CardView
        val firstvideo = findViewById<CardView>(R.id.home_recommended_video_1_cardview) as CardView
        home_button.setOnClickListener{
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        explore_button.setOnClickListener{
            intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        profile_button.setOnClickListener{
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        firstvideo.setOnClickListener{
            intent = Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }


    }
}