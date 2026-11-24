package com.example.videoplayerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class MainActivity : AppCompatActivity() {
    private lateinit var player: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the player
        player = ExoPlayer.Builder(this).build()

        // Set the media item (HLS stream)
        val mediaItem = MediaItem.fromUri("https://pub-8c9d507c17b14439838a2ccf938e4983.r2.dev/videos/mymovie/master.m3u8")
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()

        // Bind the player to the view
        val playerView: PlayerView = findViewById(R.id.player_view)
        playerView.player = player
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}