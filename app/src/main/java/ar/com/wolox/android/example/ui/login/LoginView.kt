package ar.com.wolox.android.example.ui.login

interface LoginView {
    fun logInUser()

    fun showLoginError()

    fun showConnectionError()

    fun toggleProgressBarPresence(isPresent: Boolean)

    fun showEmptyEmailError()

    fun showInvalidEmailError()

    fun showEmptyPasswordAndEmailError()

    fun completeCredentials(email: String, password: String)

    fun showEmptyPasswordError()

    fun goToHome()

    fun goToSignup()

    fun openTerms(url: String)
}
