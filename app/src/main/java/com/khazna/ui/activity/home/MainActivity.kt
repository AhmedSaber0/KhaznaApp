package com.khazna.ui.activity.home

import android.os.Bundle
import com.khazna.base.BaseActivity
import com.khazna.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, HomeViewModel>() {

    override val viewModel by viewModel<HomeViewModel>()

    override fun initBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}