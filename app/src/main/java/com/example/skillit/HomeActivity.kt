package com.example.skillit

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
        home_button.setOnClickListener{
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        explore_button.setOnClickListener{
            intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
        }
        profile_button.setOnClickListener{
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

    }
}