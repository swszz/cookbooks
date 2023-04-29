package com.swszz.cookbooks.kotlin

import org.junit.jupiter.api.Test

/**
 * @author: swszz
 */
class KotlinNullSafetyTests {
    @Test
    fun `null safety String`() {
        // 널 가능!
        var name: String? = null
        name?.let {
            // null 이기 때문에 실행되지 않음!
            println(it)
        }
    }
}