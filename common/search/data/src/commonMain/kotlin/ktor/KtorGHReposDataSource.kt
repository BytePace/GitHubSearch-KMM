package ktor

import dto.FoundRepoDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class KtorGHReposDataSource(private val httpClient: HttpClient) {

    /**
     * Github call to fetch repos by search query that complains to Github searching patterns.
     * More info [here](https://docs.github.com/ru/rest/search/search?apiVersion=2022-11-28#search-repositories)
     *
     * @param searchPattern search query that contains one or more keywords and qualifiers.
     * @param itemsPerPage defines number of repos to be fetched per page (default=30, max=100)
     * @param pageNumber number of page to fetch since search gives lots of items
     *
     * @return [FoundRepoDto] query model cut from schema
     * */
    suspend fun searchRepository(
        searchPattern: String,
        pageNumber: Int,
        itemsPerPage: Int
    ): FoundRepoDto = httpClient
        .get("search/repositories") {
            parameter("q", searchPattern)
            parameter("per_page", itemsPerPage)
            parameter("page", pageNumber)
        }
        .body()
}