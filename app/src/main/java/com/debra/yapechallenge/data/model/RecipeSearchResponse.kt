package com.debra.yapechallenge.data.model

import com.google.gson.annotations.SerializedName


data class RecipeSearchResponse(
    @SerializedName("results")
    val results: List<RecipeNetwork>,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("number")
    val number: Int,
    @SerializedName("totalResults")
    val totalResults: Int
)