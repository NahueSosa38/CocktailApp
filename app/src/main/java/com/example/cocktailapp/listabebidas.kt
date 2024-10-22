package com.example.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class listabebidas : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bebidaAdapter: BebidaAdapter
    private val listaBebidas = mutableListOf<Drink>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listabebidas)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Inicializa el RecyclerView
        recyclerView = findViewById(R.id.recyclerViewBebidas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializa el adaptador con la lista vacía
        bebidaAdapter = BebidaAdapter(listaBebidas)
        recyclerView.adapter = bebidaAdapter

        // Llama a la API para obtener las bebidas
        obtenerBebidas()

        val btn9: Button = findViewById(R.id.listabebidas_volver)
        btn9.setOnClickListener {

            val intent9: Intent = Intent(this, MainPage::class.java)
            startActivity(intent9)
        }

    }

    private fun obtenerBebidas() {
        RetrofitInstance.api.getCocktailList().enqueue(object : Callback<Cocktail> {
            override fun onResponse(call: Call<Cocktail>, response: Response<Cocktail>) {
                val drinks = response.body()?.drinks
                drinks?.let {
                    listaBebidas.addAll(it) // Agrega todas las bebidas a la lista
                    bebidaAdapter.notifyDataSetChanged() // Notifica al adaptador que los datos han cambiado
                }

            }

            override fun onFailure(call: Call<Cocktail>, t: Throwable) {
                // Manejar error
            }
        })
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

            R.id.itemtyc -> {
                Toast.makeText(this, "Función en proceso", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

}