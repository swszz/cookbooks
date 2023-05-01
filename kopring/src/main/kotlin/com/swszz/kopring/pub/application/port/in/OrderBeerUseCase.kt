package com.swszz.kopring.pub.application.port.`in`

import org.springframework.transaction.annotation.Transactional

/**
 * @author: swszz
 */
interface OrderBeerUseCase {
    @Transactional
    fun order(orderBeerCommand: OrderBeerCommand): Boolean
}