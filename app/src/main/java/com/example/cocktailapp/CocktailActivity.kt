package com.example.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CocktailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

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

        val btnotra: Button = findViewById(R.id.btnotra)
        btnotra.setOnClickListener {
            val intentCocktail: Intent = Intent(this, CocktailActivity::class.java)
            startActivity(intentCocktail)
        }

        val btn9: Button = findViewById(R.id.prinmenubtn)
        btn9.setOnClickListener {

            val intent9: Intent = Intent(this, MainPage::class.java)
            startActivity(intent9)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_deplegable, menu)

        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.itemcerrarsesion -> {
                Util.cerrarSesion(this) // Llama a la función desde la clase Util
            }

//            R.id.itemtyc -> {
//                Toast.makeText(this, "Función en proceso", Toast.LENGTH_SHORT).show()
//            }
        }
        return true
    }

}
