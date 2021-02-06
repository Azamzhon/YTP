package com.azamzhon.ui.playlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamzhon.R
import com.azamzhon.data.models.PlaylistItem
import com.azamzhon.extentions.loadImage
import kotlinx.android.synthetic.main.item_playlist_list.view.*

class PlaylistAdapter(var listener : OnPlaylistClickListener) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    private var list = ArrayList<PlaylistItem>()

    fun add(data:MutableList<PlaylistItem>){
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder
            = PlaylistViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_playlist_list,parent,false))

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            listener.onClick(list[position])
        }
    }

    override fun getItemCount(): Int  = list.size

    class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(playlistItem: PlaylistItem){
            itemView.apply {
                video_name.text = playlistItem.snippet?.title
                video_amount.text = (playlistItem.contentDetails?.itemCount.toString() + " video series")
                playlist_image.loadImage(playlistItem.snippet?.thumbnails?.medium?.url, 10)
            }
        }
    }
}