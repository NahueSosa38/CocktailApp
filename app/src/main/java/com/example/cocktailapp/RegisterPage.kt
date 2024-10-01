package com.example.cocktailapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cocktailapp.Data.DatabaseBuilder
import com.example.cocktailapp.Data.Usuario
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
        btn2.setOnClickListener {

            if (editUser.text.toString().isEmpty() || editPass.text.toString().isEmpty()) {
                val mensaje = "Completar Campos"
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
            } else if (!cbEdad.isChecked) {
                Toast.makeText(this, "Confirme mayoria de edad", Toast.LENGTH_SHORT).show()
            } else {
                val username = editUser.text.toString()
                val password = editPass.text.toString()

                // Validar si el usuario ya existe
                GlobalScope.launch {
                    val usuarioDao = DatabaseBuilder.getInstance(applicationContext).usuarioDao()
                    val usuarioExistente = usuarioDao.obtenerUsuarioPorNombre(username)

                    runOnUiThread {
                        if (usuarioExistente != null) {
                            Toast.makeText(this@RegisterPage, "El usuario ya existe", Toast.LENGTH_SHORT).show()
                        } else {
                            // Insertar el nuevo usuario en la base de datos
                            val nuevoUsuario = Usuario(nombre = username, password = password)
                            GlobalScope.launch {
                                usuarioDao.insertarUsuario(nuevoUsuario)
                                runOnUiThread {

                                    val intent = Intent(this@RegisterPage, TerminosyCondiciones::class.java)
                                    startActivity(intent)
                                    finish()

                                    /*Toast.makeText(this@RegisterPage, "Usuario registrado", Toast.LENGTH_SHORT).show()
                                    // Ir a la pantalla de login
                                    val intent = Intent(this@RegisterPage, LoginPage::class.java)
                                    startActivity(intent)
                                    finish()*/
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}