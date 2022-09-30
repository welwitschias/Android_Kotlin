package com.example.ex9_todo_db

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.ex9_todo_db.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    lateinit var binding: ActivityUpdateBinding
    lateinit var todo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        todo = intent.getStringExtra("todo").toString()
        binding.updateEditView.setText(todo)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_add_save -> {
                val inputData = binding.updateEditView.text.toString()

                if (inputData.isBlank()) {
                    Toast.makeText(this, "할 일이 비어 있습니다.", Toast.LENGTH_SHORT).show()
                    return false
                } else {
                    val db = DBHelper(this).writableDatabase
                    db.execSQL(
                        "update TODO_TB set todo = ? where todo = ?",
                        arrayOf(inputData, todo)
                    )
                    db.close()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                true
            }
            else -> true
        }
    }
}