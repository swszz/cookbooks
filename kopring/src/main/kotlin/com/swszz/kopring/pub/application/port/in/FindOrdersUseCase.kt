package com.swszz.kopring.pub.application.port.`in`

import org.springframework.transaction.annotation.Transactional

/**
 * @author: swszz
 */
interface FindOrdersUseCase {
    /**
     * @Impl 주문 목록을 조회한다.
     * todo 현재는 조건에 부합하는 주문의 수를 반환하지만, 추후에는 실제 주문을 반환하도록 함
     */
    @Transactional(readOnly = true)
    fun findOrders(findOrdersQuery: FindOrdersQuery) : Int
}