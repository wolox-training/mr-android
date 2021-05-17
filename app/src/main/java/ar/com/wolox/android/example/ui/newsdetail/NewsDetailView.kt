package ar.com.wolox.android.example.ui.newsdetail

import ar.com.wolox.android.example.model.News

interface NewsDetailView {
    fun loadLikedButton(userId: String?)

    fun goToNewsList()

    fun toggleLoadingOff()

    fun reloadNewsDetail(response: News?)

    fun toggleLiked(b: Boolean)
}
