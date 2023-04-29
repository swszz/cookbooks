package com.swszz.kopring.beer.application.port.`in`

/**
 * @author: swszz
 */
interface OrderUseCase {
    fun order(orderCommand: OrderCommand): Boolean
}