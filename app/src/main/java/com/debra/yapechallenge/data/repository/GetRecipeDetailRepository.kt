package com.debra.yapechallenge.data.repository

import com.debra.yapechallenge.data.database.dao.RecipeDao
import com.debra.yapechallenge.data.model.toDomain
import com.debra.yapechallenge.data.network.GetRecipeDetail
import com.debra.yapechallenge.data.network.GetRecipesList
import com.debra.yapechallenge.domain.model.Recipe
import com.debra.yapechallenge.domain.model.RecipeWithInformation
import javax.inject.Inject


class GetRecipeDetailRepository @Inject constructor(
    private val api: GetRecipeDetail,
    private val recipeDao: RecipeDao
) {

    suspend fun getRecipeDetailRepository(idRecipe: Int): RecipeWithInformation? {
        val response = api.getRecipeDetail(idRecipe)
        if (response.failed) return null

        if (!response.isSuccessful) return  null

        return response.body.recipe.toDomain()
    }

    /*suspend fun getRecipeListFromDatabase(releaseYear: Int): List<Recipe> {
        val response = recipeDao.getRecipes()
        return response.map { it.toDomain }
    }*/
}
