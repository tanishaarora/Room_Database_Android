package com.androidprojects.roomdatabase.RoomDb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : Note)

    @Delete
    suspend fun delete(note : Note)

    @Query("Select * From notes_table order by id ASC")
    fun getAllNotes() : LiveData<List<Note>>

}