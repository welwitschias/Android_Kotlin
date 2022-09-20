package com.example.ex1_view

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.ex1_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // viewBinding 기법으로 화면 출력
        // 바인딩 객체 획득 : XML 파일 이름의 첫 글자와 _ 뒤에 오는 글자를 대문자로 + Binding 추가
        // 예) activity_main.xml → ActivityMainBinding, edit_text_view.xml → EditTextViewBinding
        // layoutInflater : XML에 미리 정의해 둔 틀을 실제 메모리에 올려주는 역할
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // XML 명시하여 화면 출력
//        setContentView(R.layout.activity_main)
//        setContentView(R.layout.text_view)
//        setContentView(R.layout.button_view)
//        setContentView(R.layout.edit_text_view)

        // TextView 생성 : 일반적인 방법
//        val name = TextView(this)
//        name.typeface = Typeface.DEFAULT_BOLD
//        name.textSize = 30F
//        name.text = "Lake Louise"

        // TextView 생성 : apply 키워드 사용
        // apply → 해당 객체의 속성을 바로 설정 가능 (위처럼 [변수명.**] 으로 안 불러도 됨)
        val name = TextView(this).apply {
            typeface = Typeface.DEFAULT_BOLD // 폰트를 굵게
            textSize = 30F // 폰트 사이즈
            text = "Lake Louise" // 화면에 출력할 글자
        }

        // ImageView 생성 : 일반적인 방법
//        val image = ImageView(this)
//        image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.lake_1))
//        image.setImageResource(R.drawable.lake_1)
//        image.adjustViewBounds = true

        // ImageView 생성 : also 키워드 사용
        // also → [it.**]으로 해당 객체를 이용
        val image = ImageView(this).also {
            // 이미지 세팅 → R(리소스)안에 있는 파일 선택 가능
            // setImageDrawable → 네트워크나 파일을 읽어서 이미지를 그림
            // setImageResource → res 폴더에 있는 리소스를 가져옴
            it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.lake_1))
//            it.setImageResource(R.drawable.lake_1)
            it.adjustViewBounds = true // 이미지의 세로 길이에 맞춰서 비율을 맞춰줌
        }

        // 주소 문자열 출력 TextView 생성
        val address = TextView(this).apply {
            typeface = Typeface.DEFAULT_BOLD
            textSize = 30F
            text = "Lake Louise, AB, 캐나다"
        }

        // 레이아웃을 생성하고, 뷰를 담아준다.
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL // orientation → 뷰 배치방향 설정 (가로는 HORIZONTAL)
            gravity = Gravity.CENTER // gravity → 뷰 정렬 설정

            // LinearLayout 객체에 TextView, ImageView, TextView 객체 추가
            addView(name, WRAP_CONTENT, WRAP_CONTENT)
            addView(image, WRAP_CONTENT, WRAP_CONTENT)
            addView(address, WRAP_CONTENT, WRAP_CONTENT)
        }

        // LinearLayout 객체를 화면에 출력
//        setContentView(layout)

        // id 속성을 이용한 특정 뷰 제어 → findViewById()
        // 변수에 타입을 지정한 방법
//        val name1: TextView = findViewById(R.id.name)
//        name1.text = "id 속성을 이용한 특정 뷰 제어"

        // findViewById() 함수에 제네릭을 추가한 방법
//        val address1 = findViewById<TextView>(R.id.address)
//        val image1 = findViewById<ImageView>(R.id.image1)
//
//        val visibleBtn = findViewById<Button>(R.id.visible_test)
//        val invisibleBtn = findViewById<Button>(R.id.invisible_test)
//        val goneBtn = findViewById<Button>(R.id.gone_test)
//
//        visibleBtn.setOnClickListener {
//            image1.visibility = View.VISIBLE
//        }
//
//        invisibleBtn.setOnClickListener {
//            image1.visibility = View.INVISIBLE
//        }
//
//        goneBtn.setOnClickListener {
//            image1.visibility = View.GONE
//        }

        // id 속성을 이용한 특정 뷰 제어 - 바인딩 기법 활용
        val image1 = binding.image1
        val visibleBtn = binding.visibleTest
        visibleBtn.setOnClickListener {
            image1.visibility = View.VISIBLE
        }

        val invisibleBtn = binding.invisibleTest
        invisibleBtn.setOnClickListener {
            image1.visibility = View.INVISIBLE
        }

        // 변수 선언 없이 binding.[id] 이용하여 뷰 제어 가능
        binding.goneTest.setOnClickListener {
            image1.visibility = View.GONE
        }
    }
}