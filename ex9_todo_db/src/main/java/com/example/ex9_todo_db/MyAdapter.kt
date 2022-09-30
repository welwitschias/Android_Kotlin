package com.example.ex9_todo_db

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ex9_todo_db.databinding.ItemRecyclerviewBinding

class MyViewHolder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

class MyAdapter(val datas: MutableList<String>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var db: DBHelper
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        db = DBHelper(context)

        return MyViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = datas!![position]

        binding.itemData.setOnClickListener {
            if (binding.updateBtn.visibility == View.GONE) {
                binding.updateBtn.visibility = View.VISIBLE
                binding.updateBtn.setOnClickListener {
                    val intent = Intent(binding.itemData.context, UpdateActivity::class.java)
                    intent.putExtra("todo", binding.itemData.text.toString())
                    startActivity(context, intent, null)
                }
            } else {
                binding.updateBtn.visibility = View.GONE
            }
        }

        binding.deleteBtn.setOnClickListener {
            try {
                val data = binding.itemData.text.toString()
                val deleteDB = db.writableDatabase
                deleteDB.execSQL("delete from TODO_TB where todo = ?", arrayOf(data))
                deleteDB.close()

                datas.remove(datas[position])
                notifyDataSetChanged()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getItemCount(): Int {
        return datas?.size ?: 0
    }
}