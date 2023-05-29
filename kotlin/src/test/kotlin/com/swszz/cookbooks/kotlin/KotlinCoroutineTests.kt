package com.swszz.cookbooks.kotlin

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * @author: swszz
 */
class KotlinCoroutineTests {

    /**
     * launch : Launches a new coroutine without blocking the current thread and returns a reference to the coroutine as a Job. The coroutine is cancelled when the resulting job is cancelled.
     * async : Creates a coroutine and returns its future result as an implementation of Deferred. The running coroutine is cancelled when the resulting deferred is cancelled.
     *
     * launch : 반환값을 가지지 않음!
     * async : 반환값을 가짐!
     */


    @Test
    fun 코루틴() {
        runBlocking {
            val a = async { returnA() }
            val b = async { returnB() }

            println(a.await())
            println(b.await())
        }
    }

    suspend fun returnA(): String {
        delay(1000)
        return "A"
    }

    suspend fun returnB(): String {
        delay(1000)
        return "B"
    }
}