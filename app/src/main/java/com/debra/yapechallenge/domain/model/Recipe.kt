package com.debra.yapechallenge.domain.model



data class Recipe(
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