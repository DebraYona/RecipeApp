package com.debra.yapechallenge.data.repository

import com.debra.yapechallenge.data.database.dao.RecipeDao
import com.debra.yapechallenge.data.model.RecipeNetwork
import com.debra.yapechallenge.data.model.RecipeSearchResponse
import com.debra.yapechallenge.data.model.toDomain
import com.debra.yapechallenge.data.network.GetRecipesList
import com.debra.yapechallenge.domain.model.Recipe
import javax.inject.Inject


class GetRecipeListRepository @Inject constructor(
    private val api: GetRecipesList,
    private val recipeDao: RecipeDao
) {

    suspend fun getRecipeListFromApi(name: String): List<Recipe>? {
        val response = api.getRecipesList(name)
        if (response.failed) return null

        if (!response.isSuccessful) return  null

        return response.body.results.map { it.toDomain() }
    }

    /*suspend fun getRecipeListFromDatabase(releaseYear: Int): List<Recipe> {
        val response = recipeDao.getRecipes()
        return response.map { it.toDomain }
    }*/
}

