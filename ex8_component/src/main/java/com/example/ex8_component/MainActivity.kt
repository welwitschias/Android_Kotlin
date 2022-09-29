package com.example.ex8_component

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ex8_component.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var cnt = 0

    // 액티비티가 실행(재실행)될 때
    override fun onStart() {
        Log.d("myLog", "onStart")
        super.onStart()
    }

    // 액티비티가 실행(재실행)될 때 - 실행시킨 이후
    override fun onResume() {
        Log.d("myLog", "onResume")
        super.onResume()
    }

    // 액티비티가 일시정지 상태일 때
    override fun onPause() {
        Log.d("myLog", "onPause")
        super.onPause()
    }

    // 액티비티가 비활성화될 때 onPause() 보다 뒤에 실행
    override fun onStop() {
        Log.d("myLog", "onStop")
        super.onStop()
    }

    // 액티비티가 종료(비활성화)될 때
    override fun onDestroy() {
        Log.d("myLog", "onDestroy")
        super.onDestroy()
    }

    // 앱 실행시 최초 한번만 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("myLog", "onCreate")
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 다시 돌려받을 때 2
        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            val resultData = it.data?.getStringExtra("result")
            Log.d("myLog", "데이터 돌려받기 2 : ${resultData}")
        }

        binding.goTwo.setOnClickListener {
            // 인텐트 기본 사용
//            val intent = Intent(this, TwoActivity::class.java)
//            startActivity(intent)

            // 인텐트에 엑스트라 데이터 추가
//            val intent = Intent(this, TwoActivity::class.java)
//            intent.putExtra("data1", "엑스트라 데이터")
//            intent.putExtra("data2", 10)
//            startActivity(intent)

            // 데이터를 다시 돌려받을 때 1
//            val intent = Intent(this, TwoActivity::class.java)
//            intent.putExtra("data1", "데이터 돌려받기")
//            intent.putExtra("data2", 1)
//            startActivityForResult(intent, 20)

            // 데이터를 다시 돌려받을 때 2
            val intent = Intent(this, TwoActivity::class.java)
            intent.putExtra("data1", "데이터 돌려받기")
            intent.putExtra("data2", 1)
            requestLauncher.launch(intent)
        }

        // 액티비티 상태값 저장
        val data = savedInstanceState?.getInt("cnt")
        if (data != null) {
            cnt = data
            binding.cntText.text = cnt.toString()
        }
        binding.cntBtn.setOnClickListener {
            cnt += 1
            binding.cntText.text = cnt.toString()
        }
    }

    // 데이터를 다시 돌려받을 때 1
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 20 && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("result")
            Log.d("myLog", "데이터 돌려받기 1 : ${result}")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // 번들 객체에 데이터 저장
        outState.putInt("cnt", cnt)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // 번들 객체에 저장된 데이터 가져오기
        cnt = savedInstanceState.getInt("cnt")
        Log.d("myLog", "번들 객체에 저장된 데이터 : $cnt")
    }
}