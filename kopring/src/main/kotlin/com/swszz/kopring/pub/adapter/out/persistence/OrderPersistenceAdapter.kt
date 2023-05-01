package com.swszz.kopring.pub.adapter.out.persistence

import com.swszz.kopring.pub.adapter.out.persistence.entity.CustomizedOptions
import com.swszz.kopring.pub.adapter.out.persistence.entity.Order
import com.swszz.kopring.pub.application.port.out.SaveOrderCommand
import com.swszz.kopring.pub.application.port.out.SaveOrderPort
import org.springframework.stereotype.Component

/**
 * @author: swszz
 */
@Component
class OrderPersistenceAdapter(val orderRepository: OrderRepository) : SaveOrderPort {
    override fun save(saveOrderCommand: SaveOrderCommand): Boolean {
        val order = saveOrderCommand.let {
            val options = CustomizedOptions(it.options)
            Order(type = it.type, size = it.size, count = it.count, options = options)
        }
        val saved = orderRepository.save(order)
        println(saved)
        return true
    }
}