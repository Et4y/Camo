package io.ak1.pix

//import com.potyvideo.library.globalInterfaces.AndExoPlayerListener

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import io.ak1.pix.databinding.FragmentPixPreviewVideoBinding


class PixPreviewVideoFragment : Fragment() {


    private val args by navArgs<PixPreviewVideoFragmentArgs>()

    private lateinit var _binding: FragmentPixPreviewVideoBinding
    private val binding get() = _binding

    private var duration = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = run {
        _binding = FragmentPixPreviewVideoBinding.inflate(inflater, container, false)
        binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBackPressed()
        receiveData()
    }

    private fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }

        })
    }


    private fun receiveData() {

        binding.videoView.setVideoURI(Uri.parse(args.videoPath))

        binding.videoView.setOnPreparedListener {
            MediaPlayer.OnPreparedListener {
                duration = it.duration.toLong()
            }
        }



        binding.sendButton.setOnClickListener {
            if (duration != 0L) {
                setFragmentResult(
                    "video",
                    bundleOf("data" to args.videoPath, "duration" to duration)
                )
                findNavController().navigateUp()
            }
        }
    }


}