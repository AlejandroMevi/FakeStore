package com.mevi.fakestore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.view.isVisible
import com.mevi.fakestore.R
import com.mevi.fakestore.core.Utilities
import com.mevi.fakestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainInterface {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initView()
        buttons()
        setContentView(binding.root)
    }

    private fun initView() {
        Utilities().loadFragment(this, CategoriesFragment(), "Books")
    }

    private fun buttons() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Utilities().loadFragment(this, CategoriesFragment(), "Books")
                    true
                }

                R.id.fav -> {
                    Utilities().loadFragment(this, CategoriesFragment(), "Fav")
                    true
                }

                else -> false
            }
        }
    }

    override fun showLoading(isShowing: Boolean) {
        binding.progress.root.isVisible = isShowing
        if (isShowing) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            )
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
    }
}