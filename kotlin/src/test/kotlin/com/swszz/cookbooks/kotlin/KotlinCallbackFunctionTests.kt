package com.swszz.cookbooks.kotlin

import org.junit.jupiter.api.Test

/**
 * @author: swszz
 */
class KotlinCallbackFunctionTests {

    @Test
    fun 콜백() {
        shout {
            println("함수 호출")
        }
    }

    // 파라미터가 없으면서 반환값이 없는 경우
    fun shout(callback: () -> Unit) {
        println("start!")
        callback()
        println("end")
    }
}