package com.khazna.ui.splash

import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.khazna.R
import com.khazna.base.BaseActivity
import com.khazna.databinding.ActivitySplashBinding
import com.khazna.domain.model.viewstate.Status
import com.khazna.ui.activity.home.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override val viewModel by viewModel<SplashViewModel>()

    override fun initBinding(): ActivitySplashBinding =
        ActivitySplashBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setupAnimation()

        openActivityWithDelay(MainActivity::class.java, 2000)
    }

    private fun setupAnimation() {
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.splace_anim)
        binding.splashIconImv.startAnimation(slideAnimation)
    }
}
