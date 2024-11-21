package com.misapps.gestorturnos

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.misapps.gestorturnos.model.Plus
import com.misapps.gestorturnos.model.PlusConverter
import com.misapps.gestorturnos.dao.PlusDao
import com.misapps.gestorturnos.model.TipoTurno
import com.misapps.gestorturnos.dao.TipoTurnoDao
import com.misapps.gestorturnos.model.Turno
import com.misapps.gestorturnos.dao.TurnoDao

@Database(entities = [Turno::class, TipoTurno::class, Plus::class], version = 1)
@TypeConverters(PlusConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun turnoDao(): TurnoDao
    abstract fun tipoTurnoDao(): TipoTurnoDao
    abstract fun plusDao(): PlusDao

}
