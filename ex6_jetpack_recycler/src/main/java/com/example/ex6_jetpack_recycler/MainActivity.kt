package com.example.ex6_jetpack_recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ex6_jetpack_recycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var adapter: MyAdapter
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 임의의 데이터 생성
        val datas = mutableListOf<String>()
        for (i in 1..10) {
            datas.add("item ${i}")

            // StaggeredGridLayoutManager 테스트용 데이터
//            if (i == 3 || i == 4 || i == 6 || i == 8) {
//                datas.add("동해물과 백두산이 마르고 닳도록")
//            } else {
//                datas.add("item ${i}")
//            }
        }

        // LinearLayoutManager 사용
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        binding.recyclerView.layoutManager = layoutManager

        // GridLayoutManager 사용
        // reverseLayout : true → 역방향, false → 정방향
//        val layoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false)
//        binding.recyclerView.layoutManager = layoutManager

        // StaggeredGridLayoutManager 사용
//        val layoutManager = StaggeredGridLayoutManager(
//            2, StaggeredGridLayoutManager.VERTICAL
//        )
//        binding.recyclerView.layoutManager = layoutManager

        // 리사이클러 뷰 적용
//        adapter = MyAdapter(datas)
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.adapter = adapter
//        binding.recyclerView.addItemDecoration(
//            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
//        )

        // 아이템 데코레이션 적용
//        binding.recyclerView.addItemDecoration(MyDecoration(this))

        // 뷰페이저2 적용 : 리사이클러 뷰 어댑터를 이용
//        adapter = MyAdapter(datas)
//        binding.viewPager.adapter = adapter

        // 뷰페이저2 적용 : 프래그먼트 어댑터를 이용
        binding.viewPager.adapter = MyFragmentPagerAdapter(this)

        // 새로운 아이템 추가
        binding.addItem.setOnClickListener {
            adapter.addItem()
        }

        // 아이템 삭제
        binding.removeItem.setOnClickListener {
            adapter.removeItem()
        }

        // drawer 메뉴 토글 버튼 적용
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.open, R.string.close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
    }

    // 메뉴에서 항목 선택 시 이벤트
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            Log.d("myLog", "토글 버튼 이벤트")
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}