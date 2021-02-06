package com.azamzhon.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.azamzhon.data.models.PlaylistInfo
import com.azamzhon.data.network.Resource
import com.azamzhon.data.repository.YoutubeRepository

class DetailsViewModel (private var repository : YoutubeRepository) : ViewModel() {

    fun getVideoListFromPlaylist(videoListId : String) : LiveData<Resource<PlaylistInfo>>{
        return repository.getVideoListFromPlaylist(videoListId)
    }

    fun getNextVideoListFromPlaylist(videoListId : String,nextPageToken : String): LiveData<Resource<PlaylistInfo>>{
        return repository.getNextVideoListFromPlaylist(nextPageToken,videoListId)
    }

}