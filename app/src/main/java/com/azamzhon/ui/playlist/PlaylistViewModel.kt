package com.azamzhon.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azamzhon.data.models.PlaylistInfo
import com.azamzhon.data.models.PlaylistItem
import com.azamzhon.data.network.Resource
import com.azamzhon.data.repository.YoutubeRepository

class PlaylistViewModel (private var repository : YoutubeRepository) : ViewModel () {

    var localData = MutableLiveData<MutableList<PlaylistItem>>()

    fun getPlaylists(): LiveData<Resource<PlaylistInfo>> {
        return repository.getPlaylists()
    }

    fun getNextPlaylist(nextPageToken : String): LiveData<Resource<PlaylistInfo>> {
        return repository.getNextPlaylists(nextPageToken)
    }

    fun getPlaylistFromLD(){
        localData.value = repository.getPlaylist()
    }

    fun addPlaylistsToLD(list : MutableList<PlaylistItem>){
        repository.addPlaylists(list)
    }
}