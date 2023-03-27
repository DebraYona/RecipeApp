package com.debra.yapechallenge.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
data class IngredientEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "recipe_id") val recipeId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "original") val original: String,
    @ColumnInfo(name = "amount") val amount: Float,
    @ColumnInfo(name = "unit") val unit: String,
){}