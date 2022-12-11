package com.example.skillit

var bookList = mutableListOf<Book>()

val BOOK_ID_EXTRA = "bookExtra"

class Book(
    var thumbnail: Int,
    var title: String,
    var link: String,
    val id: Int? = bookList.size
)