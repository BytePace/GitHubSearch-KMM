import ktor.KtorGHRepoBranchDetailsDataSource
import models.RepoDetails
import utils.DateParser

class GHRepoBranchDetailsRepositoryImpl(
    private val remoteDataSource: KtorGHRepoBranchDetailsDataSource
) : GHRepoBranchDetailsRepository {
    private val dateParser = DateParser()

    override suspend fun fetchRepoDetails(
        ownerLogin: String,
        repoName: String,
        branchName: String
    ): RepoDetails {
        return remoteDataSource.getRepoDetails(ownerLogin, repoName, branchName)
            .let { dto ->
                RepoDetails(
                    name = repoName,
                    branchAuthor = dto.commit.commit.author.name,
                    branchAuthorEmail = dto.commit.commit.author.email,
                    committer = dto.commit.commit.commiter.name,
                    committerEmail = dto.commit.commit.commiter.email,
                    lastUpdatedAt = dateParser.parseTimeMillis(
                        dto.commit.commit.commiter.date
                    ),
                    isProtected = dto.commit.protected,
                )
            }
    }
}