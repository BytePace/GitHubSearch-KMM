package dto

import kotlinx.serialization.Serializable

@Serializable
data class CommiterDto(
    val name: String,
    val email: String,
    val date: String,
)
