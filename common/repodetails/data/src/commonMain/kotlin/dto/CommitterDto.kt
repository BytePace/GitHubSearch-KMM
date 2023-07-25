package dto

import kotlinx.serialization.Serializable

@Serializable
data class CommitterDto(
    val name: String,
    val email: String,
    val date: String,
)
