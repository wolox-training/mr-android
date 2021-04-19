package ar.com.wolox.android.example.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragment, lifecycle) {

    private val fragments: ArrayList<Fragment> = arrayListOf()
    override fun getItemCount() = fragments.size
    // override fun getItemCount(): Int = FragmentManager

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    @SafeVarargs
    fun addFragments(vararg fragment: Fragment) {
        this.fragments.addAll(fragment)
        notifyDataSetChanged()
    }
}