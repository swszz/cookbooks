package com.swszz.kopring.beer.adapter.out.persistence

import com.swszz.kopring.beer.adapter.out.persistence.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface OrderRepository : JpaRepository<Order, Long>