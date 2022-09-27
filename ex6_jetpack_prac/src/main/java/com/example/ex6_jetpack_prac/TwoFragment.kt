package com.example.ex6_jetpack_prac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ex6_jetpack_prac.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentTwoBinding.inflate(inflater, container, false).root
    }

}