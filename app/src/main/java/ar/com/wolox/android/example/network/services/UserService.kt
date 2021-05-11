package ar.com.wolox.android.example.network.services

import ar.com.wolox.android.example.model.Data
import ar.com.wolox.android.example.model.Login
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("/auth/sign_in")
    suspend fun loginUser(@Body loginData: Login): Response<Data>
}
