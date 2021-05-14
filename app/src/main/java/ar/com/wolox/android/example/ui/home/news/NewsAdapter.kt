package ar.com.wolox.android.example.ui.home.news

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News

class NewsAdapter(private val news: ArrayList<News>, private val userId: Int, private val newsView: NewsView) : RecyclerView.Adapter<NewsViewHolder>() {
    private var newsList = news
    private var currentUserId = userId
    private var view = newsView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_new_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        with(newsList.elementAt(position)) {

            holder.newsTitle.setTypeface(null, Typeface.BOLD)
            holder.newsTitle.text = commenter
            holder.newsDescription.text = comment
            if (likes.contains(currentUserId)) {
                holder.likeButton.setImageResource(R.drawable.ic_like_on)
            } else {
                holder.likeButton.setImageResource((R.drawable.ic_like_off))
            }
            holder.newsLayout.setOnClickListener {
                newsView.goToNewsDetail(this)
            }
        }
    }

    fun appendNews(newNews: List<News>) {
        newsList.addAll(newNews)
        notifyDataSetChanged()
    }
}