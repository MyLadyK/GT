package com.misapps.gestorturnos.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.misapps.gestorturnos.model.Plus

@Dao
interface PlusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarPlus(plus: Plus)

    @Query("SELECT * FROM pluses")
    suspend fun obtenerTodosLosPluses(): List<Plus>

    @Delete
    suspend fun eliminarPlus(plus: Plus)

}