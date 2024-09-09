package com.example.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TerminosyCondiciones : AppCompatActivity() {

    lateinit var btnAceptarTyC: Button
    lateinit var cbTerminosLeidos: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_terminosy_condiciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnAceptarTyC = findViewById(R.id.btnAceptarTyC)
        cbTerminosLeidos = findViewById(R.id.cbTerminosLeidos)
        btnAceptarTyC.setOnClickListener {

            if(cbTerminosLeidos.isChecked) {
                Log.i("TODO", "Se aceptan los Terminos y Condiciones")
                Toast.makeText(this, "Cuenta creada con exito ✔", Toast.LENGTH_SHORT)
                    .show()
                var intent3 = Intent(this, LoginPage::class.java)
                startActivity(intent3)
                finish()
            }

            else Toast.makeText(this, "Confirme que ha leido los TyC", Toast.LENGTH_SHORT).show()
        }
    }
}

