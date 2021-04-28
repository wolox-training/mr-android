package ar.com.wolox.android.example.ui.login

import ar.com.wolox.android.example.model.Login
import ar.com.wolox.android.example.model.User
import ar.com.wolox.android.example.network.repository.UserRepository
import ar.com.wolox.android.example.utils.Extras.MockUser.EMAIL
import ar.com.wolox.android.example.utils.Extras.MockUser.EMPTY_EMAIL
import ar.com.wolox.android.example.utils.Extras.MockUser.INVALID_EMAIL
import ar.com.wolox.android.example.utils.Extras.MockUser.INVALID_PASSWORD
import ar.com.wolox.android.example.utils.Extras.MockUser.PASSWORD
import ar.com.wolox.android.example.utils.Extras.MockUser.WRONG_EMAIL
import ar.com.wolox.android.example.utils.Extras.MockUser.WRONG_PASSWORD
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.tests.CoroutineTestRule
import ar.com.wolox.wolmo.core.tests.WolmoPresenterTest
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import ar.com.wolox.wolmo.networking.retrofit.handler.NetworkResponse
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import retrofit2.Response

@ExperimentalCoroutinesApi
class LoginPresenterTest : WolmoPresenterTest<LoginView, LoginPresenter>() {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule(runOnAllTests = true)

    @Mock
    lateinit var retrofitServices: RetrofitServices

    @Mock
    lateinit var userSession: UserSession

    @Mock
    lateinit var userRepository: UserRepository

    override fun getPresenterInstance(): LoginPresenter = LoginPresenter(userSession, userRepository)

    @Test
    fun `given an invalid email then an error is displayed`() = runBlocking {
        presenter.onLoginButtonClicked(INVALID_EMAIL, PASSWORD).join()
        verify(view, times(1)).showInvalidEmailError()
    }

    @Test
    fun `given an empty password then an error is displayed`() = runBlocking {
        presenter.onLoginButtonClicked(EMAIL, INVALID_PASSWORD).join()
        verify(view, times(1)).showEmptyPasswordError()
    }

    @Test
    fun `given an empty email then an error is displayed`() = runBlocking {
        presenter.onLoginButtonClicked(EMPTY_EMAIL, PASSWORD).join()
        verify(view, times(1)).showEmptyEmailError()
    }

    @Test
    fun `given correct credentials then the user is logged and redirected to the home screen`() = runBlocking {
        val response = Mockito.mock(Response::class.java) as Response<User>
        whenever(userRepository.loginUser(Login(EMAIL, PASSWORD))).doReturn(NetworkResponse.Success(response))
        presenter.onLoginButtonClicked(EMAIL, PASSWORD).join()
        verify(view, times(1)).toggleProgressBarPresence(true)
        verify(view, times(1)).toggleProgressBarPresence(false)
        verify(view, times(1)).logInUser()
    }

    @Test
    fun `given a wrong email then the user is not logged and a toast error message is displayed`() = runBlocking {
        val response = Mockito.mock(Response::class.java) as Response<User>
        whenever(userRepository.loginUser(Login(WRONG_EMAIL, PASSWORD))).doReturn(NetworkResponse.Error(response))
        presenter.onLoginButtonClicked(WRONG_EMAIL, PASSWORD).join()
        verify(view, times(1)).toggleProgressBarPresence(true)
        verify(view, times(1)).toggleProgressBarPresence(false)
        verify(view, times(1)).showLoginError()
    }

    @Test
    fun `given a correct email and a wrong password then the user is not logged and a toast message is displayed`() = runBlocking {
        val response = Mockito.mock(Response::class.java) as Response<User>
        whenever(userRepository.loginUser(Login(EMAIL, WRONG_PASSWORD))).doReturn(NetworkResponse.Error(response))
        presenter.onLoginButtonClicked(EMAIL, WRONG_PASSWORD).join()
        verify(view, times(1)).toggleProgressBarPresence(true)
        verify(view, times(1)).toggleProgressBarPresence(false)
        verify(view, times(1)).showLoginError()
    }
}
