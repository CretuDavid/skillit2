package com.example.skillit

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.skillit.databinding.ExploreActivityBinding

var flag = false

class ExploreActivity : AppCompatActivity(), BookClickListener
{
    private lateinit var binding: ExploreActivityBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ExploreActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(flag == false){
            populateBooks()
            flag = true
        }

        val ExploreActivity = this

        binding.exploreRecyclerview.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = CardAdapter(bookList, ExploreActivity)
        }
        val explore_button = findViewById<CardView>(R.id.explore_button)
        val profile_button = findViewById<CardView>(R.id.profile_button)
        val home_button = findViewById<CardView>(R.id.home_button)
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
    }
    override fun onClick(book: Book)
    {
        val intent = Intent(applicationContext, VideoActivity::class.java)
        intent.putExtra(BOOK_ID_EXTRA, book.id)
        startActivity(intent)
    }


    private fun populateBooks() {
        val book1 = Book(
            R.drawable.placeholder,
            "kotlin"
        )
        bookList.add(book1)

        val book2 = Book(
            R.drawable.placeholder,
            "limite"
        )
        bookList.add(book2)

        val book3 = Book(
            R.drawable.placeholder,
            "limite2"
        )
        bookList.add(book3)
        val book4 = Book(
            R.drawable.placeholder,
            "cleste"
        )
        bookList.add(book4)
        val book5 = Book(
            R.drawable.placeholder,
            "majorari"
        )
        bookList.add(book5)
    }


}
