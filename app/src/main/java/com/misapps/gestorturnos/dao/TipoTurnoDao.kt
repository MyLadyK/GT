package com.misapps.gestorturnos.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.misapps.gestorturnos.model.TipoTurno

@Dao
interface TipoTurnoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTipoTurno(tipoTurno: TipoTurno)

    @Query("SELECT * FROM tipos_turno")
    suspend fun obtenerTodosLosTiposTurno(): List<TipoTurno>

    @Delete
    suspend fun eliminarTipoTurno(tipoTurno: TipoTurno)

}