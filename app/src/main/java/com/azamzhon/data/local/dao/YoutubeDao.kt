package com.azamzhon.data.local.dao

import androidx.room.*
import com.azamzhon.data.models.PlaylistItem
import com.azamzhon.data.models.VideoListItem

@Dao
interface YoutubeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPlaylist(list: MutableList<PlaylistItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addVideos(list: MutableList<PlaylistItem>)

    @Query("SELECT * FROM PlaylistItem")
    fun getPlaylist() : MutableList<PlaylistItem>

    @Transaction
    @Query("SELECT * FROM PlaylistItem WHERE PlaylistItem.id =:id")
    fun getAllVideos(id : String): VideoListItem?
}