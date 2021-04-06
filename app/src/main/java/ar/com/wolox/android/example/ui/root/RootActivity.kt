package ar.com.wolox.android.example.ui.root

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.android.example.ui.login.LoginActivity
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import javax.inject.Inject

class RootActivity : WolmoActivity<ActivityBaseBinding>(), RootView {
    @Inject
    lateinit var presenter: RootPresenter
    override fun layout() = R.layout.activity_base

    override fun init() {
        presenter.attachView(this)
    }
    override fun goToLogin() = LoginActivity.start(this)

    override fun goToHome() = HomeActivity.start(this)
}
