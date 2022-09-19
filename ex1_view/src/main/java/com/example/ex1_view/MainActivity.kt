package com.example.ex1_view

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        setContentView(R.layout.activity_main) // 화면 출력 XML 명시
    }
}