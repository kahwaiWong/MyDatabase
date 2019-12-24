package com.example.mydatabase

import android.content.Context
import android.support.v4.app.INotificationSideChannel
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// if want to insert more than 1 table, put (entities = [Feeling::class], ...  )
@Database(entities = [Feeling::class], version = 1)
abstract class FeelingDatabase : RoomDatabase() {
    //Instance of DAO
    abstract fun feelingDao() : FeelingDao

    //Ensure only one instance of database is created
    companion object{
        //volatile memory, android have2 type, one is volatile, one is non-volatile
        @Volatile
        private var INTANCE: FeelingDatabase? = null

        fun getDatabase(context:Context): FeelingDatabase{
            val tempInstance = INTANCE
            if(tempInstance != null){
                return tempInstance
            }
            
            //Create an instance of the database
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FeelingDatabase::class.java,
                    "feeling_db"
                ).build()

                INTANCE = instance

                return instance
            }
        }
    }
}