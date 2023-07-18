package ktor

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.accept
import io.ktor.client.request.headers
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

internal val ktorModule = DI.Module {
    bind<HttpClient>() with singleton {
        HttpClient(HttpEngineFactory().createEngine()) {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            install(HttpCache)

            install(ContentNegotiation) {
                json(json = instance())
            }

            install(HttpTimeout) {
                connectTimeoutMillis = 15_000L
                requestTimeoutMillis = 30_000L
            }

            defaultRequest {
                host = "api.github.com"
                url {
                    protocol = URLProtocol.HTTPS
                }
                headers {
                    append("Accept", "application/vnd.github+json")
                    append("X-GitHub-Api-Version", "2022-11-28")
                }
            }
        }
    }
}