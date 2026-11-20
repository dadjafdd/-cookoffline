package com.example.cookoffline.data
import androidx.room.withTransaction
class Repository(val db: AppDatabase) {
    suspend fun availableRecipes() = db.recipeDao().availableRecipes()
    suspend fun allIngredients() = db.ingredientDao().all()
    suspend fun planMeal(rid: Long, type: Int) { db.withTransaction { val needs = db.recipeIngredientDao().byRecipe(rid); require(needs.isNotEmpty()); needs.sortedBy { it.ingredientId }.forEach { check(db.ingredientDao().deduct(it.ingredientId, it.requiredAmount)  }; db.dailyMealDao().insert(DailyMealEntity(mealDate = "2024-01-01", mealType = type, recipeId = rid)) } }
    suspend fun seedIfEmpty() { if (db.ingredientDao().all().isNotEmpty()) return; db.withTransaction { val i1 = db.ingredientDao().insert(IngredientEntity(name = "西红柿", category = 1, stock = 5.0, unit = "个", expireDate = "2026")); val i2 = db.ingredientDao().insert(IngredientEntity(name = "鸡蛋", category = 1, stock = 10.0, unit = "个", expireDate = "2026")); val i3 = db.ingredientDao().insert(IngredientEntity(name = "盐", category = 3, stock = 1.0, unit = "袋", expireDate = "2027")); val r1 = db.recipeDao().insert(RecipeEntity(name = "西红柿炒鸡蛋", steps = "1.打蛋 2.炒", cookTime = 10)); db.recipeIngredientDao().insertAll(listOf(RecipeIngredientEntity(recipeId = r1, ingredientId = i1, requiredAmount = 2.0), RecipeIngredientEntity(recipeId = r1, ingredientId = i2, requiredAmount = 3.0), RecipeIngredientEntity(recipeId = r1, ingredientId = i3, requiredAmount = 0.1))) } }
}
