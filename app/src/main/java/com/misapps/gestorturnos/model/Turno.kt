package com.misapps.gestorturnos.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "turnos")
data class Turno(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // ID único de cada turno
    val fecha: String, // Fecha del turno en formato "yyyy-MM-dd"
    val tipo: String, // Tipo de turno (mañana, tarde, noche, etc.)
    val color: String, // Color del turno para mostrar en el calendario
    val pluses: List<Plus> // Lista de pluses asociados a este turno
)

@Entity(tableName = "plus")
data class Plus(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // ID único del plus
    val tipo: String, // Tipo del plus
    val cantidad: Double, // Cantidad del plus
    val porHora: Boolean, // Indica si el plus es por hora o fijo
    val descripcion: String // Descripción del plus
)

// Necesitarás un TypeConverter para almacenar la lista de pluses en la base de datos class PlusConverter
// { @TypeConverter fun fromPluses(pluses: List<Plus>): String { // Convierte la lista de pluses a un String
// para almacenamiento } @TypeConverter fun toPluses(data: String): List<Plus> { // Convierte el String de
// vuelta a una lista de pluses } }

class PlusConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromPluses(pluses: List<Plus>): String {    // Convierte la lista de pluses a un String para almacenamiento
        return gson.toJson(pluses)
    }

    @TypeConverter
    fun toPluses(data: String): List<Plus> { // Convierte el String de vuelta a una lista de pluses
        val ListType = object : TypeToken<List<Plus>>() {}.type
        return gson.fromJson(data, ListType)
    }

}