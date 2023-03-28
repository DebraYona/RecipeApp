package com.debra.yapechallenge.domain.uc

import com.debra.yapechallenge.data.repository.GetRecipeDetailRepository
import com.debra.yapechallenge.data.repository.GetRecipeListRepository
import com.debra.yapechallenge.domain.model.Recipe
import com.debra.yapechallenge.domain.model.RecipeWithInformation
import javax.inject.Inject


class GetRecipeDetailUseCase @Inject constructor(private val repository: GetRecipeDetailRepository) {

    suspend operator fun invoke(idRecipe: Int): RecipeWithInformation? {
        return repository.getRecipeDetailRepository(idRecipe)
    }
}