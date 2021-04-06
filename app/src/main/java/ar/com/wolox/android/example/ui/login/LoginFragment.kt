package ar.com.wolox.android.example.ui.login

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentLoginBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class LoginFragment : WolmoFragment<FragmentLoginBinding, LoginPresenter>(), LoginView {

    override fun layout() = R.layout.fragment_login

    override fun init() {
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}