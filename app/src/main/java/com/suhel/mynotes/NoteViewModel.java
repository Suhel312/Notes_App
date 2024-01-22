package com.suhel.mynotes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepo noteRepo;
    private LiveData<List<Note>> noteList;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepo=new NoteRepo(application);
        noteList=noteRepo.getAllData();
    }

    public void insertData(Note note){
        noteRepo.insertData(note);
    }
    public void updateData(Note note){
        noteRepo.updateData(note);
    }
    public void deleteData(Note note){
        noteRepo.deleteData(note);
    }

    public LiveData<List<Note>> getAllNotes(){
        return noteList;
    }

}
