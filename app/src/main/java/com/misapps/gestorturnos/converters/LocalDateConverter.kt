package com.misapps.gestorturnos.converters

import androidx.room.TypeConverter
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

class LocalDateConverter {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE

    @TypeConverter
    fun fromString(value: String): LocalDate {
        return LocalDate.parse(value, formatter)
    }

    @TypeConverter
    fun toString(date: LocalDate): String {
        return date.format(formatter)
    }
}
