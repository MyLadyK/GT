package com.misapps.gestorturnos

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.misapps.gestorturnos.model.PlusConverter
import com.misapps.gestorturnos.model.Turno
import com.misapps.gestorturnos.model.TurnoDao

@Database(entities = [Turno::class], version = 1)
@TypeConverters(PlusConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun turnoDao(): TurnoDao
}
