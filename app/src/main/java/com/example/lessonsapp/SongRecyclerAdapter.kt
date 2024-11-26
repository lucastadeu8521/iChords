package com.example.lessonsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongRecyclerAdapter(
    private val context: Context,
    private val originalList: List<SongModel>,
    private val onClickListener: (SongModel) -> Unit
) : RecyclerView.Adapter<SongRecyclerAdapter.SongViewHolder>() {

    private var filteredList = originalList.toMutableList() // This will hold the filtered songs

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.it_song_list, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = filteredList[position]
        holder.bind(song, onClickListener)
    }

    override fun getItemCount(): Int = filteredList.size // Return the size of the filtered list

    // Function to filter songs based on the query
    fun search(query: String) {
        filteredList.clear()
        if (query.isEmpty()) {
            filteredList.addAll(originalList) // If the query is empty, show all songs
        } else {
            filteredList.addAll(originalList.filter {
                it.title.contains(query, true) || // Check if title contains the query
                        it.artist.contains(query, true) || // Check if artist contains the query
                        it.album.contains(query, true) || // Check if album contains the query
                        it.genre.contains(query, true)
            })
        }
        notifyDataSetChanged() // Notify the adapter that the data has changed
    }

    class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val songCover: ImageView = view.findViewById(R.id.ivSongCover)
        private val songTitle: TextView = view.findViewById(R.id.tvSongTitle)
        private val songArtist: TextView = view.findViewById(R.id.tvSongArtist)

        fun bind(song: SongModel, onClickListener: (SongModel) -> Unit) {
            songCover.setImageResource(song.image)
            songTitle.text = song.title
            songArtist.text = song.artist

            itemView.setOnClickListener {
                onClickListener(song)
            }
        }
    }
}
