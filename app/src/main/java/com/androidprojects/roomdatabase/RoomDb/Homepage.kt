package com.androidprojects.roomdatabase.RoomDb

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidprojects.roomdatabase.R

class Homepage : AppCompatActivity(), INoteRVAdapter {

    lateinit var viewModel: NoteViewModel
    lateinit var recyclerview: RecyclerView

    lateinit var editText : EditText
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        recyclerview = findViewById(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRVAdapter(this, this)
        recyclerview.adapter  = adapter

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer { list ->
            list?.let {
                adapter.updateList(it)
            }
        })
    }

    override fun onItemClicked(note: Note) {
        viewModel.deleteNotes(note)
        Toast.makeText(this, "${note.text} Deleted", Toast.LENGTH_SHORT).show()
    }

    fun submitData(view: View){
        val noteText = editText.text.toString()
        if(noteText.isNotEmpty()){
            viewModel.insertNotes(Note(noteText ))
            Toast.makeText(this, "${noteText} Inserted", Toast.LENGTH_SHORT).show()
        }
    }
}