import models.Repo

interface GHReposRepository {
    suspend fun searchForRepos(searchPattern: String): List<Repo>
}