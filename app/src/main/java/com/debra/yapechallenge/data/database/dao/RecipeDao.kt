package com.debra.yapechallenge.data.database.dao

import androidx.room.*
import com.debra.yapechallenge.data.database.entities.IngredientEntity
import com.debra.yapechallenge.data.database.entities.InstructionEntity
import com.debra.yapechallenge.data.database.entities.RecipeEntity
import com.debra.yapechallenge.data.database.entities.RecipeInformationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Transaction
    @Query("SELECT * FROM recipes")
    fun getRecipesWithInformation(): Flow<List<RecipeInformationEntity>>

    @Transaction
    @Query("SELECT * FROM recipes WHERE id = :id")
    fun getRecipeById(id: Int): Flow<RecipeInformationEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(
        recipe: RecipeEntity,
        ingredients: List<IngredientEntity>,
        instructions: List<InstructionEntity>
    )
}