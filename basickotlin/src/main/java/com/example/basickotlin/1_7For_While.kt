package com.example.basickotlin

// 반복문
fun main() {
    // for 반복문 형태 : for (i in 범위) {수행문}
    for (i in 1..10) {
        print(" " + i)
    }
    println()

    for (i in 1 until 10) {
        print(" " + i)
    }
    println()

    for (i in 2..10 step 2) {
        print(" " + i)
    }
    println()

    for (i in 10 downTo 1) {
        print(" " + i)
    }
    println()

    // while 반복문 형태 : while (조건문) {수행문}
    // JAVA와 동일하여 생략

    // for문을 활용한 1부터 10까지 합 구하기
    var sum = 0
    for (i in 1..10) {
        sum += i
    }
    println(sum)

    // while문을 활용한 1부터 10까지 합 구하기
    var x = 0
    var sum2 = 0
    while (x < 10) {
        ++x
        sum2 += x
    }
    println(sum2)

    // indices → 컬렉션 타입의 인덱스
    var col = arrayOf(1, 2, 3)
    for (i in col.indices) {
        print(" ${col[i]}")
    }
    println()

    // withIndex() → 인덱스 + 실제 데이터
    for ((index, value) in col.withIndex()) {
        print("col.index = ${index}, col.value = ${value}\n")
    }
}