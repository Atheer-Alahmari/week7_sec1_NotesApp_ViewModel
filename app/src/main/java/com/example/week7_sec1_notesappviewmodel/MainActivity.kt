package com.example.week7_sec1_notesappviewmodel

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week7_sec1_notesappviewmodel.models.NoteDataBase
import com.example.week7_sec1_notesappviewmodel.models.Notes

class MainActivity : AppCompatActivity() {
    lateinit var note_ED: EditText
    lateinit var sub_btn: Button
    lateinit var list_RV: RecyclerView
    lateinit var listNote:List<Notes>
   // lateinit var myDBRoom: NoteDataBase

    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java)}//------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        note_ED = findViewById(R.id.note_ED)
        sub_btn = findViewById(R.id.btn_submit)

        list_RV = findViewById(R.id.recycler_View)// Recycler View

        //myDBRoom=NoteDataBase.getInstance(applicationContext)
        listNote= listOf()

        //------------------------------------------------------------------------------------------------------------------
//       myViewModel.get_Note().observe(this,{
//                notes-> updateList()
//
//        })

        updateList()
        sub_btn.setOnClickListener {
            var input = note_ED.text.toString()


            //----------------Save DB--------------

            if(input.isNotEmpty()) {
//                val n = Notes(0, input)
//                myDBRoom.NoteDao().insertNote(n)
                 myViewModel.add_Note(input)

                Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
                    .show()



            }else{
                Toast.makeText(applicationContext, "Please Enter a Note ", Toast.LENGTH_SHORT).show()

            }
            //---------------------------------------------------
            updateList()
            note_ED.text.clear()

        }
    }
    //--------------------------------------
    fun updateList() {
        myViewModel.get_Note().observe(this,{
                notes-> list_RV.adapter = RV_Adapter(this,notes)
            list_RV.layoutManager = LinearLayoutManager(this)

            list_RV.scrollToPosition(notes.size - 1)



        })


    }


}
