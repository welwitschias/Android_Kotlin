package com.example.ex4_resource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex4_resource.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}