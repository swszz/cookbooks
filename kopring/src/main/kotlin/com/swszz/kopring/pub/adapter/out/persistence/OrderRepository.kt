package com.swszz.kopring.pub.adapter.out.persistence

import com.swszz.kopring.pub.adapter.out.persistence.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface OrderRepository : JpaRepository<Order, Long> {
    fun findByKeyEquals(key: String): Order?
    fun findAllByStatusEquals(status: com.swszz.kopring.pub.domain.Order.Status): MutableList<Order>
}