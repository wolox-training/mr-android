package ar.com.wolox.android.example.ui.login

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<LoginView>() {

    override fun onViewAttached() {
        userSession.email?.let {
            view?.completeCredentials(it.toString(), userSession.password.toString())
        }
    }

    fun onLoginButtonClicked(email: String, password: String) {
        userSession.email = email
        userSession.password = password
        var loginError = false
        if (password.isBlank()) {
            loginError = true
            view?.showEmptyPasswordError()
        }
        if (email.isBlank()) {
            loginError = true
            view?.showEmptyEmailError()
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginError = true
            view?.showInvalidEmailError()
        }
        if (!loginError) view?.logInUser()
    }
}
