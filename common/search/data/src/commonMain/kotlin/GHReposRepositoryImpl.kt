import ktor.KtorGHReposDataSource
import models.Repo
import utils.DateParser

class GHReposRepositoryImpl(
    private val remoteDataSource: KtorGHReposDataSource,
): GHReposRepository {
    private val dateParser = DateParser()

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
                    lastUpdatedAt = dateParser.parseTimeMillis(it.pushedAt),
                )
            }
    }
}