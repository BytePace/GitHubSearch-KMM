package dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoundRepoDto(
    @SerialName("items")
    val list: List<FoundRepoInfoDto>
)
