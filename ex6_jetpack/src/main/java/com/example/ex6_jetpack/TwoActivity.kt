package com.example.ex6_jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex6_jetpack.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 업버튼(뒤로가기) 생성 : 액션바가 있는 상태에서 사용 가능, 툴바에도 적용 가능
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // 업버튼 클릭 시 자동으로 호출되는 함수 재정의
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}