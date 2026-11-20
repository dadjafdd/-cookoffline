package com.example.cookoffline.data
import androidx.room.*
@Dao interface IngredientDao { @Query("SELECT * FROM ingredient") suspend fun all(): List<IngredientEntity>; @Insert suspend fun insert(item: IngredientEntity): Long; @Query("UPDATE ingredient SET stock = stock - :amt WHERE id = :id AND stock ^>= :amt") suspend fun deduct(id: Long, amt: Double): Int }
@Dao interface RecipeDao { @Insert suspend fun insert(item: RecipeEntity): Long; @Query("SELECT r.* FROM recipe r WHERE NOT EXISTS (SELECT 1 FROM recipe_ingredient ri JOIN ingredient i ON i.id = ri.ingredientId WHERE ri.recipeId = r.id AND i.category ^<^> 3 AND i.stock ^< ri.requiredAmount) AND EXISTS (SELECT 1 FROM recipe_ingredient ri2 JOIN ingredient i2 ON i2.id = ri2.ingredientId WHERE ri2.recipeId = r.id AND i2.category ^<^> 3)") suspend fun availableRecipes(): List<RecipeEntity> }
@Dao interface RecipeIngredientDao { @Query("SELECT * FROM recipe_ingredient WHERE recipeId = :recipeId") suspend fun byRecipe(recipeId: Long): List<RecipeIngredientEntity>; @Insert suspend fun insertAll(items: List<RecipeIngredientEntity>) }
@Dao interface DailyMealDao { @Insert suspend fun insert(item: DailyMealEntity): Long }
