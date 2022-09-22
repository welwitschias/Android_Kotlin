package com.example.ex5_noti

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.ex5_noti.databinding.ActivityMainBinding
import com.example.ex5_noti.databinding.DialogCustomBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 권한 체크
//        val status =
//            ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION")
//        if (status === PackageManager.PERMISSION_GRANTED) {
//            Log.d("myLog", "권한 허용")
//        } else {
//            Log.d("myLog", "권한 거부")
//        }

        // 권한 요청
        val reqPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                if (isGranted) {
                    Log.d("myLog", "권한을 허용하였습니다.")
                } else {
                    Log.d("myLog", "권한을 거부하였습니다.")
                }
            }
        reqPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")

        // 토스트 메시지 생성
        val toast = Toast.makeText(this, "권한을 허용해주세요.", Toast.LENGTH_SHORT)

        // 버튼 클릭 시 토스트 메시지 발생
        binding.toastBtn.setOnClickListener {
            toast.show()
        }

        // 토스트 메시지 콜백 기능 추가
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            toast.addCallback(
                object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d("myLog", "토스트가 사라짐")
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        Log.d("myLog", "토스트가 나타남")
                    }
                }
            )
        }

        // 데이트 피커 다이얼로그 사용
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            val datePicker = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
//                override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
//                    Log.d("myLog", "${year}년 ${month + 1}월 ${day}일")
//                }
//            }, 2022, 8, 22)
//
//            binding.dateBtn.setOnClickListener {
//                datePicker.show()
//            }
//        }

        // 데이트 피커 다이얼로그 사용(람다식 이용)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val datePicker = DatePickerDialog(
                this,
                { view, year, month, day -> Log.d("myLog", "${year}년 ${month + 1}월 ${day}일") },
                2022,
                8,
                22
            )

            binding.dateBtn.setOnClickListener {
                datePicker.show()
            }
        }

        // 타임 피커 다이얼로그 사용
//        binding.timeBtn.setOnClickListener {
//            TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
//                override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
//                    Log.d("myLog", "선택한 시간은 ${hour} : ${minute}")
//                }
//            }, 14, 25, true).show()
//        }

        // 타임 피커 다이얼로그 사용(람다식 이용)
        binding.timeBtn.setOnClickListener {
            TimePickerDialog(
                this,
                { view, hour, minute -> Log.d("myLog", "선택한 시간은 ${hour} : ${minute}") },
                14,
                25,
                true
            ).show()
        }

        // 알림창 띄우기
        binding.alertBtn.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("테스트 알림")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말 종료하시겠습니까?")
                setPositiveButton("확인", null)
                setNegativeButton("취소", null)
                setNeutralButton("자세히", null)
                show()
            }
        }

        // 목록을 출력하는 알림창
//        val items = arrayOf("사과", "바나나", "배", "키위")
//        binding.listBtn.setOnClickListener {
//            AlertDialog.Builder(this).run {
//                setTitle("다음 중 좋아하는 과일은?")
//                setItems(items, object : DialogInterface.OnClickListener {
//                    override fun onClick(dialog: DialogInterface?, idx: Int) {
//                        Log.d("myLog", "선택한 과일은 ${items[idx]}")
//                    }
//                })
//                setPositiveButton("확인", null)
//                show()
//            }
//        }

        // 목록을 출력하는 알림창(람다식 이용)
        val items = arrayOf("사과", "바나나", "배", "키위")
        binding.listBtn.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("다음 중 좋아하는 과일은?")
                setItems(
                    items
                ) { dialog, idx -> Log.d("myLog", "선택한 과일은 ${items[idx]}") }
                setPositiveButton("확인", null)
                show()
            }
        }

        // 체크박스를 이용한 다중 선택
//        binding.multiBtn.setOnClickListener {
//            AlertDialog.Builder(this).run {
//                setTitle("좋아하는 과일을 모두 고르시오.")
//                setMultiChoiceItems(
//                    items,
//                    booleanArrayOf(false, false, false, false),
//                    object : DialogInterface.OnMultiChoiceClickListener {
//                        override fun onClick(
//                            dialog: DialogInterface?,
//                            idx: Int,
//                            isChecked: Boolean
//                        ) {
//                            Log.d(
//                                "myLog",
//                                "${items[idx]}가(이) ${if (isChecked) "선택" else "선택 해제"}"
//                            )
//                        }
//                    })
//                setPositiveButton("확인", null)
//                show()
//            }
//        }

        // 체크박스를 이용한 다중 선택(람다식 이용)
        binding.multiBtn.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("좋아하는 과일을 모두 고르시오.")
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(false, false, false, false)
                ) { dialog, idx, isChecked ->
                    Log.d(
                        "myLog",
                        "${items[idx]}가(이) ${if (isChecked) "선택" else "선택 해제"}"
                    )
                }
                setPositiveButton("확인", null)
                show()
            }
        }

        // 라디오버튼을 이용한 단일 선택
        // 뒤로가기 버튼, 화면 바깥영역 터치 시 알림창 닫히지 않도록 설정하기
//        binding.singleBtn.setOnClickListener {
//            AlertDialog.Builder(this).run {
//                setTitle("좋아하는 과일을 하나만 고르시오.")
//                setSingleChoiceItems(items, 0, object : DialogInterface.OnClickListener {
//                    override fun onClick(dialog: DialogInterface?, idx: Int) {
//                        Log.d("myLog", "${items[idx]}가(이) 선택")
//                    }
//                })
//                setPositiveButton("확인", null)
//                setCancelable(false) // 뒤로가기 버튼 눌렀을 때 알림창 닫히지 않도록 설정
//                show()
//            }.setCanceledOnTouchOutside(false) // 화면 바깥영역 터치했을 때 알림창 닫히지 않도록 설정
//        }

        // 라디오버튼을 이용한 단일 선택(람다식 이용)
        binding.singleBtn.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("좋아하는 과일을 하나만 고르시오.")
                setSingleChoiceItems(
                    items, 0
                ) { dialog, idx -> Log.d("myLog", "${items[idx]}가(이) 선택") }
                setPositiveButton("확인", null)
                setCancelable(false) // 뒤로가기 버튼 눌렀을 때 알림창 닫히지 않도록 설정
                show()
            }.setCanceledOnTouchOutside(false) // 화면 바깥영역 터치했을 때 알림창 닫히지 않도록 설정
        }

        // 커스텀 다이얼로그 출력
//        binding.customBtn.setOnClickListener {
//            val dialogBinding = DialogCustomBinding.inflate(layoutInflater)
//            AlertDialog.Builder(this).run {
//                setTitle("커스텀 다이얼로그")
//                setView(dialogBinding.root)
//                setPositiveButton("확인", object : DialogInterface.OnClickListener {
//                    override fun onClick(p0: DialogInterface?, p1: Int) {
//                        if (dialogBinding.jja.isChecked === true) {
//                            Log.d("myLog", "짜장면 선택")
//                        } else {
//                            Log.d("myLog", "짬뽕 선택")
//                        }
//                    }
//                })
//                show()
//            }
//        }

        // 커스텀 다이얼로그 출력(람다식 이용)
        binding.customBtn.setOnClickListener {
            val dialogBinding = DialogCustomBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("커스텀 다이얼로그")
                setView(dialogBinding.root)
                setPositiveButton("확인") { p0, p1 ->
                    if (dialogBinding.jja.isChecked === true) {
                        Log.d("myLog", "짜장면 선택")
                    } else {
                        Log.d("myLog", "짬뽕 선택")
                    }
                }
                show()
            }
        }

    }
}