package ar.com.wolox.android.example.ui.newsdetail

import ar.com.wolox.android.example.model.News

interface NewsDetailView {
    fun loadLikedButton(userId: String?)

    fun toggleLikeOn()

    fun toggleLikeOff()

    fun goToNewsList()

    fun toggleLoadingOff()

    fun reloadNewsDetail(response: News?)
}
