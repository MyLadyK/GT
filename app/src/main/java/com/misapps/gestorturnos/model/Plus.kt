package com.misapps.gestorturnos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pluses")
data class Plus(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tipo: String,
    val cantidad: Double,
    val porHora: Boolean,
    val descripcion: String
)
