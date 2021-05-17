package ar.com.wolox.android.example.ui.home.news

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentNewsBinding
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.model.NewsPage
import ar.com.wolox.android.example.ui.newsdetail.NewsDetailActivity
import ar.com.wolox.android.example.utils.togglePresence
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<FragmentNewsBinding, NewsPresenter>(), NewsView {

    @Inject
    internal lateinit var toastFactory: ToastFactory
    private lateinit var layoutManager: LinearLayoutManager
    private var newsAdapter: NewsAdapter? = null
    private var currentPage = 0

    override fun layout() = R.layout.fragment_news

    override fun init() {
        with(binding) {
            layoutManager = LinearLayoutManager(context)
            recyclerView.layoutManager = layoutManager
            swipeRefresh.setColorSchemeResources(R.color.colorAccent)
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onResumeReloadNews()
    }

    override fun setListeners() {
        with(binding) {
            swipeRefresh.setOnRefreshListener {
                presenter.onRefreshSwipe()
            }
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                var firstVisibleItem = 0
                var visibleItemCount = 0
                var totalItemCount = 0

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    visibleItemCount = recyclerView.childCount
                    totalItemCount = layoutManager.itemCount
                    firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

                    if (totalItemCount - visibleItemCount <= firstVisibleItem + VISIBLE_NEWS_THRESHOLD) {
                        presenter.onScrolledToEnd(currentPage)
                    }
                }
            })
        }
    }

    override fun toggleLoadingOff() {
        binding.swipeRefresh.isRefreshing = false
    }

    override fun showNews(response: NewsPage?, userId: Int) {
        with(binding) {
            currentPage = response?.currentPage!!
            newsAdapter = response?.page?.let { NewsAdapter(it, userId, this@NewsFragment) }
            recyclerView.adapter = newsAdapter
            recyclerView.adapter.let {
                if (recyclerView.adapter!!.itemCount > 0) {
                    recyclerView.togglePresence(true)
                    noNewsMessage.togglePresence(false)
                } else {
                    recyclerView.togglePresence(false)
                    noNewsMessage.togglePresence(true)
                }
            }
        }
    }

    override fun appendNews(response: NewsPage?) {
        with(binding) {
            currentPage = response?.currentPage!!
            newsAdapter?.appendNews(response.page)
        }
    }

    override fun showNoMoreNews() {
        toastFactory.show(R.string.no_news_to_show)
    }

    override fun showGetNewsError() {
        toastFactory.show(R.string.get_news_error)
    }

    override fun showConnectionError() {
        toastFactory.show(R.string.no_connection_news)
    }

    override fun goToNewsDetail(news: News) {
        NewsDetailActivity.start(requireContext(), news)
    }

    companion object {
        fun newInstance() = NewsFragment()
        private const val VISIBLE_NEWS_THRESHOLD = 15
    }
}
