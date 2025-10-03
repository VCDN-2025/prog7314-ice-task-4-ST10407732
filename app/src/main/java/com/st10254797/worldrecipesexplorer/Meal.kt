package com.st10254797.worldrecipesexplorer
// Meal.kt

data class MealResponse(
    val meals: List<Meal>
)

data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String?,
    val strArea: String?,
    val strInstructions: String?,
    val strMealThumb: String
)
data class MealSummary(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)

data class MealSummaryResponse(
    val meals: List<MealSummary>
)