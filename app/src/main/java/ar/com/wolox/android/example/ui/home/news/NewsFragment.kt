package ar.com.wolox.android.example.ui.home.news

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentNewsBinding
import ar.com.wolox.android.example.model.newsList
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<FragmentNewsBinding, NewsPresenter>(), NewsView {

    override fun layout() = R.layout.fragment_news

    override fun init() {
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            val newsAdapter = NewsAdapter(newsList(resources))
            recyclerView.adapter = newsAdapter
            swipeRefresh.setColorSchemeResources(R.color.colorAccent)
            if (newsAdapter.itemCount > 0) {
                recyclerView.visibility = View.VISIBLE
                noNewsMessage.visibility = View.GONE
            } else {
                recyclerView.visibility = View.GONE
                noNewsMessage.visibility = View.VISIBLE
            }
        }
    }

    override fun setListeners() {
        with(binding) {
            swipeRefresh.setOnRefreshListener(OnRefreshListener {
                swipeRefresh.isRefreshing = false
            })
        }
    }

    companion object {
        fun newInstance() = NewsFragment()
    }
}
