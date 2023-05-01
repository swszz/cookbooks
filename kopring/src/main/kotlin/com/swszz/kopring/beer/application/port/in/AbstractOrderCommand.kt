package com.swszz.kopring.beer.application.port.`in`

/**
 * @author: swszz
 */
abstract class AbstractOrderCommand(
        open val count: Int,
        open val options: MutableSet<String>) : Customizable {
    override fun customize(option: String) {
        option.also {
            options.add(it)
        }
    }

}