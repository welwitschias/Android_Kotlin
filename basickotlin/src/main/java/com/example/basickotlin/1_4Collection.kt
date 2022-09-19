package com.example.basickotlin

// 컬렉션 타입
// 배열(Array) : 같은 타입의 변수들로 이루어진 집합
// 배열요소(element) : 배열을 구성하는 각각의 값
// 인덱스(index) : 배열에서의 위치를 가리키는 숫자, 0부터 시작

// 배열 생성 : 1. Array 생성자 이용
// 크기가 3인 배열을 생성하고, 각 값은 0으로 초기화
val array: Array<Int> = Array(3, { 0 })

// 배열에 접근할 때 → []를 이용하거나 set(), get() 함수를 이용한다.
//fun main() {
//    // 배열에 값 할당
//    array[0] = 1
//    array[1] = 2
//    array.set(2, 3)
//
//    // 배열의 값을 확인
//    println("${array[0]}, ${array[1]}, ${array.get(2)}")
//
//    // 배열의 크기 확인
//    println(array.size)
//}

// 배열 생성 : 2. 기초 타입의 배열 생성
// 기초 타입명 + Array(배열의 크기, 초기값)
val boolArray: BooleanArray = BooleanArray(4, { false })
val charArray: CharArray = CharArray(2, { 'a' })

// arrayOf : 배열생성 함수
// 기초 타입 배열 생성
val intArray = intArrayOf(10, 20, 30, 40)
val boolArray2 = booleanArrayOf(true, false, true)

// arrayOf(element 설정)
val strArray = arrayOf("abc", "de", "fg")
val intArray2 = arrayOf(1, 2, 3)

// List, Set, Map
// List : 순서 있음, 데이터 중복 허용
// Set : 순서 없음, 데이터 중복 불가
// Map : key값과 value값으로 이루어진 데이터 집합, 순서 없음, key값 중복 불가
fun main() {
    // listOf : 불변
    var list = listOf<Int>(1, 2, 3)
//    list[0] = 4 → 불변이라 에러 발생

    // mutableListOf : 가변
    var list2 = mutableListOf<Int>(1, 2, 3)
    list2[0] = 4
    list2.set(1, 5)
    list2.add(3, 6)
    println("list2 = " + list2)
    println(list2.get(0) + list2[1])

    // mutableSetOf : 가변
    val set = mutableSetOf<Int>(5, 6, 7)
    set.add(5)
    set.add(6)
    set.add(8)
    println("set = " + set)

    // mutableMapOf : 가변
    val map = mutableMapOf<String, String>(Pair("first", "1"), "second" to "2")
    map.put("third", "3") // map은 add대신 put을 사용
    println("map = " + map)
    println(map.get("first") + ", " + map.get("second")) // key로 value 불러오기
    println(map.keys) // key 불러오기
}