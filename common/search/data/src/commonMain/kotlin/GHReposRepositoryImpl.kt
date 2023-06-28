import ktor.KtorGHReposDataSource
import models.Repo

class GHReposRepositoryImpl(
    private val remoteDataSource: KtorGHReposDataSource,
): GHReposRepository {

    override suspend fun searchForRepos(searchPattern: String): List<Repo> {
        return remoteDataSource.searchRepos(searchPattern)
    }
}