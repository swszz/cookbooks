package com.swszz.kopring.beer.adapter.out.persistence

import com.swszz.kopring.beer.adapter.out.persistence.entity.Order
import com.swszz.kopring.beer.application.port.out.SaveOrderCommand
import com.swszz.kopring.beer.application.port.out.SaveOrderPort
import org.springframework.stereotype.Component

/**
 * @author: swszz
 */
@Component
class OrderPersistenceAdapter(val orderRepository: OrderRepository) : SaveOrderPort {
    override fun save(saveOrderCommand: SaveOrderCommand): Boolean {
        val order = saveOrderCommand.let {
            Order(type = it.type, size = it.size, count = it.count)
        }
        orderRepository.save(order)
        return true
    }
}