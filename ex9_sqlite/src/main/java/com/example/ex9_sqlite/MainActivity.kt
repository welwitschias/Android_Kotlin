package com.example.ex9_sqlite

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ex9_sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // DBHelper 이용한 db 객체 생성
        val db: SQLiteDatabase = DBHelper(this).writableDatabase

        // db 생성
//        val db = openOrCreateDatabase("testdb", Context.MODE_PRIVATE, null)

        // 테이블 생성
        // execSQL → create, alter, drop, insert, update, delete 실행하는 함수
//        db.execSQL(
//            "create table USER_DB(" +
//                    "_id integer primary key autoincrement," +
//                    "name not null," +
//                    "phone)"
//        )

        // insert 사용 1 → execSQL
//        db.execSQL(
//            "insert into USER_DB(name, phone) values(?, ?)",
//            arrayOf("kim", "01025631478")
//        )

        // insert 사용 2 → ContentValue
//        val values = ContentValues()
//        values.put("name", "android")
//        values.put("phone", "01089891212")
//        db.insert("USER_DB", null, values)

        // select 사용 1 → rawQuery (반환값이 Cursor 객체(조회한 행의 집합)이다.)
//        val cursor = db.rawQuery("select * from USER_DB", null)

        // select 사용 2 → query
//        val cursor = db.query(
//            "USER_DB",
//            arrayOf("_id", "name", "phone"),
//            null,
//            null,
//            null,
//            null,
//            null
//        )

//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                // USER_DB 테이블의 컬럼이 _id(0), name(1), phone(2)
//                val id = cursor.getInt(0)
//                val name = cursor.getString(1)
//                val phone = cursor.getString(2)
//                Log.d("myLog", "[id : $id], [name : $name], [phone : $phone]")
//            }
//        }

        // 등록버튼 눌렀을 때 name, phone 값을 db에 저장
        // id가 user인 name, phone을 textview에 출력
        val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        binding.submit.setOnClickListener {
            manager.hideSoftInputFromWindow(
                currentFocus?.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )

            val name = binding.name.text.toString()
            val phone = binding.phone.text.toString()
            binding.user.text = "입력 하신 이름은 $name, 전화번호는 $phone 입니다."
            binding.name.text.clear()
            binding.phone.text.clear()

            db.execSQL(
                "insert into USER_DB(name, phone) values(?, ?)",
                arrayOf(name, phone)
            )

            val cursor = db.query(
                "USER_DB",
                arrayOf("name", "phone"),
                "phone = ?",
                arrayOf(phone),
                null,
                null,
                null
            )

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    val name = cursor.getString(0)
                    val phone = cursor.getString(1)
                    Log.d("myLog", "현재 입력한 데이터는 $name, $phone 입니다.")
                }
            }
        }
    }
}