package com.example.cocktailapp.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuarios WHERE nombre = :nombre LIMIT 1")
    fun obtenerUsuarioPorNombre(nombre: String): Usuario?

    @Insert
    fun insertarUsuario(usuario: Usuario)
}