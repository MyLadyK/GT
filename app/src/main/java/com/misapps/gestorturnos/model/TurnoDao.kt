package com.misapps.gestorturnos.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TurnoDao {
    // Insertar un turno

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTurno(turno: Turno)

    // Obtener todos los turnos
    @Query("SELECT * FROM turnos")
    suspend fun obtenerTodosLosTurnos(): List<Turno>

    // Obtener turnos por fecha
    @Query("SELECT * FROM turnos WHERE fecha = :fecha")
    suspend fun obtenerTurnosPorFecha(fecha: String): List<Turno>

    // Eliminar un turno
    @Delete
    suspend fun eliminarTurno(turno: Turno)
}

