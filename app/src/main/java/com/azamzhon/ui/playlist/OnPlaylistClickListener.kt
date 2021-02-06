package com.azamzhon.ui.playlist

import com.azamzhon.data.models.PlaylistItem

interface OnPlaylistClickListener {

    fun onClick(item : PlaylistItem)

}