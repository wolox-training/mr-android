package ar.com.wolox.android.example.ui.home.news

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val newsTitle: TextView = view.findViewById(R.id.newsTitle)
    val newsDescription: TextView = view.findViewById(R.id.newsDescription)
    val likeButton: ImageView = view.findViewById(R.id.likeButton)
}