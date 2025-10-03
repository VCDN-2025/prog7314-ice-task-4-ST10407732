package com.st10254797.worldrecipesexplorer

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var btnRandomMeal: Button
    private lateinit var imgMeal: ImageView
    private lateinit var txtMealName: TextView
    private lateinit var txtInstructions: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRandomMeal = findViewById(R.id.btnRandomMeal)
        imgMeal = findViewById(R.id.imgMeal)
        txtMealName = findViewById(R.id.txtMealName)
        txtInstructions = findViewById(R.id.txtInstructions)

        btnRandomMeal.setOnClickListener {
            Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show()
            getRandomMeal()
        }
    }

    private fun getRandomMeal() {
        RetrofitClient.instance.getRandomMeal().enqueue(object : Callback<MealResponse> {
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                if (response.isSuccessful) {
                    val meal = response.body()?.meals?.firstOrNull()
                    if (meal != null) {
                        txtMealName.text = meal.strMeal
                        txtInstructions.text = meal.strInstructions ?: "No instructions"
                        Glide.with(this@MainActivity).load(meal.strMealThumb).into(imgMeal)
                    } else {
                        Toast.makeText(this@MainActivity, "No meal data found", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Response not successful: ${response.code()}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Network error: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }

}
