package ar.com.wolox.android.example.ui.signup

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentSignupBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class SignupFragment : WolmoFragment<FragmentSignupBinding, SignupPresenter>(), SignupView {

    override fun layout() = R.layout.fragment_signup

    override fun init() {
    }

    override fun setListeners() {
        binding.backButton.setOnClickListener {
            presenter.onBackButtonClicked()
        }
    }

    override fun goToLogin() = requireActivity().onBackPressed()

    companion object {
        fun newInstance() = SignupFragment()
    }
}