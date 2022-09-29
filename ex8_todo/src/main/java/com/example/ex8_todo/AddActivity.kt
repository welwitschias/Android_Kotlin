package com.example.ex8_todo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.ex8_todo.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_add_save -> {
                val intent = intent
                val todoText = binding.addEditView.text.toString()
                if (todoText.isBlank()) {
                    setResult(Activity.RESULT_CANCELED, intent)
                } else {
                    intent.putExtra("result", todoText)
                    setResult(Activity.RESULT_OK, intent)
                }
                finish()
                true
            }
            else -> true
        }
    }
}