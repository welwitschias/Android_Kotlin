package com.example.basickotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 객체 생성할 때 자바와는 다르게 new 키워드가 업다.
        var testClass = ClassBasic("홍")
        testClass.some()
    }
}