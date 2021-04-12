package ar.com.wolox.android.example.ui.login

import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentLoginBinding
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.android.example.ui.signup.SignupActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import ar.com.wolox.wolmo.core.util.openBrowser
import javax.inject.Inject

class LoginFragment : WolmoFragment<FragmentLoginBinding, LoginPresenter>(), LoginView {

    @Inject internal lateinit var toastFactory: ToastFactory

    override fun layout() = R.layout.fragment_login

    override fun init() {
        presenter.onViewAttached()
    }

    override fun setListeners() {
        with(binding) {
            loginButton.setOnClickListener {
                presenter.onLoginButtonClicked(emailInput.text.toString(), passwordInput.text.toString())
            }
            signupButton.setOnClickListener {
                presenter.onSignupButtonClicked()
            }
            termsText.setOnClickListener {
                presenter.onTermsClicked()
            }
        }
    }

    override fun logInUser() = HomeActivity.start(requireContext())

    override fun logInError() {
        toastFactory.show(R.string.incorrect_email_password)
    }

    override fun showEmptyEmailError() {
        binding.emailInput.error = getString(R.string.field_required)
    }

    override fun showEmptyPasswordError() {
        binding.passwordInput.error = getString(R.string.field_required)
    }

    override fun showInvalidEmailError() {
        binding.emailInput.error = getString(R.string.invalid_email_address)
    }

    override fun showEmptyPasswordAndEmailError() {
        binding.emailInput.error = getString(R.string.all_fields_required)
    }

    override fun completeCredentials(email: String, password: String) {
        with(binding) {
            emailInput.setText(email)
            passwordInput.setText(password)
        }
    }

    override fun goToHome() = HomeActivity.start(requireContext())

    override fun goToSignup() = SignupActivity.start(requireContext())

    override fun openTerms(url: String) = requireContext().openBrowser(url)

    companion object {
        fun newInstance() = LoginFragment()
    }
}