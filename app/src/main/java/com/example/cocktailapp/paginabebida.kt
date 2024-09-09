package com.example.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class paginabebida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paginabebida)
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
}