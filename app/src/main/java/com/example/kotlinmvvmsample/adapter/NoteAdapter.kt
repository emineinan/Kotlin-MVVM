package com.example.kotlinmvvmsample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmsample.ViewModel.MainViewModel
import com.example.kotlinmvvmsample.R
import com.example.kotlinmvvmsample.model.Note
import kotlinx.android.synthetic.main.item_view.view.*

class NoteAdapter(var viewModel:MainViewModel, val noteList: ArrayList<Note>, val context: Context):RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    class NoteViewHolder(private val binding: View):RecyclerView.ViewHolder(binding) {
        fun bind(note: Note){
            binding.textViewText.text=note.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return NoteViewHolder(root)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(noteList[position])
    }
}