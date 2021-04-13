package com.drus.githubsearch.networking.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SimpleRepositoryInfo(
    @SerializedName("name")
    val repositoryName: String,
    @SerializedName("url")
    val repositoryURL: String,
    @SerializedName("owner")
    val repositoryOwner: RepositoryOwner,
    @SerializedName("pushed_at")
    val date: String
): Parcelable