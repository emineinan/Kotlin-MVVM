package com.example.kotlinmvvmsample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmvvmsample.ViewModel.MainViewModel
import com.example.kotlinmvvmsample.ViewModel.MainViewModelFactory
import com.example.kotlinmvvmsample.adapter.NoteAdapter
import com.example.kotlinmvvmsample.model.Note
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = MainViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        initialiseAdapter()
    }

    fun submit(view: View) {
        addData()
    }

    private fun initialiseAdapter() {
        recyclerView.layoutManager = viewManager
        observeData()
    }

    fun observeData() {
        viewModel.list.observe(this, androidx.lifecycle.Observer {
            recyclerView.adapter = NoteAdapter(viewModel, it, this)
        })
    }

    fun addData() {
        var text = editTextText.text.toString()
        if (text.isEmpty()) {
            Toast.makeText(this, "Please, enter a text", Toast.LENGTH_SHORT).show()
        } else {
            var note = Note(text)
            viewModel.add(note)
            editTextText.text.clear()
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }
}