package com.androidprojects.roomdatabase.RoomDb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainNote : AppCompatActivity() {

    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
            .getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {  })
    }
}