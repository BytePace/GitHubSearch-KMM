package dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoundRepoOwnerDto(
    val login: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
)