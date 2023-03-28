package com.debra.yapechallenge.data.database.entities

import androidx.room.*
import com.debra.yapechallenge.domain.model.Ingredient
import com.debra.yapechallenge.domain.model.Instruction
import com.debra.yapechallenge.domain.model.Recipe
import com.debra.yapechallenge.domain.model.RecipeWithInformation

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "servings") val servings: Int?,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
    @ColumnInfo(name = "readyInMinutes") val readyInMinutes: Int?,
){}

data class RecipeInformationEntity(
    @Embedded val recipe: RecipeEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "recipe_id"
    )
    val instructions: List<InstructionEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "recipe_id"
    )
    val ingredients: List<IngredientEntity>
)

// Extensions

fun RecipeInformationEntity.toDomain(): RecipeWithInformation {
    return RecipeWithInformation(
        id = recipe.id,
        name = recipe.name,
        imageUrl = recipe.imageUrl,
        readyInMinutes = recipe.readyInMinutes,
        servings = recipe.servings,
        ingredients = ingredients.map { it.asDomainModel() },
        instructions = instructions.map { it.asDomainModel() }
    )
}

fun IngredientEntity.asDomainModel() = Ingredient(id, name, original, amount, unit)

fun InstructionEntity.asDomainModel() = Instruction(step, instruction)