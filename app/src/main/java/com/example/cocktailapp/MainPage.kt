package com.example.cocktailapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainPage : AppCompatActivity() {
    lateinit var cbLista: CheckBox
    lateinit var cbSinAlcohol: CheckBox
    lateinit var cbIngredientes: CheckBox



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
            setContentView(R.layout.activity_main_page)
            cbLista = findViewById(R.id.cblista)
            cbSinAlcohol = findViewById(R.id.cbsinalcohol)
            cbIngredientes = findViewById(R.id.cbingredientes)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }


        fun validarSeleccion() {
            // Verificar si no hay ninguna opción seleccionada
            if (!cbLista.isChecked && !cbSinAlcohol.isChecked && !cbIngredientes.isChecked) {
                Toast.makeText(this, "Elija una lista", Toast.LENGTH_SHORT).show()
                return
            }

            // Verificar si más de una opción está seleccionada
            val seleccionados = listOf(cbLista, cbSinAlcohol, cbIngredientes).count { it.isChecked }
            if (seleccionados > 1) {
                Toast.makeText(this, "Seleccione solo una opción", Toast.LENGTH_SHORT).show()
                return
            }

            // Verificar si cbSinAlcohol o cbIngredientes está seleccionado sin cbLista
            if (!cbLista.isChecked && (cbSinAlcohol.isChecked || cbIngredientes.isChecked)) {
                Toast.makeText(this, "Lista incompleta, por favor seleccione otra", Toast.LENGTH_SHORT).show()
                return
            }

            // Si todo está correcto y se seleccionó solo cbLista, proceder
            if (cbLista.isChecked) {
                val intent9 = Intent(this, listabebidas::class.java)
                startActivity(intent9)
            }
        }

        val btn10: Button = findViewById(R.id.cerrarsesionbtn)
        btn10.setOnClickListener {

            val intent10 = Intent(this, LoginPage::class.java)
            startActivity(intent10)

            Toast.makeText(this, "Sesion cerrada", Toast.LENGTH_SHORT).show()
        }

        val btn8: Button = findViewById(R.id.selecbtn)
        btn8.setOnClickListener {
            validarSeleccion()

        }
    }

}
