package com.swszz.cookbooks.kotlin

import org.junit.jupiter.api.Test

/**
 * @author: swszz
 */
class KotlinCollectionTests {
    @Test
    fun `리스트`() {
        val immutableList: List<Int> = listOf(1, 2, 3)
        val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)

        //fail
        //immutableList.add(1)

        println(immutableList)
        println(mutableList)
    }
}