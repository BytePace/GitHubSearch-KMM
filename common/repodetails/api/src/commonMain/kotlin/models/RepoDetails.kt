package models

data class RepoDetails(
    val name: String,
    val branchAuthor: String,
    val branchAuthorEmail: String,
    val committer: String,
    val committerEmail: String,
    val lastUpdatedAt: Long,
    val isProtected: Boolean,
)