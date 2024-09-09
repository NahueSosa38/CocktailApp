package com.example.cocktailapp

import android.content.Intent
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

        val btn8: Button = findViewById(R.id.selecbtn)
        btn8.setOnClickListener {



            if (cbSinAlcohol.isChecked || cbIngredientes.isChecked){

                Toast.makeText(this, "Lista incompleta,por favor elija otra", Toast.LENGTH_SHORT)
                    .show()
            } else{

                if (cbLista.isChecked && cbIngredientes.isChecked){

                    Toast.makeText(this, "Elija solo una opcion", Toast.LENGTH_SHORT)
                        .show()
                } else {

                    if (cbLista.isChecked && cbSinAlcohol.isChecked) {

                        Toast.makeText(this, "Elija solo una opcion", Toast.LENGTH_SHORT)
                            .show()
                    }
                    else{
                        if (cbLista.isChecked && cbSinAlcohol.isChecked && cbIngredientes.isChecked) {

                        Toast.makeText(this, "Elija solo una opcion", Toast.LENGTH_SHORT)
                            .show()
                    } else{

                            if (cbSinAlcohol.isChecked && cbIngredientes.isChecked) {

                                Toast.makeText(this, "Elija solo una opcion", Toast.LENGTH_SHORT)
                                    .show()
                            } else {

                                if(cbLista.isChecked) {

                                    val intent9: Intent = Intent(this, listabebidas::class.java)
                                    startActivity(intent9)
                                } else{

                                    Toast.makeText(this, "Seleccione una lista", Toast.LENGTH_SHORT)
                                        .show()

                                }


                            }                            }
                    }
                }

            }





        }
    }

}
