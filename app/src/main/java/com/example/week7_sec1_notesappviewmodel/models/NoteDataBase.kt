package com.example.week7_sec1_notesappviewmodel.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Notes::class],version = 1,exportSchema = false)
abstract class NoteDataBase: RoomDatabase() {

    companion object{
        var instance:NoteDataBase?=null;
        fun getInstance(ctx: Context):NoteDataBase
        {
            if(instance!=null)
            {
                return  instance as NoteDataBase;
            }
            instance= Room.databaseBuilder(ctx,NoteDataBase::class.java,"somename").run { allowMainThreadQueries() }.build();
            return instance as NoteDataBase;
        }
    }
    abstract fun NoteDao():NoteDao
}