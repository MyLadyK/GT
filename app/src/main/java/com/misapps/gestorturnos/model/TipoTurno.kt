package com.misapps.gestorturnos.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime

@Entity(tableName = "tipos_turno")
data class TipoTurno(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val inicio: LocalTime,
    val fin: LocalTime,
    val color: String, // Ej: "#FF0000"
)
