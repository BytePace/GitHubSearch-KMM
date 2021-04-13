package com.drus.githubsearch.networking

import com.drus.githubsearch.networking.repository.GitHubRepository
import com.drus.githubsearch.networking.repository.GitHubRepositoryImpl
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @Provides
    fun provideNetworkService(retrofit: Retrofit): NetworkService {
        return retrofit.create(NetworkService::class.java)
    }

    @Provides
    fun provideRepository(service: NetworkService): GitHubRepository {
        return GitHubRepositoryImpl(service)
    }
}