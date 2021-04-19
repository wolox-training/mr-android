package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.example.ui.home.news.NewsFragment
import ar.com.wolox.android.example.ui.home.userProfile.UserProfileFragment
import ar.com.wolox.android.example.ui.home.fragment.HomeFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [(HomeSubcomponent::class)])
abstract class HomeModule {

    @Binds
    @IntoMap
    @ClassKey(HomeActivity::class)
    internal abstract fun bindHomeActivityFactory(
        builder: HomeSubcomponent.Builder
    ): AndroidInjector.Factory<*>

    @ContributesAndroidInjector
    internal abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector
    internal abstract fun newsFragment(): NewsFragment

    @ContributesAndroidInjector
    internal abstract fun userProfileFragment(): UserProfileFragment
}
