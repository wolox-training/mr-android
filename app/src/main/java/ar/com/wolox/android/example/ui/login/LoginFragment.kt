package ar.com.wolox.android.example.ui.login

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentLoginBinding
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class LoginFragment : WolmoFragment<FragmentLoginBinding, LoginPresenter>(), LoginView {

    override fun layout() = R.layout.fragment_login

    override fun init() {
        presenter.onViewAttached()
    }

    override fun setListeners() {
        with(binding) {
            loginButton.setOnClickListener {
                presenter.onLoginButtonClicked(emailInput.text.toString(), passwordInput.text.toString())
            }
        }
    }

    override fun logInUser() = HomeActivity.start(requireContext())

    override fun showEmptyEmailError() {
            binding.emailInput.error = getString(R.string.field_required)
    }

    override fun showEmptyPasswordError() {
        binding.passwordInput.error = getString(R.string.field_required)
    }

    override fun showInvalidEmailError() {
        binding.emailInput.error = getString(R.string.invalid_email_address)
    }

    override fun completeCredentials(email: String, password: String) {
        with(binding) {
            emailInput.setText(email)
            passwordInput.setText(password)
        }
    }

    override fun goToHome() = HomeActivity.start(requireContext())

    companion object {
        fun newInstance() = LoginFragment()
    }
}