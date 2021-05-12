package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Date

data class News(
    @SerializedName("id") val id: Int,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("commenter") val commenter: String,
    @SerializedName("comment") val comment: String,
    @SerializedName("date") val date: Date,
    @SerializedName("likes") val likes: Array<Int>,
    @SerializedName("created_at") val created_at: Date,
    @SerializedName("updated_at") val updated_at: Date

) : Serializable

data class NewsPage(
    @SerializedName("count") val count: Int,
    @SerializedName("total_pages") val pages: Int,
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("current_page") val currentPage: Int,
    @SerializedName("previous_page") val previousPage: Int?,
    @SerializedName("next_page") val nextPage: Int?,
    @SerializedName("next_page_url") val nextPageUrl: String,
    @SerializedName("previous_page_url") val previousPageUrl: String,
    val page: ArrayList<News>

) : Serializable