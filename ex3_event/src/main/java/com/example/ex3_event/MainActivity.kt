package com.example.ex3_event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import com.example.ex3_event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // touch event
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // 로그 메시지 출력
//        Log.d("myLog", "터치 이벤트 발생")

        // 좌표값 얻기 : MotionEvent 객체로 획득
//        Log.d("myLog", "x의 좌표값 : ${event?.x}, y의 좌표값 : ${event?.y}")

        // 터치 이벤트 종류
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> { // 손가락으로 화면을 누르는 순간
                Log.d("myLog", "ACTION_DOWN")
            }
            MotionEvent.ACTION_UP -> { // 손가락을 화면에서 떼는 순간
                Log.d("myLog", "ACTION_UP")
            }
            MotionEvent.ACTION_MOVE -> { // 화면을 손가락으로 누른채로 이동
                Log.d("myLog", "ACTION_MOVE")
            }
        }
        return super.onTouchEvent(event)
    }

    // key(볼륨, 뒤로가기 / 소프트 키보드의 키 아님) event
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("myLog", "키를 눌렀을 때 발생")
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
//        Log.d("myLog", "키를 눌렀다 뗐을 때 발생")
        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_UP -> {
                Log.d("myLog", "VOLUME_UP")
            }
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                Log.d("myLog", "VOLUME_DOWN")
            }
        }
        return super.onKeyUp(keyCode, event)
    }

    override fun onKeyLongPress(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("myLog", "키를 길게 눌렀을 때 발생")
        return super.onKeyLongPress(keyCode, event)
    }

    // 뒤로가기 버튼 눌렀을 때
    override fun onBackPressed() {
        Log.d("myLog", "뒤로가기 버튼 누름")
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. activity에서 인터페이스 구현
        binding.btn.setOnClickListener(this)

        // 2. 별도의 핸들러 구현
        binding.btn2.setOnClickListener(Handler())

        // 3. SAM기법으로 구현 → 간단해서 주로 사용
        binding.btn3.setOnClickListener {
            Log.d("myLog", "버튼 터치 3")
        }

        // long click event
        binding.btn3.setOnLongClickListener {
            Log.d("myLog", "길게 터치 이벤트 발생")
            true
        }

        // 좋아요 버튼 만들기
        binding.unlike.setOnClickListener {
            binding.unlike.visibility = View.GONE
            binding.like.visibility = View.VISIBLE
        }

        binding.like.setOnClickListener {
            binding.like.visibility = View.GONE
            binding.unlike.visibility = View.VISIBLE
        }
    }

    // 1. activity에서 인터페이스 구현
    override fun onClick(p0: View?) {
        Log.d("myLog", "버튼 터치 1")
    }
}

// 2. 별도의 핸들러 구현
class Handler : View.OnClickListener {
    override fun onClick(p0: View?) {
        Log.d("myLog", "버튼 터치 2")
    }
}