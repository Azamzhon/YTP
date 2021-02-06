package com.azamzhon.data.repository

import androidx.lifecycle.liveData
import com.azamzhon.data.local.db.YoutubeDataBase
import com.azamzhon.data.models.PlaylistItem
import com.azamzhon.data.models.VideoListItem
import com.azamzhon.data.network.Resource
import com.azamzhon.data.network.YouTubeApi
import kotlinx.coroutines.Dispatchers

class YoutubeRepository(private var api: YouTubeApi, private var database: YoutubeDataBase) {

    companion object {
        const val YOUTUBE_API_KEY = "AIzaSyDr7WJvkOUCrqvY6dsVmV9hjCpxG-EYbiI"
    }

    val channelId = "UC9CoOnJkIBMdeijd9qYoT_g"
//    val channelId = "UCM9r1xn6s30OnlJWb-jc3Sw"
    val part = "snippet,contentDetails"
    val maxResults = 10

    fun getPlaylist() : MutableList<PlaylistItem>{
        return database.wordDao().getPlaylist()
    }

    fun getAllVideos(id : String) : VideoListItem?{
        return database.wordDao().getAllVideos(id)
    }

    fun addPlaylists(list : MutableList<PlaylistItem>){
        database.wordDao().addPlaylist(list)
    }

    fun addVideos(list : MutableList<PlaylistItem>){
        database.wordDao().addVideos(list)
    }

    fun getPlaylists() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getPlaylists(part, channelId, YOUTUBE_API_KEY,maxResults)))
        }catch (e : Exception){
            emit(Resource.error(data = null,message = e.message.toString()))
        }
    }

    fun getNextPlaylists(nextPageToken : String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getNextPlaylists(part, channelId, YOUTUBE_API_KEY,maxResults,nextPageToken)))
        }catch (e : Exception){
            emit(Resource.error(data = null,message = e.message.toString()))
        }
    }

    fun getVideoListFromPlaylist(videoListId : String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getVideoListFromPlaylist(part, videoListId, YOUTUBE_API_KEY,maxResults)))
        }catch (e : Exception){
            emit(Resource.error(data = null,message = e.message.toString()))
        }
    }

    fun getNextVideoListFromPlaylist(nextPageToken : String,videoListId : String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getNextVideoListFromPlaylist(part, videoListId, YOUTUBE_API_KEY,maxResults,nextPageToken)))
        }catch (e : Exception){
            emit(Resource.error(data = null,message = e.message.toString()))
        }
    }

}