package ar.com.wolox.android.example.model

import android.content.res.Resources
import androidx.annotation.DrawableRes

data class News(
    val id: Int,
    @DrawableRes
    val image: Int?,
    val title: String,
    val description: String,
    val duration: String,
    val isLiked: Boolean

)

fun newsList(resources: Resources): List<News> {
    return listOf()
}
