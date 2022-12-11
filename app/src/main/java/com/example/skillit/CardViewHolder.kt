package com.example.skillit

import androidx.recyclerview.widget.RecyclerView
import com.example.skillit.databinding.VideoCellBinding


class CardViewHolder(
    private val cardCellBinding: VideoCellBinding,
    private val clickListener: BookClickListener
) : RecyclerView.ViewHolder(cardCellBinding.root)
{
    fun bindBook(book: Book)
    {
        cardCellBinding.thumbnail.setImageResource(book.thumbnail)
        cardCellBinding.title.text = book.title

        cardCellBinding.cardView.setOnClickListener{
            clickListener.onClick(book)
        }
    }
}

