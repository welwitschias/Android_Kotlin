package com.example.ex6_jetpack_prac

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.State
import com.example.ex6_jetpack_prac.databinding.FragmentOneBinding
import com.example.ex6_jetpack_prac.databinding.ItemRecyclerviewBinding

// 항목 뷰를 가지는 역할
class MyViewHolder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

// 항목 구성자
class MyAdapter(val datas: MutableList<String>) : RecyclerView.Adapter<MyViewHolder>() {
    // 항목 뷰를 가지는 뷰 홀더를 준비하기 위해 자동 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    // 각 항목을 구성하기 위해 호출
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val binding = holder.binding
        // 뷰에 데이터 출력
        binding.itemData.text = datas[position]
    }

    // 항목 개수를 판단하기 위해 자동 호출
    override fun getItemCount(): Int {
        return datas.size
    }
}

// 리사이클러 뷰 꾸미기
class MyDecoration(val context: Context) : RecyclerView.ItemDecoration() {
    // 모든 항목이 출력된 후 호출
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: State) {
        super.onDrawOver(c, parent, state)

        // 뷰 크기 계산
        val width = parent.width
        val height = parent.height

        // 이미지 크기 계산
        val dr: Drawable? = ResourcesCompat.getDrawable(context.resources, R.drawable.kbo, null)
        val drWidth = dr?.intrinsicWidth
        val drHeight = dr?.intrinsicHeight

        // 이미지를 출력할 위치 계산
        val left = width / 2 - drWidth?.div(2) as Int
        val top = width / 2 - drHeight?.div(2) as Int

        // 이미지 출력
        c.drawBitmap(
            BitmapFactory.decodeResource(context.resources, R.drawable.kbo),
            left.toFloat(),
            top.toFloat(),
            null
        )
    }

    // 각 항목을 꾸미기 위해 호출
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view) + 1
        if (index % 3 == 0) {
            outRect.set(10, 10, 10, 60)
        } else {
            outRect.set(10, 10, 10, 0)
        }
        view.setBackgroundColor(Color.parseColor("#FFFFFF"))
        ViewCompat.setElevation(view, 20.0f)
    }
}

class OneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOneBinding.inflate(inflater, container, false)

        // 리사이클러 뷰를 위한 가상 데이터 준비
        val datas = mutableListOf<String>()
        for (i in 1..9) {
            datas.add("item ${i}")
        }

        // 리사이클러 뷰에 LayoutManager, Adapter, ItemDecoration 적용
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = MyAdapter(datas)
        binding.recyclerView.addItemDecoration(MyDecoration(activity as Context))

        return binding.root
    }

}