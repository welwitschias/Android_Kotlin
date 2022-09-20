package com.example.ex1_kakaologin_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex1_kakaologin_page.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}