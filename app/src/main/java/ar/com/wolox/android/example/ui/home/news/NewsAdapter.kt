package ar.com.wolox.android.example.ui.home.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News

class NewsAdapter(private val news: List<News>) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_new_item, parent, true)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        with(news.elementAt(position)) {
            holder.newsTitle.text = title
            holder.newsDescription.text = description
            if (isLiked) holder.likeButton.setImageResource(R.drawable.ic_like_on)
            else holder.likeButton.setImageResource(R.drawable.ic_like_off)
        }
    }
}