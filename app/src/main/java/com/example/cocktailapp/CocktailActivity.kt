package com.example.cocktailapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CocktailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail)

        val cocktailName: TextView = findViewById(R.id.cocktail_name)
        val cocktailImage: ImageView = findViewById(R.id.cocktail_image)
        val cocktailTags: TextView = findViewById(R.id.cocktail_tags)
        val cocktailCategory: TextView = findViewById(R.id.cocktail_category)

        RetrofitInstance.api.getRandomCocktail().enqueue(object : Callback<Cocktail> {
            override fun onResponse(call: Call<Cocktail>, response: Response<Cocktail>) {
                val drink = response.body()?.drinks?.firstOrNull()
                drink?.let {
                    cocktailName.text = it.strDrink

                    // Verificamos si strTags es null y asignamos el texto correspondiente
                    cocktailTags.text = it.strTags ?: "Sin etiqueta"

                    cocktailCategory.text = it.strCategory
                    Glide.with(this@CocktailActivity)
                        .load(it.strDrinkThumb)
                        .into(cocktailImage)
                }
            }

            override fun onFailure(call: Call<Cocktail>, t: Throwable) {
                // Manejar error
            }
        })
    }
}
