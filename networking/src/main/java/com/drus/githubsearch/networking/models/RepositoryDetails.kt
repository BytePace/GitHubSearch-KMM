package com.drus.githubsearch.networking.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RepositoryDetails(
    @SerializedName("commit")
    val commit: Commit
): Parcelable

@Parcelize
data class Commit(
    @SerializedName("commit")
    val details: CommitDetails
): Parcelable

@Parcelize
data class CommitDetails(
    @SerializedName("author")
    val author: CommitAuthor
): Parcelable

@Parcelize
data class CommitAuthor(
    @SerializedName("date")
    val date: String
): Parcelable