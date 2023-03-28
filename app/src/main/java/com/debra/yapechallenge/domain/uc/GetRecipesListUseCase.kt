package com.debra.yapechallenge.domain.uc

import com.debra.yapechallenge.data.repository.GetRecipeListRepository
import com.debra.yapechallenge.domain.model.Recipe
import javax.inject.Inject



class GetRecipesListUseCase @Inject constructor(private val repository: GetRecipeListRepository) {

    suspend operator fun invoke(name: String): List<Recipe>? {
        return repository.getRecipeListFromApi(name)

    }
}