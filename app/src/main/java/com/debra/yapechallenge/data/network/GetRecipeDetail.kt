package com.debra.yapechallenge.data.network

import com.debra.yapechallenge.data.model.RecipeDetailResponse
import com.debra.yapechallenge.data.model.RecipeWithInformationNetwork
import com.debra.yapechallenge.util.SimpleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class GetRecipeDetail @Inject constructor(private val api: ApiClient) {

    suspend fun getRecipeDetail(id:Int): SimpleResponse<RecipeDetailResponse> {
        return withContext(Dispatchers.IO) {
            safeApiCall { api.getRecipeDetail(id) }
        }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>):SimpleResponse<T>{
        return  try {
            SimpleResponse.success(apiCall())
        } catch (e: Exception){
            SimpleResponse.failure(e)
        }

    }
}