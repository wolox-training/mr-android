package ar.com.wolox.android.example.model

data class User(
    val id: Int,
    val uid: String,
    val provider: String,
    val email: String,
    val allow_password_change: Boolean,
    val name: String,
    val nickname: String
)