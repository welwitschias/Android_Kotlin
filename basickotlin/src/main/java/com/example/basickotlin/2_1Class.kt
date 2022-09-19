package com.example.basickotlin

// 클래스
class ClassBasic {
    // 클래스의 멤버
    // 변수
    var name = "길동"

    // 함수
    fun some() {
        print("name : ${name}")
    }

    // 내부 클래스
    class innerClass {}

    // 생성자
    // 주 생성자(필수 아님, 한 클래스에 하나만 생성 가능)와 보조 생성자로 구분
    constructor(name: String) {
        this.name = name
    }

    // 주 생성자 선언방법 : 1. constructor 키워드 선언
    class Tester1 constructor() {}

    // 주 생성자 선언방법 : 2. constructor 키워드 생략
    class Tester2() {}

    // 주 생성자 선언방법 : 3. 매개변수가 없는 주 생성자 자동 선언
    class Tester3 {}
}

class User(name: String, count: Int) {
    // init 키워드 : 주 생성자 본문 구현
    // 객체가 생성될 때 자동으로 실행
    init {
        println("객체 생성 시 자동으로 실행 : ${name}, ${count}")
    }

    var name2 = name
    var count2 = count
    fun test() {
        // 생성자 매개변수를 함수에서 사용
        // 1. 함수 내부에서 지역변수 선언 후 생성자 매개변수를 할당하여 사용
        println("테스트 함수에서 생성자의 매개변수 호출 : ${name2}, ${count2}")
    }
}

// 생성자 매개변수를 함수에서 사용
// 2. 생성자 매개변수를 val 키워드를 사용하여 선언
class User2(val name: String, val count: Int) {
    fun test2() {
        println("생성자 매개변수 출력 : ${name}, ${count}")
    }
}

// 보조 생성자 생성 : 클래스 내부에서 constructor 키워드를 사용, 여러개 생성 가능
class User3 {
    constructor(name: String) {
        println("보조 생성자 1 : ${name}")
    }

    constructor(name: String, count: Int) {
        println("보조 생성자 2 : ${name}, ${count}")
    }
}

// 보조 생성자 - 주 생성자 연결
class User4(name: String) {
    init {
        println("name : ${name}")
    }

    // 보조 생성자로 객체 생성 시 클래스 내에 주 생성자가 있다면 this() 이용하여 생성자를 호출
    constructor(name: String, count: Int) : this(name) {
        println("보조 생성자, 주 생성자 연결 : ${name}, ${count}")
    }

    constructor(name: String, count: Int, email: String) : this(name, count) {
        println("보조 생성자1, 보조 생성자2 연결 : ${name}, ${count}, ${email}")
    }
}

fun main() {
    var user = User("길동", 1)
    var user3_1 = User3("길동")
    var user3_2 = User3("길동", 1)
    var user4 = User4("길동", 1, "a@mail.com")
}