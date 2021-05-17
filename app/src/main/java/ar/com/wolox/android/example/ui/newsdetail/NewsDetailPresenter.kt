package ar.com.wolox.android.example.ui.newsdetail

import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.NewsRepository
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsDetailPresenter @Inject constructor(private val userSession: UserSession, private val newsRepository: NewsRepository) : CoroutineBasePresenter<NewsDetailView>() {
    private lateinit var newsDetail: News

    override fun onViewAttached() {
        view?.loadLikedButton(userSession.userId)
    }

    fun setNews(news: News) {
        newsDetail = news
    }

    fun toggleLike(newsId: Int, isLiked: Boolean) = launch {
        networkRequest(newsRepository.toggleLike(newsId)) {
            onResponseSuccessful { _ ->
                view?.toggleLiked(!isLiked)
            }
        }
    }

    fun onBackButtonClicked() {
        view?.goToNewsList()
    }

    fun onRefreshSwipe(id: Int) = launch {
        networkRequest(newsRepository.getNewsDetail(id)) {
            onResponseSuccessful { response ->
                view?.reloadNewsDetail(response)
            }
        }
        view?.toggleLoadingOff()
    }
}
