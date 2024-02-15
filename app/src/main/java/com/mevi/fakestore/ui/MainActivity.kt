package com.mevi.fakestore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mevi.fakestore.R
import com.mevi.fakestore.core.Utilities
import com.mevi.fakestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        buttons()
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
}