package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.NewsRepository
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val userSession: UserSession, private val newsRepository: NewsRepository) : CoroutineBasePresenter<NewsView>() {
    override fun onViewAttached() {
        launch {
            networkRequest(newsRepository.getNews(FIRST_PAGE)) {
                onResponseSuccessful { response ->
                    view?.showNews(response, userSession.userId?.toInt()!!)
                }
                onResponseFailed { _, _ ->
                    view?.showGetNewsError()
                }
                onCallFailure {
                    view?.showConnectionError()
                }
            }
        }
    }

    fun onRefreshSwipe() = launch {
        networkRequest(newsRepository.getNews(FIRST_PAGE)) {
            onResponseSuccessful { response ->
                view?.showNews(response, userSession.userId?.toInt()!!)
            }
            onResponseFailed { _, _ ->
                view?.showGetNewsError()
            }
            onCallFailure {
                view?.showConnectionError()
            }
        }
        view?.toggleLoadingOff()
    }

    fun onScrolledToEnd(page: Int) = launch {
        networkRequest(newsRepository.getNews(page + 1)) {
            onResponseSuccessful { response ->
                if (response?.page?.isNotEmpty()!!)
                    view?.appendNews(response)
                else view?.showNoMoreNews()
            }
            onResponseFailed { _, _ ->
                view?.showGetNewsError()
            }
            onCallFailure {
                view?.showConnectionError()
            }
        }
        view?.toggleLoadingOff()
    }

    fun onResumeReloadNews() = launch {
        networkRequest(newsRepository.getNews(FIRST_PAGE)) {
            onResponseSuccessful { response ->
                view?.showNews(response, userSession.userId?.toInt()!!)
            }
            onResponseFailed { _, _ ->
                view?.showGetNewsError()
            }
            onCallFailure {
                view?.showConnectionError()
            }
        }
    }

    companion object {
        private const val FIRST_PAGE = 1
    }
}
