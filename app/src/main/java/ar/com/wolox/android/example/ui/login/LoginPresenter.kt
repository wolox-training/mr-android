package ar.com.wolox.android.example.ui.login

import androidx.core.util.PatternsCompat
import ar.com.wolox.android.example.model.Login
import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.UserRepository
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val userSession: UserSession,
    private val userRepository: UserRepository
) : CoroutineBasePresenter<LoginView>() {

    override fun onViewAttached() {
        userSession.email?.let {
            view?.completeCredentials(it.toString(), userSession.password.toString())
        }
    }

    fun onLoginButtonClicked(email: String, password: String) = launch {
        userSession.email = email
        userSession.password = password
        var loginError = false
        if (password.isBlank() && email.isBlank()) {
            loginError = true
            view?.showEmptyPasswordAndEmailError()
        }
        if (password.isBlank()) {
            loginError = true
            view?.showEmptyPasswordError()
        }
        if (email.isBlank()) {
            loginError = true
            view?.showEmptyEmailError()
        }

        if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            loginError = true
            view?.showInvalidEmailError()
        }
        val user = Login(email = email, password = password)
        if (!loginError) {
            view?.toggleProgressBarPresence(true)
            networkRequest(userRepository.loginUser(user)) {
                onResponseSuccessful { response ->
                    userSession.userId = response?.user?.id.toString()
                    view?.logInUser()
                }
                onResponseFailed { _, _ ->
                    view?.showLoginError()
                }
                onCallFailure {
                    view?.showConnectionError()
                }
                view?.toggleProgressBarPresence(false)
            }
        }
    }

    fun onSignupButtonClicked() = view?.goToSignup()

    fun onTermsClicked() = view?.openTerms(WOLOX_URL)

    companion object {
        private const val WOLOX_URL = "www.wolox.com.ar"
    }
}
