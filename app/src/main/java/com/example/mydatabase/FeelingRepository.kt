package com.example.mydatabase

import androidx.lifecycle.LiveData

class FeelingRepository(private val feelingDao: FeelingDao) {
    //get all records to feed into allFeelings
    val allFeelings: LiveData<List<Feeling>> = feelingDao.getAllRecords()

    suspend fun insertFeeling(feeling: Feeling){
        feelingDao.insertFeeling(feeling)
    }
}
