package com.example.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class listabebidas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listabebidas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn10: Button = findViewById(R.id.cerrarsesionbtn2)
        btn10.setOnClickListener {

            val intent10 = Intent(this, LoginPage::class.java)
            startActivity(intent10)

            Toast.makeText(this, "Sesion cerrada", Toast.LENGTH_SHORT).show()
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
}