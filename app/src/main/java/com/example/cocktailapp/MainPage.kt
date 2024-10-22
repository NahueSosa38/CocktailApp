package com.example.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.widget.Toolbar

class MainPage : AppCompatActivity() {
    lateinit var cbLista: CheckBox
    lateinit var cbRandom: CheckBox
    lateinit var cbSinAlcohol: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_page)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        cbLista = findViewById(R.id.cblista)
        cbRandom = findViewById(R.id.cbrandom)
        cbSinAlcohol = findViewById(R.id.cbsinalcohol)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun validarSeleccion() {
            // Verificar si no hay ninguna opción seleccionada
            if (!cbLista.isChecked && !cbSinAlcohol.isChecked && !cbRandom.isChecked) {
                Toast.makeText(this, "Elija una lista", Toast.LENGTH_SHORT).show()
                return
            }


            // Verificar si más de una opción está seleccionada
            val seleccionados = listOf(cbLista, cbRandom, cbSinAlcohol).count { it.isChecked }
            if (seleccionados > 1) {
                Toast.makeText(this, "Seleccione solo una opción", Toast.LENGTH_SHORT).show()
                return
            }

//            // Verificar si cbSinAlcohol o cbIngredientes está seleccionado sin cbLista
//            if (!cbLista.isChecked && cbSinAlcohol.isChecked) {
//                Toast.makeText(
//                    this,
//                    "Lista incompleta, por favor seleccione otra",
//                    Toast.LENGTH_SHORT
//                ).show()
//                return
//            }

            // Si todo está correcto y se seleccionó solo cbLista, proceder
            if (cbLista.isChecked) {
                val intent9 = Intent(this, listabebidas::class.java)
                startActivity(intent9)
            }

            if (cbRandom.isChecked) {
                val cbCocktail: CheckBox = findViewById(R.id.cbrandom)

                    val intentCocktail: Intent = Intent(this, CocktailActivity::class.java)
                    startActivity(intentCocktail)

            }

            if (cbSinAlcohol.isChecked) {
                val cbsinalcohol: CheckBox = findViewById(R.id.cbsinalcohol)

                val sinalcohol: Intent = Intent(this, paginabebida::class.java)
                startActivity(sinalcohol)

            }



        }

        val btn8: Button = findViewById(R.id.selecbtn)
        btn8.setOnClickListener {
            validarSeleccion()

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

            R.id.itemtyc -> {
                Toast.makeText(this, "Función en proceso", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }


}




