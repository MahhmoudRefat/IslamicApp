package com.example.islamicapp.ui.home.radio

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamicapp.R
import com.example.islamicapp.databinding.FragmentQuraanBinding
import com.example.islamicapp.databinding.FragmentRadioBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class RadioFragment : Fragment() {

    lateinit var viewBinding: FragmentRadioBinding
   /* var steam = "https://backup.qurango.net/radio/ibrahim_alakdar"
    lateinit var mediaplayer: MediaPlayer
    var prepared: Boolean = false*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentRadioBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val player = ExoPlayer.Builder(requireContext()).build()
        val defultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
        val mdeiaitem = MediaItem.fromUri("https://backup.qurango.net/radio/sahl_yassin")
        val mediaSource = ProgressiveMediaSource.Factory(defultHttpDataSourceFactory).createMediaSource(mdeiaitem)
        player.setMediaSource(mediaSource)
        player.prepare()
        viewBinding.playBtn.setOnClickListener{
            if(player.playWhenReady == true){
                player.playWhenReady = false
                viewBinding.playBtn.setImageDrawable(resources.getDrawable(R.drawable.icon_play))
            }
            else {
                player.playWhenReady = true
                viewBinding.playBtn.setImageDrawable(resources.getDrawable(R.drawable.pause))
            }
        }

        player.playWhenReady= true

       /* viewBinding.playBtn.isEnabled = false
        mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        viewBinding.playBtn.setOnClickListener{*/

        }

    }
