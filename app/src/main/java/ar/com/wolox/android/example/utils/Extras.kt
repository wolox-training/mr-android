package ar.com.wolox.android.example.utils

import android.app.Activity
import android.content.SharedPreferences
import androidx.fragment.app.Fragment

/**
 * Util class to store keys to use with [SharedPreferences] or as argument between
 * [Fragment] or [Activity].
 */
object Extras {

    object UserLogin {
        const val USERNAME = "username"
        const val EMAIL = "email"
        const val PASSWORD = "password"
        const val ACCESS_TOKEN = "access_token"
        const val UID = "uid"
        const val CLIENT = "client"
    }

    object ViewPager {
        const val FAVOURITE_COLOR_KEY = "FAVOURITE_COLOR_KEY"
    }

    object MockUser {
        const val EMAIL = "susan.stevens38@example.com"
        const val PASSWORD = "12345678"
        const val INVALID_EMAIL = "invalidEmail"
        const val INVALID_PASSWORD = ""
        const val EMPTY_EMAIL = ""
        const val WRONG_EMAIL = "wrong@email.com"
        const val WRONG_PASSWORD = "invalidPassword"
    }
}
