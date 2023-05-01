package com.swszz.kopring.pub.application.port.out

/**
 * @author: swszz
 */
interface LoadOrdersPort {

    /**
     * @Impl 주문 목록을 조회한다.
     * todo : 현재는 조건에 부합하는 주문의 수를 반환하지만, 후에는 실제 명세를 반환해야 한다.
     */
    fun loadOrders(loadOrdersQuery: LoadOrdersQuery) : Int
}