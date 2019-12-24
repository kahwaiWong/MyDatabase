package com.example.mydatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FeelingDao {
    @Insert
    //suspend is a coroutine function, it will do things in the background, perform background process
    //will not get it immediately, will take time
    suspend fun insertFeeling(feeling: Feeling)

    @Update
    suspend fun updateFeeling(feeling: Feeling)

    @Delete
    suspend fun deleteFeeling(feeling: Feeling)

    //the feeling from query is a tablename
    @Query("SELECT * FROM feeling")
    fun getAllRecords():LiveData<List<Feeling>>

    //select when the id is ... .
    @Query("SELECT * FROM feeling WHERE id = :search_id")
    fun getOneRecord(search_id:Int): Feeling
}