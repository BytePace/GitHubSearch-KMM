package dto

import kotlinx.serialization.Serializable

@Serializable
data class CommitDto(
    val author: CommiterDto,
    val commiter: CommiterDto
)
