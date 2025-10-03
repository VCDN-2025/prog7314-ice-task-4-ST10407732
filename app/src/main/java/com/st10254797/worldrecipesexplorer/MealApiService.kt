package com.st10254797.worldrecipesexplorer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiService {

    // 1. Get a random meal
    @GET("random.php")
    fun getRandomMeal(): Call<MealResponse>

    // 2. Search meal by name
    @GET("search.php")
    fun searchMealsByName(@Query("s") query: String): Call<MealResponse>

    // 3. List all categories
    @GET("categories.php")
    fun getAllCategories(): Call<CategoryResponse>

    // 4. Filter meals by category
    @GET("filter.php")
    fun getMealsByCategory(@Query("c") category: String): Call<MealResponse>

    // 5. Get meal details by ID
    @GET("lookup.php")
    fun getMealDetails(@Query("i") id: String): Call<MealResponse>
}
