package ar.com.wolox.android.example.ui.newsdetail

import android.graphics.Typeface
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentNewsDetailBinding
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import org.ocpsoft.prettytime.PrettyTime

class NewsDetailFragment constructor(private val news: News) : WolmoFragment<FragmentNewsDetailBinding, NewsDetailPresenter>(), NewsDetailView {
    private var newsDetail = news
    private var isLiked: Boolean = false

    override fun layout() = R.layout.fragment_news_detail

    override fun init() {
        binding.swipeRefresh.setColorSchemeResources(R.color.colorAccent)
    }

    override fun setListeners() {
        with(binding) {
            newsDescription.text = news.comment
            newsTitle.setTypeface(null, Typeface.BOLD)
            newsTitle.text = news.commenter
            likeButton.setOnClickListener { presenter.toggleLike(news.id, isLiked) }
            swipeRefresh.setOnRefreshListener { presenter.onRefreshSwipe(news.id) }
            val t = PrettyTime()
            newsTime.text = t.format(news.date)
        }
    }

    companion object {
        fun newInstance(news: News) = NewsDetailFragment(news)
    }

    override fun loadLikedButton(userId: String?) {
        with(binding) {
            isLiked = if (news.likes.contains(userId?.toInt())) {
                likeButton.setImageResource(R.drawable.ic_like_on)
                true
            } else {
                likeButton.setImageResource((R.drawable.ic_like_off))
                false
            }
            backButton.setOnClickListener { presenter.onBackButtonClicked() }
        }
    }

    override fun toggleLikeOn() {
        binding.likeButton.setImageResource(R.drawable.ic_like_on)
        isLiked = true
    }

    override fun toggleLikeOff() {
        binding.likeButton.setImageResource(R.drawable.ic_like_off)
        isLiked = false
    }

    override fun goToNewsList() = HomeActivity.start(requireContext())

    override fun toggleLoadingOff() {
        binding.swipeRefresh.isRefreshing = false
    }

    override fun reloadNewsDetail(response: News?) {
        newsDetail = response!!
    }
}