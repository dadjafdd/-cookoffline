package com.example.cookoffline.data
import androidx.room.*
@Entity(tableName = "ingredient") data class IngredientEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0, val name: String, val category: Int, val stock: Double, val unit: String, val expireDate: String?)
@Entity(tableName = "recipe") data class RecipeEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0, val name: String, val steps: String?, val cookTime: Int?)
@Entity(tableName = "recipe_ingredient") data class RecipeIngredientEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0, val recipeId: Long, val ingredientId: Long, val requiredAmount: Double)
@Entity(tableName = "daily_meal") data class DailyMealEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0, val mealDate: String, val mealType: Int, val recipeId: Long)
