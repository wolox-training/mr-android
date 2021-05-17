package ar.com.wolox.android.example.ui.newsdetail

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class NewsDetailActivity : WolmoActivity<ActivityBaseBinding>() {
    override fun layout() = R.layout.activity_base

    override fun init() {
        replaceFragment(binding.activityBaseContent.id, NewsDetailFragment.newInstance(intentData()))
    }

    private fun intentData(): News {
        return intent.extras?.getSerializable(NEWS_DETAILS) as News
    }
    companion object {
        fun start(context: Context, news: News) {
            with(Intent(context, NewsDetailActivity::class.java)) {
                putExtra(NEWS_DETAILS, news)
                context.startActivity(this)
            }
        }

        private const val NEWS_DETAILS = "news_details"
    }
}
