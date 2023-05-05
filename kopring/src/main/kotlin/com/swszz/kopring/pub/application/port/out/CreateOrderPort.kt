package com.swszz.kopring.pub.application.port.out

import com.swszz.kopring.pub.domain.Order

/**
 * @author: swszz
 */
interface CreateOrderPort {
    fun createOrder(): Order
}