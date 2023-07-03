package ktor

import dto.RepoBranchDetailsDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class KtorGHRepoBranchDetailsDataSource(
    private val httpClient: HttpClient
) {

    /**
     * Github call to get repository branch info.
     * More info [here](https://docs.github.com/ru/rest/branches/branches?apiVersion=2022-11-28#get-a-branch)
     *
     * @param ownerLogin login of repo owner
     * @param repoName name of repository
     * @param branchName name of the branch to fetch
     *
     * @return [RepoBranchDetailsDto] query model cut from schema
     * */
    suspend fun getRepoDetails(
        ownerLogin: String,
        repoName: String,
        branchName: String,
    ): RepoBranchDetailsDto = httpClient
        .get("repos/$ownerLogin/$repoName/branches/$branchName")
        .body()
}