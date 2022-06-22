package com.androidprojects.roomdatabase.RoomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract  class NoteDatabase : RoomDatabase() {

    abstract fun getnotesDao() : NoteDao

    companion object{

        @Volatile
        private  var INSTANCE: NoteDatabase? = null

        fun getDatabase(context : Context): NoteDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java, "word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


