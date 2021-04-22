package ar.com.wolox.android.example.model

import android.content.res.Resources
import androidx.annotation.DrawableRes
import ar.com.wolox.android.R

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
    return listOf(News(
            id = 1,
            title = resources.getString(R.string.news_title),
            image = R.drawable.ic_profile_on,
            description = resources.getString(R.string.news_description),
            duration = resources.getString(R.string.news_time),
            isLiked = true
    ),
            News(
                    id = 2,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = true
            ),
            News(
                    id = 3,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 4,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 5,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = true
            ),
            News(
                    id = 6,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = true
            ),
            News(
                    id = 7,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = true
            ),
            News(
                    id = 8,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = true
            ),
            News(
                    id = 9,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = true
            ),
            News(
                    id = 10,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 11,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 12,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 13,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 14,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 15,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 16,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 17,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 18,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 19,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ),
            News(
                    id = 20,
                    title = resources.getString(R.string.news_title),
                    image = R.drawable.ic_profile_on,
                    description = resources.getString(R.string.news_description),
                    duration = resources.getString(R.string.news_time),
                    isLiked = false
            ))
}
