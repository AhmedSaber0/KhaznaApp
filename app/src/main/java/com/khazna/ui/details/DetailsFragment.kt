package com.khazna.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.navArgs
import com.khazna.R
import com.khazna.base.BaseFragment
import com.khazna.data.local.entity.PostModel
import com.khazna.databinding.FragmentDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>() {

    private val detailsArgs by navArgs<DetailsFragmentArgs>()
    private lateinit var songDetails: PostModel

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ): FragmentDetailsBinding = FragmentDetailsBinding.inflate(inflater, container, attachToParent)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        songDetails = detailsArgs.postDetails

        initViews()
        setupAnimation()
    }

    private fun initViews() {
        with(songDetails) {
            binding.titleTxv.text = title
            binding.bodyTxv.text = body
        }
    }

    private fun setupAnimation() {
        val slideAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.button_anim)
        binding.button.startAnimation(slideAnimation)
    }

    override val viewModel: DetailsViewModel by viewModel()
}