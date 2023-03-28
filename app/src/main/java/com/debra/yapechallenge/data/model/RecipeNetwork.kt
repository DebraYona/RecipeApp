package com.debra.yapechallenge.data.model

import com.debra.yapechallenge.domain.model.Ingredient
import com.debra.yapechallenge.domain.model.Instruction
import com.debra.yapechallenge.domain.model.Recipe
import com.debra.yapechallenge.domain.model.RecipeWithInformation
import com.google.gson.annotations.SerializedName

data class RecipeNetwork(
    val id: Int,
    val name: String,
    val readyInMinutes: Int?,
    val servings: Int?,
    val imageUrl: String,
){}

data class RecipeWithInformationNetwork(
    val id: Int,
    val name: String,
    val readyInMinutes: Int?,
    val servings: Int?,
    val imageUrl: String,
    val country: String,
    val lat: Float,
    val lng: Float,
    @SerializedName("instructions")
    val instructions: List<InstructionsNetwork>?,
    @SerializedName("ingredients")
    val ingredients: List<IngredientNetwork>?
){}

data class InstructionsNetwork(
    val step: Int,
    val instruction: String,
)

data class IngredientNetwork(
    val id: Int,
    val name: String,
    val original: String,
    val amount: Float,
    val unit: String
)

fun RecipeWithInformationNetwork.toDomain(): RecipeWithInformation {
    var instructions = listOf<Instruction>()
    var ingredients = listOf<Ingredient>()

    if (this.instructions?.isNotEmpty() == true) {
        instructions = this.instructions.map {
            it.asDomainModel()
        }
    }

    if (this.ingredients?.isNotEmpty() == true) {
        ingredients = this.ingredients.map {
            it.asDomainModel()
        }
    }

    return RecipeWithInformation(
        id = id,
        name = name,
        imageUrl = imageUrl,
        readyInMinutes = readyInMinutes,
        servings = servings,
        instructions = instructions,
        ingredients = ingredients
    )
}

fun RecipeNetwork.toDomain() =
    Recipe(
        id = id,
        name = name,
        imageUrl = imageUrl,
        readyInMinutes = readyInMinutes,
        servings = servings,
    )

fun IngredientNetwork.asDomainModel() = Ingredient(id, name, original, amount, unit)

fun InstructionsNetwork.asDomainModel() = Instruction(step, instruction)

