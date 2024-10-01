package com.example.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.widget.Toolbar

class listabebidas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listabebidas)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn6: Button = findViewById(R.id.vermasbtn)
        btn6.setOnClickListener {

            val intent6: Intent = Intent(this, paginabebida::class.java)
            startActivity(intent6)

        }

        val btnlistabebidas_volver: Button = findViewById(R.id.listabebidas_volver)
        btnlistabebidas_volver.setOnClickListener {

            val intentlistabebidas_volver: Intent = Intent(this, MainPage::class.java)
            startActivity(intentlistabebidas_volver)

        }

        val btnvermas_son: Button = findViewById(R.id.vermas_son)
        btnvermas_son.setOnClickListener {

            Toast.makeText(this, "Página no disponible", Toast.LENGTH_SHORT).show()

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