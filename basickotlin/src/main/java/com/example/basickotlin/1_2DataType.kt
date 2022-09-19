package com.example.basickotlin

// 문자열
// 삼중 따옴표 : 여러 줄을 표현할 때 사용
var str: String = """
    안녕하세요.
    안드로이드 스튜디오 입니다.
    오늘은 9월 16일 입니다.
""".trimIndent()

//fun main() {
//    // 문자열 템플릿 → 문자열 안에서 변수를 그대로 사용 가능
//    // 형태 : $변수명 or ${변수명}
//    println("삼중 따옴표 : ${str}")
//}

// Any : 모든 타입이 가능
var any1: Any = 10
var any2: Any = "any"
var any3: Any = true

class any4

var any5: Any = any4()

// Unit : 반환문이 없는 함수의 타입
fun unit1(): Unit {
    println("unit 타입 명시")
}

fun unit2() {
    println("unit 타입 생략")
}

// Nothing : null이나 예외를 리턴하는 타입
// 의도적으로 에러를 발생시킬 때 사용
fun fail1(): Nothing {
    throw IllegalAccessException("에러 발생")
}

fun fail2(): Nothing? {
    return null
}

// null 허용과 불허용
// 변수나 함수의 리턴값을 null로 받을 수 있다.
// 사용법 : 타입 뒤에 [?]를 붙인다.
var num1: Int = 10
var num2: Int? = 10

// 엘비스 연산자 → [?:]
val elvis: String = "elvis"
val elvisLengthIf = if (elvis != null) elvis.length else 0
val elvisLength = elvis?.length ?: 0

fun main() {
//    fail1()
//    num1 = null → null 불허용
    num2 = null
    println("elvisLengthIf : ${elvisLengthIf}")
    println("elvisLength : ${elvisLength}")
}