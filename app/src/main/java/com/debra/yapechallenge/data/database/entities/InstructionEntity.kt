package com.debra.yapechallenge.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "instructions")
data class InstructionEntity(
    @ColumnInfo(name = "recipe_id") val recipeId: Int,
    @ColumnInfo(name = "step") val step: Int,
    @ColumnInfo(name = "instruction") val instruction: String
){
    @PrimaryKey
    var id: String = "$recipeId-$step"
}