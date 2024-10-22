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

class paginabebida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paginabebida)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn7: Button = findViewById(R.id.volverbtn)
        btn7.setOnClickListener {

            val intent7: Intent = Intent(this, listabebidas::class.java)
            startActivity(intent7)

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

            R.id.itemtyc -> {
                Toast.makeText(this, "Función en proceso", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

}