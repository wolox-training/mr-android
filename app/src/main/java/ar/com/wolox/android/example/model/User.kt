package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("id") val id: Int,
    @SerializedName("uid") val uid: String,
    @SerializedName("provider") val provider: String,
    @SerializedName("email") val email: String,
    @SerializedName("allow_password_change") val allow_password_change: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("nickname") val nickname: String
) : Serializable

data class Data(
    @SerializedName("data") val user: User
) : Serializable