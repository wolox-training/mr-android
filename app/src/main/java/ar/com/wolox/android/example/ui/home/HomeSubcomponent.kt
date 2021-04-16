package ar.com.wolox.android.example.ui.home

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface HomeSubcomponent : AndroidInjector<HomeActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeActivity>()
}
