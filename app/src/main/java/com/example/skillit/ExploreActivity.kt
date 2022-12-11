package com.example.skillit

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.skillit.data.ItemRoomDatabase

class ExploreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.explore_activity)

        populateVideo()

        val explore_button = findViewById<CardView>(R.id.explore_button)
        val profile_button = findViewById<CardView>(R.id.profile_button)
        val home_button = findViewById<CardView>(R.id.home_button)
        val search_button = findViewById<EditText>(R.id.search)
        home_button.setOnClickListener{
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
        explore_button.setOnClickListener{
            intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
        }
        profile_button.setOnClickListener{
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        search_button.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

                ItemRoomDatabase.getDatabase(this@ExploreActivity).itemDao().getItemsbyname(search_button.text.toString())

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
        }

    private fun populateVideo() {

    }


}