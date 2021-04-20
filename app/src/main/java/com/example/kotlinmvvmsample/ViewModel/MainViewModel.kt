package com.example.kotlinmvvmsample.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmsample.model.Note

class MainViewModel : ViewModel() {
    var list=MutableLiveData<ArrayList<Note>>()
    var newList= arrayListOf<Note>()

    fun add(note: Note){
        newList.add(note)
        list.value=newList
    }
}