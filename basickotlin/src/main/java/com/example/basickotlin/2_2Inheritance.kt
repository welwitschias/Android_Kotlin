package com.example.basickotlin

// 상속
// 부모 클래스 → open 키워드 사용
// 자식 클래스 → [클래스명 : 부모클래스]를 명시
open class Super(name: String) {
    init {
        println("부모 클래스 생성")
    }
}

class Sub(name: String) : Super(name) {
    init {
        println("자식 클래스 생성")
    }
}

// 자식 클래스에 보조 생성자만 있는 경우
class Sub2 : Super {
    constructor(name: String) : super(name) {
        println("자식 클래스 생성2")
    }
}

// 오버라이딩(재정의)
open class Super2 {
    // 변수에 open 키워드를 이용하여 작성
    var superData = 10
    open var superData2 = 10
    open fun testFun() {
        println("부모 클래스의 함수 호출 : ${superData2}")
    }
}

class Sub3 : Super2() {
    //    override var superData = 20 → 부모 클래스의 멤버가 open 상태가 아니라서 에러
    override var superData2 = 20
    override fun testFun() {
        println("자식 클래스의 함수 호출 : ${superData2}")
    }
}

//fun main() {
//    val sub = Sub("길동")
//    val sub2 = Sub2("길동2")
//    val sub3 = Sub3()
//    println(sub3.superData2)
//    sub3.testFun()
//}

// 접근 제한자 : public, internal, protected, private
// 최상단에서 선언할 경우
public var pub = 1 // 모든 파일에서 접근 가능(public 키워드 생략 가능)
internal var inter = 2 // 같은 모듈 내에서 접근 가능
private var pri = 3 // 해당 파일 내부에서만 접근 가능
//protected var pro = 4 → 최상단에서 작성 안됨

class Public {
    // 클래스 내부에서 선언할 경우
    public var pub2 = 1 // 모든 클래스에서 사용 가능
    internal var inter2 = 2 // 같은 모듈 내에서 접근 가능
    private var pri2 = 3 // 클래스 내부에서만 사용 가능
    protected var pro2 = 4 // 상속 관계의 하위(자식) 클래스에서만 사용 가능
}

open class Public2 {
    // 클래스 내부에서 선언할 경우
    open public var pub3 = 1 // 모든 클래스에서 사용 가능
    open internal var inter3 = 2 // 같은 모듈 내에서 접근 가능
    private var pri3 = 3 // 클래스 내부에서만 사용 가능, 상속 불가
    open protected var pro3 = 4 // 상속 관계의 하위(자식) 클래스에서만 사용 가능
}

class Child : Public2() {
    override var pub3 = 5
    override var inter3 = 6
    override var pro3 = 7
}

fun main() {
    var child = Child()
    println(child.pub3)
    println(child.inter3)
//    child.pro3 → 하위 클래스에서만 사용 가능하므로 에러 발생
}