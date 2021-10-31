package com.example.week7_sec1_notesappviewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.week7_sec1_notesappviewmodel.models.NoteDataBase
import com.example.week7_sec1_notesappviewmodel.models.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(activity: Application):AndroidViewModel(activity) {

    private val notes1: LiveData<List<Notes>>
  val myDBRoom = NoteDataBase.getInstance(activity).NoteDao()

    init {

        notes1 = myDBRoom.getAllNotes()

    }

    fun get_Note(): LiveData<List<Notes>> {
        return notes1
    }

     fun add_Note(n: String) {
         CoroutineScope(Dispatchers.IO).launch {

             myDBRoom.insertNote(Notes(0,n))
         }
    }

    fun update_Note(id: Int, n: String) {
        CoroutineScope(Dispatchers.IO).launch {
            myDBRoom.updateNote(Notes(id, n))
        }
    }

    fun delete_Note(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            myDBRoom.deleteNote(Notes(id,""))
        }
    }


}