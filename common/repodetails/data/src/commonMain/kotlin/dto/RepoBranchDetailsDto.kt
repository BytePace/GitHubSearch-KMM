package dto

import kotlinx.serialization.Serializable

@Serializable
data class RepoBranchDetailsDto(
    val commit: WrappedCommitDto
)

@Serializable
data class WrappedCommitDto(
    val commit: CommitDto,
    val protected: Boolean,
)