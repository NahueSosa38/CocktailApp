package com.example.cocktailapp

import android.content.Context
import android.content.Intent
import android.widget.Toast

object Util {
    fun cerrarSesion(context: Context) {
        // Limpiar las SharedPreferences
        val preferencias = context.getSharedPreferences(context.getString(R.string.sp_credenciales), Context.MODE_PRIVATE)
        preferencias.edit().clear().apply()

        // Verificar si se limpian las preferencias
        val savedUser = preferencias.getString("usuario", null)
        val savedPass = preferencias.getString("password", null)
            Toast.makeText(context, "Sesión cerrada", Toast.LENGTH_SHORT).show()


        // Redirigir al Login
        val intent = Intent(context, LoginPage::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }
}