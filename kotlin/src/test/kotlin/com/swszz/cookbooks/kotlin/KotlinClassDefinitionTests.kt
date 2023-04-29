package com.swszz.cookbooks.kotlin

import org.junit.jupiter.api.Test

/**
 * @author: swszz
 */
class KotlinClassDefinitionTests {

    @Test
    fun `클래스 비교`() {
        val swszz = Member("swszz", 1)
        val swszzz = Member("swszz", 1)

        println(swszz)
        println(swszzz)
        println(swszz == swszzz)

        println(swszz.hobby)
    }
}

data class Member(val name: String, val age: Int) {
    // 생성자 외 변수를 선언하고 싶을 경우
    // 클래스 외부에서 프로퍼티 세팅을 금지하고 싶을 경우
    // 클래스 외부에서 프로퍼티를 참조할 때, 참조값을 변경하고 싶은 경우 (hobby를 참조하면 루프에 빠짐)
    var hobby = "축구"
        private set
        get() = "취미 : $field"

    // 생성자 이외의 다른 작업을 하고 싶을 경우
    init {
        println(name)
    }
}

data class MemberNoGetter(private val name: String, private val age: Int)

