package com.drus.githubsearch.networking.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RepositoryOwner(
    @SerializedName("login")
    val userName: String
): Parcelable