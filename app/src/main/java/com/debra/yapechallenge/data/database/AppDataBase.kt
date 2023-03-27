package com.debra.yapechallenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.debra.yapechallenge.data.database.dao.RecipeDao
import com.debra.yapechallenge.data.database.entities.IngredientEntity
import com.debra.yapechallenge.data.database.entities.InstructionEntity
import com.debra.yapechallenge.data.database.entities.RecipeEntity

@Database(
    version = 1,
    exportSchema = false,
    entities = [RecipeEntity::class, InstructionEntity::class, IngredientEntity::class]
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getRecipeDao(): RecipeDao

}


