package com.debra.yapechallenge.data.network

import com.debra.yapechallenge.data.model.RecipeDetailResponse
import com.debra.yapechallenge.data.model.RecipeSearchResponse
import com.debra.yapechallenge.util.SimpleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class GetRecipesList @Inject constructor(private val api: ApiClient) {

    suspend fun getRecipesList(name:String): SimpleResponse<RecipeSearchResponse> {
        return withContext(Dispatchers.IO) {
            safeApiCall { api.getRecipesList(name) }
        }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return  try {
            SimpleResponse.success(apiCall())
        } catch (e: Exception){
            SimpleResponse.failure(e)
        }

    }
}