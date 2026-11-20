package com.example.cookoffline.data
import android.content.Context; import androidx.room.*
@Database(entities = [IngredientEntity::class, RecipeEntity::class, RecipeIngredientEntity::class, DailyMealEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() { abstract fun ingredientDao(): IngredientDao; abstract fun recipeDao(): RecipeDao; abstract fun recipeIngredientDao(): RecipeIngredientDao; abstract fun dailyMealDao(): DailyMealDao; companion object { @Volatile private var I: AppDatabase? = null; fun get(c: Context): AppDatabase = I ?: synchronized(this) { I ?: Room.databaseBuilder(c.applicationContext, AppDatabase::class.java, "cook.db").build().also { I = it } } } }
