package com.debra.yapechallenge.data.network

import com.debra.yapechallenge.constants.Constants
import com.debra.yapechallenge.data.model.RecipeDetailResponse
import com.debra.yapechallenge.data.model.RecipeNetwork
import com.debra.yapechallenge.data.model.RecipeSearchResponse
import com.debra.yapechallenge.data.model.RecipeWithInformationNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    @GET(Constants.GET_RECIPES_LIST)
    suspend fun getRecipesList(
        @Path("name") id: String,
    ): Response<RecipeSearchResponse>

    @GET(Constants.GET_RECIPE_DETAIL)
    suspend fun getRecipeDetail(
        @Path("id") id: Int,
    ): Response<RecipeWithInformationNetwork>

}