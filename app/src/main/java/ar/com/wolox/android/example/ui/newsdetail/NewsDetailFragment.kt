package ar.com.wolox.android.example.ui.newsdetail

import android.graphics.Typeface
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentNewsDetailBinding
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import org.ocpsoft.prettytime.PrettyTime

class NewsDetailFragment constructor(private val news: News) : WolmoFragment<FragmentNewsDetailBinding, NewsDetailPresenter>(), NewsDetailView {
    private var isLiked: Boolean = false

    override fun layout() = R.layout.fragment_news_detail

    override fun init() {
        binding.swipeRefresh.setColorSchemeResources(R.color.colorAccent)
        presenter.setNews(news)
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
            backButton.setOnClickListener { presenter.onBackButtonClicked() }
            backButtonImage.setOnClickListener { presenter.onBackButtonClicked() }
        }
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
        }
    }

    override fun goToNewsList() = HomeActivity.start(requireContext())

    override fun toggleLoadingOff() {
        binding.swipeRefresh.isRefreshing = false
    }

    override fun reloadNewsDetail(response: News?) {
        presenter.setNews(response!!)
    }

    override fun toggleLiked(liked: Boolean) {
        isLiked = if (liked) {
            binding.likeButton.setImageResource(R.drawable.ic_like_on)
            false
        } else {
            binding.likeButton.setImageResource(R.drawable.ic_like_off)
            true
        }
    }

    companion object {
        fun newInstance(news: News) = NewsDetailFragment(news)
    }
}