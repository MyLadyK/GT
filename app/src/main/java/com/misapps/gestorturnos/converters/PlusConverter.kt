package com.misapps.gestorturnos.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.misapps.gestorturnos.model.Plus

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
