package com.example.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginPage : AppCompatActivity() {
    lateinit var etEditUser: EditText
    lateinit var etEditPass: EditText
    lateinit var cbUser: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        etEditUser = findViewById(R.id.editUser)
        etEditPass = findViewById(R.id.editPass)
        cbUser = findViewById(R.id.cbUser)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn1: Button = findViewById(R.id.inibtn)
        btn1.setOnClickListener {


            if (etEditUser.text.toString().isEmpty() || etEditPass.text.toString().isEmpty()) {
                var mensaje = "Completar Campos"
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
            } else {

                if(cbUser.isChecked) {
                    Log.i("TODO","Funcionalidad de recordar usuario")
                }

                val intent1: Intent = Intent(this, MainPage::class.java)
                startActivity(intent1)

            }
        }
        val btn: Button = findViewById(R.id.rgtbtn)
        btn.setOnClickListener{

            val intent: Intent = Intent(this, RegisterPage:: class.java)
            startActivity(intent)

        }

    }
}