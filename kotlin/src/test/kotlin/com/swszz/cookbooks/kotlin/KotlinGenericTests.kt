package com.swszz.cookbooks.kotlin

import org.junit.jupiter.api.Test

/**
 * @author: swszz
 */
class KotlinGenericTests {

    @Test
    fun 제네릭() {
        val box = Box(10)
        val box2 = Box("swszz")

        box.print()
        box2.print()
    }
}

class Box<T>(val value: T) {

    fun print() {
        when {
            (value is Int) -> {
                println("Integer")
            }

            (value is String) -> {
                println("String")
            }
        }
    }
}