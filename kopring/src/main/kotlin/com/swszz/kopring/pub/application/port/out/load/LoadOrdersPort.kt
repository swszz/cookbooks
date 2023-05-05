package com.swszz.kopring.pub.application.port.out.load

import com.swszz.kopring.pub.domain.Order

/**
 * @author: swszz
 */
interface LoadOrdersPort {

    /**
     * @Impl 주문 목록을 조회한다.
     */
    fun loadOrders(loadOrdersQuery: LoadOrdersQuery): MutableList<Order>
}