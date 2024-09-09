package com.example.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterPage : AppCompatActivity() {

    lateinit var cbEdad: CheckBox
    lateinit var editUser: EditText
    lateinit var editPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cbEdad = findViewById(R.id.cbEdad)
        editUser = findViewById(R.id.regUser)
        editPass = findViewById(R.id.regPass)

        val btn2: Button = findViewById(R.id.crearbtn)
        btn2.setOnClickListener{

            if (editUser.text.toString().isEmpty() || editPass.text.toString().isEmpty()) {
                var mensaje = "Completar Campos"
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
            } else {

                if(cbEdad.isChecked) {
                    val intent: Intent = Intent(this, TerminosyCondiciones:: class.java)
                    startActivity(intent)
                    finish()
                } else{
                    Toast.makeText(this, "Confirme mayoria de edad", Toast.LENGTH_SHORT)
                        .show()}
            }

            }







        }





    }