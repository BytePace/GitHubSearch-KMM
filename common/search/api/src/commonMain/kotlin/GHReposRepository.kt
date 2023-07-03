import models.Repo

interface GHReposRepository {

    suspend fun searchForRepos(
        searchPattern: String,
        pageNumber: Int,
        itemsPerPage: Int,
    ): List<Repo>
}