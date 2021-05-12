package ar.com.wolox.android.example.utils

import android.view.View

fun View.togglePresence(present: Boolean) {
    visibility = if (present) View.VISIBLE else View.GONE
}