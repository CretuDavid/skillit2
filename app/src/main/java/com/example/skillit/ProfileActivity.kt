package com.example.skillit

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import com.example.skillit.data.InventoryApplication
import com.example.skillit.databinding.FragmentItemDetailBinding
import com.example.skillit.databinding.ProfileActivityBinding

class ProfileActivity : AppCompatActivity() {

    //private var _binding: ProfileActivityBinding? = null
    //private val binding get() = _binding!!

    private val viewModel: InventoryViewModel by viewModels {
        InventoryViewModelFactory((application as InventoryApplication).database.itemDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        //_binding = ProfileActivityBinding.inflate(LayoutInflater.from(this))
        //setContentView(binding.root)
        setContentView(R.layout.profile_activity)
        val explore_button = findViewById(R.id.explore_button) as CardView
        val profile_button = findViewById(R.id.profile_button) as CardView
        val home_button = findViewById(R.id.home_button) as CardView
        val upload_button = findViewById<CardView>(R.id.profile_upload_cardview)
        home_button.setOnClickListener{
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
        explore_button.setOnClickListener{
            intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
        profile_button.setOnClickListener{
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        upload_button.setOnClickListener{
            intent = Intent(this, UploadActivity::class.java)
            startActivity(intent)

        }

    }
}