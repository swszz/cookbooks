package com.swszz.cookbooks.kotlin

/**
 * @author: swszz
 */
class KotlinMethodTests {

    private fun add(a: Int, b: Int): Int {
        return a + b;
    }

    private fun add2(a: Int, b: Int): Int = a + b

    // default value
    private fun add3(a: Int, b: Int, c: Int = 0) = a + b + c
}