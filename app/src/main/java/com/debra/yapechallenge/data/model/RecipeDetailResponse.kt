package com.debra.yapechallenge.data.model

import com.google.gson.annotations.SerializedName


data class RecipeDetailResponse(
    @SerializedName("recipe")
    val recipe: RecipeWithInformationNetwork,

)