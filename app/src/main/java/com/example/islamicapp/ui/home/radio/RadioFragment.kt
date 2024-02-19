package com.example.islamicapp.ui.home.radio

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.islamicapp.R
import com.example.islamicapp.api.ApiMAnager
import com.example.islamicapp.api.sourcesResponse.Radio
import com.example.islamicapp.api.sourcesResponse.radiochannel
import com.example.islamicapp.databinding.FragmentRadioBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadioFragment : Fragment() {

    lateinit var binding: FragmentRadioBinding
    private var mediaPlayer: MediaPlayer? = null
    private var currentPosition = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getRadioSources()
    }

    fun getRadioSources() {
        ApiMAnager
            .getServices()
            .getradiochannels()
            .enqueue(object : Callback<radiochannel> {
                override fun onResponse(
                    call: Call<radiochannel>,
                    response: Response<radiochannel>
                ) {
                    if (response.isSuccessful) {
                        initRadios(response.body()?.radios)
                    } else {
                        showErrorMessage("Internet must be enabled")
                    }
                }

                override fun onFailure(call: Call<radiochannel>, t: Throwable) {
                    showErrorMessage(t.message)
                }
            })
    }

    private fun initRadios(radios: List<Radio?>?) {
        mediaPlayer = MediaPlayer()
        binding.playBtn.setOnClickListener {
            if (!mediaPlayer!!.isPlaying) { // if not working
                mediaPlayer?.reset()
                playRadio(radios!![currentPosition])
            } else {
                mediaPlayer?.pause()
                binding.playBtn.setImageResource(R.drawable.icon_play)
            }
        }
        binding.nextBtn.setOnClickListener {
            nextChanel(radios?.size)
            mediaPlayer?.reset()
            playRadio(radios!![currentPosition])
        }
        binding.previosBtn.setOnClickListener {
            previousChannel(radios?.size)
            mediaPlayer?.reset()
            playRadio(radios!![currentPosition])
        }
    }

    private fun previousChannel(radiosSize: Int?) {
        currentPosition--
        if (currentPosition < 0) {
            currentPosition =
                radiosSize!! - 1 // get the last channel in radio = repeating the list again
        }
    }

    private fun nextChanel(radiosSize: Int?) {
        currentPosition++
        if (currentPosition >= radiosSize!!) {
            currentPosition = 0
        }
    }

    private fun playRadio(radio: Radio?) {
        binding.channelName.text = radio?.name
        mediaPlayer?.apply {
            setDataSource(radio?.url)
            prepare()
            start()
        }
        binding.playBtn.setImageResource(R.drawable.pause)
    }

    private fun showErrorMessage(message: String?) {
        Toast.makeText(
            requireContext(),
            message,
            Toast.LENGTH_LONG,
        )
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }


}


/* var steam = "https://backup.qurango.net/radio/ibrahim_alakdar"
  lateinit var mediaplayer: MediaPlayer
  var prepared: Boolean = false*/

/* val player = ExoPlayer.Builder(requireContext()).build()
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
*/
/* viewBinding.playBtn.isEnabled = false
 mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
 viewBinding.playBtn.setOnClickListener{*/
