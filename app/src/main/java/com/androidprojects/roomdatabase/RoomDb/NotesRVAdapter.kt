package com.androidprojects.roomdatabase.RoomDb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidprojects.roomdatabase.R
import kotlinx.coroutines.currentCoroutineContext

class NotesRVAdapter(private val context: Context, private val listener: INoteRVAdapter) : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    val allNotes = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>( R.id.textview)
        val deleteButton = itemView.findViewById<ImageView>(R.id.iv_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notes, parent, false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
           return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNotes = allNotes[position]
        holder.textView.text = currentNotes.text
    }

    fun updateList(newList : List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }
}

interface INoteRVAdapter{
    fun onItemClicked(note:Note)
}


