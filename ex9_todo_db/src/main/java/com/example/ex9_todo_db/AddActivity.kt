package com.example.ex9_todo_db

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.ex9_todo_db.databinding.ActivityAddBinding

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
                val inputData = binding.addEditView.text.toString()

                if (inputData.isBlank()) {
                    // 할 일 입력값이 없을 때
                    setResult(Activity.RESULT_CANCELED, intent)
                } else {
                    // 할 일 입력값이 있을 때
                    val db = DBHelper(this).writableDatabase
                    db.execSQL("insert into TODO_TB(todo) values(?)", arrayOf(inputData))
                    db.close()
                    intent.putExtra("result", inputData)
                    setResult(Activity.RESULT_OK, intent)
                }
                finish()
                true
            }
            else -> true
        }
    }
}