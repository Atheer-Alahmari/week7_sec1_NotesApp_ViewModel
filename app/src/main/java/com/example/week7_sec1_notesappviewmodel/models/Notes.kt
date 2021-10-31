package com.example.week7_sec1_notesappviewmodel.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Massege")
data class Notes (
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name="id")val id:Int,
    @ColumnInfo(name="Note")val note:String
)