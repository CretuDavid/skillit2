package com.example.skillit

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.skillit.data.InventoryApplication

class UploadActivity : AppCompatActivity (){
    private val viewModel: InventoryViewModel by viewModels {
        InventoryViewModelFactory((application as InventoryApplication).database.itemDao())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.upload_activity)

        val upload_button = findViewById<Button>(R.id.upload)
        val link = findViewById<EditText>(R.id.link)
        val title = findViewById<EditText>(R.id.title)

        upload_button.setOnClickListener{
            viewModel.addNewItem(link.text.toString(), title.text.toString())
        }
    }
}