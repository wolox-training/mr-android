package ar.com.wolox.android.example.network.services

import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.model.NewsPage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsService {

    @GET("/comments")
    suspend fun getNews(@Query("page") page: Int): Response<NewsPage>

    @PUT("/comments/like/{id}")
    suspend fun toggleLike(@Path("id") id: Int): Response<News>

    @GET("/comments/{id}")
    suspend fun getNewsDetails(@Path("id") id: Int): Response<News>
}
