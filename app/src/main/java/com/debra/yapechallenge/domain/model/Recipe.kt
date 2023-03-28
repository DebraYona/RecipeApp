package com.debra.yapechallenge.domain.model

import com.debra.yapechallenge.data.database.entities.IngredientEntity
import com.debra.yapechallenge.data.database.entities.InstructionEntity
import com.debra.yapechallenge.data.database.entities.RecipeEntity
import com.debra.yapechallenge.data.database.entities.RecipeInformationEntity

data class Recipe(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val readyInMinutes: Int?,
    val servings: Int?,
)
data class RecipeWithInformation(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val readyInMinutes: Int?,
    val servings: Int?,
    val instructions: List<Instruction>?,
    val ingredients: List<Ingredient>?
)

data class Instruction(
    val step: Int,
    val instruction: String
)

data class Ingredient(
    val id: Int,
    val name: String,
    val original: String,
    val amount: Float,
    val unit: String
)

fun RecipeWithInformation.toDomain(): RecipeInformationEntity {
    val recipe = RecipeEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
        readyInMinutes = readyInMinutes,
        servings = servings,

        )
    val ingredients = ingredients?.map { ingredient ->
        IngredientEntity(
            id = ingredient.id,
            recipeId = id,
            name = ingredient.name,
            original = ingredient.original,
            amount = ingredient.amount,
            unit = ingredient.unit
        )
    }

    val instructions = instructions?.map { instruction ->
        InstructionEntity(
            recipeId = id,
            step = instruction.step,
            instruction = instruction.instruction
        )
    }
    return RecipeInformationEntity(
        recipe = recipe,
        ingredients = ingredients ?: listOf(),
        instructions = instructions ?: listOf()
    )
}




fun Recipe.toDomain() =
    Recipe(
        id = id,
        name = name,
        imageUrl = imageUrl,
        readyInMinutes = readyInMinutes,
        servings = servings,
    )