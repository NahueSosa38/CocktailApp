package com.example.cocktailapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.cocktailapp.Data.DatabaseBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginPage : AppCompatActivity() {
    lateinit var etEditUser: EditText
    lateinit var etEditPass: EditText
    lateinit var cbUser: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Crear canal de notificación
        crearCanalNotificacion()


        // Referencias de los campos de entrada
        etEditUser = findViewById(R.id.editUser)
        etEditPass = findViewById(R.id.editPass)
        cbUser = findViewById(R.id.cbUser)

        // Recuperar credenciales de SharedPreferences
        val preferencias = getSharedPreferences(getString(R.string.sp_credenciales), MODE_PRIVATE)
        val savedUser = preferencias.getString("usuario", null)
        val savedPass = preferencias.getString("password", null)

        if (savedUser != null && savedPass != null) {
            // Si hay datos guardados, se procede con el inicio de sesión automático
            iniciarSesion(savedUser, savedPass)
        }

        val btn1: Button = findViewById(R.id.inibtn)
        btn1.setOnClickListener {
            val username = etEditUser.text.toString()
            val password = etEditPass.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completar Campos", Toast.LENGTH_SHORT).show()
            } else {
                // Verificar credenciales en la base de datos
                GlobalScope.launch {
                    val usuarioDao = DatabaseBuilder.getInstance(applicationContext).usuarioDao()
                    val usuario = usuarioDao.obtenerUsuarioPorNombre(username)

                    runOnUiThread {
                        if (usuario == null || usuario.password != password) {
                            Toast.makeText(this@LoginPage, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                        } else {
                            // Si el checkbox de recordar usuario está marcado, guardamos en SharedPreferences

                            if (cbUser.isChecked) {
                                val editor = preferencias.edit()
                                editor.putString("usuario", username)
                                editor.putString("password", password)
                                editor.apply()

                                // Mostrar la notificación de bienvenida
                                mostrarNotificacion(username)
                            }





                            // Iniciar la sesión
                            iniciarSesion(username, password)
                        }
                    }
                }
            }
        }

        val btn: Button = findViewById(R.id.rgtbtn)
        btn.setOnClickListener {
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }
    }

    private fun crearCanalNotificacion() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val canal = NotificationChannel(
                "recordar_usuario",
                "Recordar Usuario",
                NotificationManager.IMPORTANCE_HIGH // Cambiar a IMPORTANCE_HIGH para notificaciones emergentes
            ).apply {
                description = "Notificación para recordar usuario"
            }

            val notificationManager: NotificationManager =
                getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(canal)
        }
    }


    private fun mostrarNotificacion(username: String) {
        val intent = Intent(this, MainPage::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notificationBuilder = NotificationCompat.Builder(this, "recordar_usuario")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Recordando Usuario...")
            .setContentText("Bienvenido, $username !") // nombre de usuario
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setFullScreenIntent(pendingIntent, true) // Hace que la notificación sea emergente
            .setAutoCancel(true) // Cierra la notificación cuando se toca

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(1001, notificationBuilder.build())
    }



    private fun iniciarSesion(username: String, password: String) {
        val intent = Intent(this, MainPage::class.java)
        intent.putExtra("usuario", username)
        startActivity(intent)
        finish()
    }
}
