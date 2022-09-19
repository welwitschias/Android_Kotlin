package com.example.basickotlin

// 메인함수 실행 : Ctrl + Shift + F10 혹은 Run Icon Click
// 주석 : Ctrl + /
// 줄삭제 : Ctrl + y
// 줄이동 : Ctrl + Shift + 화살표 위/아래
// 코드정렬 : Ctrl + Alt + L
// 한줄복사 : Ctrl + D

// 변수
// 변수 선언 형식
// var (혹은 val) 변수명 : 타입 = 값

// var : 변수
var a: Int = 10

// val : 상수
val b: Int = 20

// 초기화 미루기 : 변수 선언 후 초기화 시 null로 선언할 필요가 없을 때 사용
// 1. lateinit : 최상단, 클래스 내부에서 초기화를 미룰 수 있다.(단, 기본타입은 안됨)
lateinit var late: String // 최상단에서 초기화 미루기

class variable {
    lateinit var late2: String // 클래스 내부에서 초기화 미루기
}

// 2. by lazy : 선언과 동시에 초기화를 해줌
// 호출 시점에서 최초 1회만 초기화가 됨 → 호출 시점에 초기화가 되기 때문에 초기화 미루기
val late2: Int by lazy {
    println("초기화 미루기 2번 입니다.")
    10
}

// 메인함수
fun main() {
    late = "초기화 미루기 1번 입니다."
    a = 11
//    b = 12 → 문법적 오류 발생
//    println("Hello World")
//    println(a + b)
    println(late)
    println(late2)
    println(late2)
}