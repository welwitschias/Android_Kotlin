package com.example.basickotlin

// 함수 : fun이라는 키워드를 이용하여 생성
// 반환 타입이 있다면 [:타입] 추가, 없다면 생략 가능
// 매개변수는 자동으로 val 키워드로 적용

// 함수 선언형식
// fun 함수명(매개변수명: 타입): 반환타입 {수행문}

// 반환타입과 매개변수가 있는 함수의 형태
fun add1(a: Int, b: Int): Int {
    return a + b
}

// 함수의 매개변수에 기본값 선언
fun add2(a: Int, b: Int = 20): Int {
    return a + b
}

// 반환타입과 매개변수가 없는 함수의 대표적인 형태 → main 함수
fun main() {
    // 수행문
    // 매개변수명을 생략해서 호출 → 순서대로 할당
    add1(1, 2)
    add2(10) // a=10, b=20(기본값)이 할당
    add2(10, 30) // a=10, b=30이 할당

    // 매개변수를 지정해서 호출
    add1(b = 3, a = 1)

    println("결과 확인 : " + add1(3, 4))
    println("결과 확인 : " + add2(15))
}