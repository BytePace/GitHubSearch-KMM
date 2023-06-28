package models

data class Repo(
    val repoName: String,
    val url: String,
    val ownerName: String,
    val lastUpdatedAt: Long,
)
