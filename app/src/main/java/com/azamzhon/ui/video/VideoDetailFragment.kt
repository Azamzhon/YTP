package com.azamzhon.ui.video

import android.os.Bundle
import com.azamzhon.R
import com.azamzhon.core.BaseFragment
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import org.koin.android.ext.android.inject

class VideoDetailFragment : BaseFragment<VideoDetailViewModel>(R.layout.fragment_video_detail){

//    companion object {
//        const val VIDEO_ITEM = "video_item"
//        const val RECOVERY_REQUEST = 1
//    }
//
//    private lateinit var youTubeView: YouTubePlayerView
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode == RECOVERY_REQUEST) {
//            getYouTubePlayerProvider().initialize(YoutubeRepository.YOUTUBE_API_KEY, this)
//        }
//    }
//
//    fun getYouTubePlayerProvider(): YouTubePlayerView {
//        return youTubeView
//    }
//
//    private lateinit var video: PlaylistItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            video = it.getSerializable(VIDEO_ITEM) as PlaylistItem
        }
    }

    override fun getViewModule(): VideoDetailViewModel = inject<VideoDetailViewModel>().value

    override fun setUpView() {
        setData()
        initializePlayer()
    }

    private fun initializePlayer() {
//        youTubeView = youtube_view as YouTubePlayerView
//        youTubeView.initialize(YoutubeRepository.YOUTUBE_API_KEY, this)
    }

    private fun setData() {
//        video_title.text = video.snippet?.title
//        video_description.text = video.snippet?.description
    }

    override fun setUpViewModelObs() {
    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        player: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        TODO("Not yet implemented")
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        errorReason: YouTubeInitializationResult?
    ) {
        TODO("Not yet implemented")
    }

//    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, player: YouTubePlayer?, wasRestored: Boolean) {
//        if (!wasRestored) {
//            player?.cueVideo(video.contentDetails?.videoId); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
//        }
//    }
//
//    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, errorReason: YouTubeInitializationResult?) {
//        if (errorReason!!.isUserRecoverableError()) {
//            errorReason.getErrorDialog(requireActivity(), RECOVERY_REQUEST).show()
//        } else {
//            val error: String = String.format(getString(R.string.player_error), errorReason.toString())
//            requireContext().showToast(error)
//        }
//    }
}