package ar.com.wolox.android.example.ui.root

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class RootPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<RootView>() {

    override fun onViewAttached() {
        if (userSession.isUserLogged!!) {
            view?.goToHome()
        } else {
            view?.goToLogin()
        }
    }
}