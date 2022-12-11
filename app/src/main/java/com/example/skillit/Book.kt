package com.example.skillit

import android.net.Uri

var bookList = mutableListOf<Book>()

val BOOK_ID_EXTRA = "bookExtra"

class Book(
    var thumbnail: Int,
    var title: String,
    val id: Int? = bookList.size
)