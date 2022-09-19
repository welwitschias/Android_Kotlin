package com.example.basickotlin

// data class : 클래스 선언부 앞에 data 키워드 사용
class NonDataClass(val name: String, val email: String) {

}

data class DataClass(val name: String, val email: String) {

}

//fun main() {
//    val non1 = NonDataClass("철수", "a@mail.com")
//    val non2 = NonDataClass("철수", "a@mail.com")
//
//    val data1 = DataClass("철수", "a@mail.com")
//    val data2 = DataClass("철수", "a@mail.com")
//
//    // equals 비교
//    println(
//        """
//        class equals : ${non1.equals(non2)}
//        data class equals : ${data1.equals(data2)}
//    """.trimIndent()
//    )
//
//    // toString() → 객체의 데이터를 반환
//    println(
//        """
//        class toString() : ${non1.toString()}
//        data class toString() : ${data1.toString()}
//    """.trimIndent()
//    )
//}

open class Super3 {
    open var data = 1
    open fun add() {
        println(1 + 1)
    }
}

// object class : 상위 또는 인터페이스를 명시해준다
val obj = object : Super3() {
    override var data = 1
    override fun add() {
        println(1 + 1)
    }
}

// companion class : 멤버 변수나 함수를 클래스 이름으로 접근하고자 할 때 사용
class Companion {
    companion object {
        var compaData = 3
        fun some() {
            println(compaData)
        }
    }
}

fun main() {
    obj.data = 2
    obj.add()

    Companion.compaData
    Companion.some()
}