package com.swszz.cookbooks.kotlin

import org.junit.jupiter.api.Test

/**
 * @author: swszz
 */
class KotlinAbstractionTests {
    @Test
    fun `상속과 인터페이스`(){
        val cat : Cat = Cat("miya")

        cat.bark()
        cat.move()

        if (cat is Animal) {
            cat.move()
        }
    }
}

interface Barkable {
    fun bark() : Unit
}
abstract class Animal(val sound : String) : Barkable{
    // open 예약어를 사용해야 상속 가능
    open fun move(){
        println("${sound}! move!")
    }
}

class Cat(sound: String) : Animal(sound) {
    override fun bark() {
        println("$sound !")
    }
}