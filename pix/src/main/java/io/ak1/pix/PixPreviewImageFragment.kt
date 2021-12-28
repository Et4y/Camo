package io.ak1.pix

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import io.ak1.pix.databinding.FragmentPixPreviewImageBinding


class PixPreviewImageFragment : Fragment() {


    private val args by navArgs<PixPreviewImageFragmentArgs>()

    private lateinit var _binding: FragmentPixPreviewImageBinding
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = run {
        _binding = FragmentPixPreviewImageBinding.inflate(inflater, container, false)
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
        Glide.with(requireActivity()).load(args.imagePath).into(binding.iv)

        binding.sendButton.setOnClickListener {
            setFragmentResult("image", bundleOf("data" to args.imagePath))
            findNavController().navigateUp()
        }
    }


}