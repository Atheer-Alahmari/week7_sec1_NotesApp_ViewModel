package com.example.week7_sec1_notesappviewmodel.models

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {
    @Query("SELECT * FROM Massege  ORDER BY id ASC ")
    fun getAllNotes(): LiveData<List<Notes>>

    @Insert
    fun insertNote(note1:Notes)

    @Delete
    fun deleteNote(id: Notes)

    @Update
    fun updateNote(id: Notes)

}

