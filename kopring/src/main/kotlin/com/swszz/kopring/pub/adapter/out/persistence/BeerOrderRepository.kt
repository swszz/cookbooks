package com.swszz.kopring.pub.adapter.out.persistence

import com.swszz.kopring.pub.adapter.out.persistence.entity.BeerOrder
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface BeerOrderRepository : JpaRepository<BeerOrder, Long>