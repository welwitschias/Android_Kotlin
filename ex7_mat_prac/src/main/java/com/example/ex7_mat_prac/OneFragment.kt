package com.example.ex7_mat_prac

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ex7_mat_prac.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOneBinding.inflate(inflater, container, false)
        val datas = mutableListOf<String>()

        for (i in 1..20) {
            datas.add("Item $i")
        }

        val layoutManager = LinearLayoutManager(activity)
        val adapter = MyAdapter(datas)
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.adapter = adapter
        binding.recyclerview.addItemDecoration(MyDecoration(activity as Context))

        return binding.root
    }
}