package com.misapps.gestorturnos.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "turnos")
data class Turno(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // ID único de cada turno
    val fecha: LocalDate,
    val tipo: String, // Tipo de turno (mañana, tarde, noche, etc.)
    val color: String, // Color del turno para mostrar en el calendario
    val pluses: List<Plus> // Lista de pluses asociados a este turno
)



