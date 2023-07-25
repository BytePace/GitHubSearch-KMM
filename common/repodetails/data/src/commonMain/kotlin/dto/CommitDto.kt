package dto

import kotlinx.serialization.Serializable

@Serializable
data class CommitDto(
    val author: CommitterDto,
    val commiter: CommitterDto
)
