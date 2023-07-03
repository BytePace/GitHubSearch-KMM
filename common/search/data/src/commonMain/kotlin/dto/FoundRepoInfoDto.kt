package dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoundRepoInfoDto(
    val name: String,
    val url: String,
    val owner: FoundRepoOwnerDto,
    @SerialName("pushed_at")
    val pushedAt: String,
    val language: String,
    @SerialName("default_branch")
    val defaultBranch: String,
    @SerialName("license")
    val license: LicenseDto,
)
