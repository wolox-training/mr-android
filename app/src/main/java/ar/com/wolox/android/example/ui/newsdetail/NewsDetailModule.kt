package ar.com.wolox.android.example.ui.newsdetail

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsDetailModule {

    @ContributesAndroidInjector
    internal abstract fun newsdetailActivity(): NewsDetailActivity

    @ContributesAndroidInjector
    internal abstract fun newsdetailFragment(): NewsDetailFragment
}
