package ar.com.wolox.android.example.ui.login

interface LoginView {
    fun logInUser()

    fun showEmptyEmailError()

    fun showInvalidEmailError()

    fun completeCredentials(email: String, password: String)

    fun showEmptyPasswordError()

    fun goToHome()
}
