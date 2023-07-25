import models.RepoDetails

interface GHRepoBranchDetailsRepository {

    suspend fun fetchRepoDetails(
        ownerLogin: String,
        repoName: String,
        branchName: String,
    ): RepoDetails
}