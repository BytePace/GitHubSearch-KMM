package ktor

import io.ktor.client.HttpClient
import models.Repo

class KtorGHReposDataSource(val httpClient: HttpClient) {

    suspend fun searchRepos(searchPattern: String): List<Repo> {
        return emptyList()
    }
}