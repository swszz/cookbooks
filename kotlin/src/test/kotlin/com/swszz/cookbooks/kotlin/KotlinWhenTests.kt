package com.swszz.cookbooks.kotlin

import org.junit.jupiter.api.Test

/**
 * @author: swszz
 */
class KotlinWhenTests {

    @Test
    fun `조건문`() {
        val i = 5
        when {
            i < 5 -> println("i < 5")
            i >= 5 -> println("1 >= 5")
        }
    }

    @Test
    fun `조건문 with print`() {
        val i = 5
        val result: Int = when {
            i < 5 -> 10
            i >= 5 -> 100
            else -> 1000
        }

        println(result)
    }


}