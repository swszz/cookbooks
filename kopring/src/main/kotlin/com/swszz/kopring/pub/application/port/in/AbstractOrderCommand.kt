package com.swszz.kopring.pub.application.port.`in`

/**
 * @author: swszz
 */
abstract class AbstractOrderCommand(
    open val orderKey: String?,
    open val count: Int,
    open val options: MutableSet<String>,
) : Customizable {
    override fun customize(option: String) {
        option.also {
            this.options.add(it)
        }
    }

}