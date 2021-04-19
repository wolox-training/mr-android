package ar.com.wolox.android.example.ui.home.fragment

import androidx.viewpager2.widget.ViewPager2
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentHomeBinding
import ar.com.wolox.android.example.ui.home.ViewPagerAdapter
import ar.com.wolox.android.example.ui.home.news.NewsFragment
import ar.com.wolox.android.example.ui.home.userProfile.UserProfileFragment
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

class HomeFragment private constructor() : WolmoFragment<FragmentHomeBinding, HomePresenter>(), HomeView {

    private lateinit var homeAdapter: ViewPagerAdapter
    private lateinit var pager: ViewPager2

    @Inject
    internal lateinit var newsFragment: NewsFragment

    @Inject
    internal lateinit var userProfileFragment: UserProfileFragment

    override fun layout() = R.layout.fragment_home

    override fun init() {
        with(binding) {
            homeAdapter = ViewPagerAdapter(requireActivity().supportFragmentManager, requireActivity().lifecycle).apply {
                addFragments(
                        newsFragment,
                        userProfileFragment
                )
            }
            pager = viewPager
            pager.adapter = homeAdapter
            tabLayout.tabMode = TabLayout.MODE_FIXED
            TabLayoutMediator(tabLayout, pager) { tab, position ->
                when (position) {
                    0 -> {
                        with(tab) {
                            text = getString(R.string.news_tab)
                            setIcon(R.drawable.ic_news_list)
                        }
                    }
                    1 -> {
                        with(tab) {
                            text = getString(R.string.user_tab)
                            setIcon(R.drawable.ic_profile)
                        }
                    }
                }
            }.attach()
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
