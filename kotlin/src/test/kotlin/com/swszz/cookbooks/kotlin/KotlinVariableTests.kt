package com.swszz.cookbooks.kotlin

import org.junit.jupiter.api.Test

/**
 * @author: swszz
 */

//컴파일 타임 상수 (탑레벨 상수)
const val j: Int = 10

class KotlinVariableTests {
    @Test
    fun `변수 정의`() {
        var i: Int = 10
        var name: String = "swszz"
        var double: Double = 3.3

        println(i)
        println(name)
        println(double)
    }

    @Test
    fun `상수 정의`() {
        val i: Int = 10

        println(i)
        println(j)
    }

    @Test
    fun `형변환`() {
        var i = 10
        var k = 10L
        //fail
        // k = i
        //complete
        k = i.toLong();
    }

    @Test
    fun `문자열`() {
        val nickname: String = "swszz"
        println("제 닉네임은 $nickname 입니다.")
        println("제 닉네임은 ${nickname} 입니다.")
    }
}