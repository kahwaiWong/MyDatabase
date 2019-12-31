package com.example.mydatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//pass in application as parameter
class FeelingViewModel(application: Application): AndroidViewModel(application) {
    private val repository: FeelingRepository

    val allFeelings : LiveData<List<Feeling>>

    init{
        //initialise is just like constructor
        val feelingDao = FeelingDatabase.getDatabase(application).feelingDao()
        repository = FeelingRepository(feelingDao)
        allFeelings = repository.allFeelings
    }

    // A coroutine function
    fun insertFeeling(feeling: Feeling)
            = viewModelScope.launch {
        repository.insertFeeling(feeling)
    }
}

