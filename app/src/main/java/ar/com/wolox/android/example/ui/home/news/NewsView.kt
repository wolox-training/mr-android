package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.NewsPage

interface NewsView {
    fun toggleLoadingOff()

    fun showNews(response: NewsPage?, userId: Int)

    fun showGetNewsError()

    fun showConnectionError()

    fun appendNews(response: NewsPage?)

    fun showNoMoreNews()
}