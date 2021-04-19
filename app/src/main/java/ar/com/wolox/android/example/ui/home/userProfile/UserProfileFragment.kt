package ar.com.wolox.android.example.ui.home.userProfile

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentUserprofileBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class UserProfileFragment @Inject constructor() : WolmoFragment<FragmentUserprofileBinding, UserProfilePresenter>(), UserProfileView {

    override fun layout() = R.layout.fragment_userprofile

    override fun init() {
    }

    companion object {
        fun newInstance() = UserProfileFragment()
    }
}
