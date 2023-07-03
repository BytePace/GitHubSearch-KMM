import ktor.KtorGHReposDataSource
import models.Repo

class GHReposRepositoryImpl(
    private val remoteDataSource: KtorGHReposDataSource,
): GHReposRepository {

    override suspend fun searchForRepos(
        searchPattern: String,
        pageNumber: Int,
        itemsPerPage: Int,
    ): List<Repo> {
        return remoteDataSource
            .searchRepository(
                searchPattern,
                pageNumber,
                itemsPerPage,
            )
            .list.map {
                Repo(
                    repoName = it.name,
                    url = it.url,
                    ownerName = it.owner.login,
                    lastUpdatedAt = it.pushedAt,
                )
            }
    }
}