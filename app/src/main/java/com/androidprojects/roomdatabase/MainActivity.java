package com.androidprojects.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import com.androidprojects.roomdatabase.RoomDb.NoteViewModel;

public class MainActivity extends AppCompatActivity {

  //  NoteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    viewModel = new ViewModelProvider(this).get(NoteViewModel.class);
      //  viewModel.getAllNotes().observe(this, Observer);
    }
}